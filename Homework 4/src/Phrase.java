import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class Phrase extends LinkedList<Bigram>
{
	
	/**
	 * adds a new Bigram at the end of Phrase object.
	 * 
	 * @param b
	 *   the Bigram to be added to phrase.
	 */
	public void enqueue( Bigram b )
	{
		add(b);
	}
	
	/**
	 * returns and removes the first Bigram in phrase.
	 * 
	 * @return 
	 *   the removed Bigram in phrase. 
	 */
	public Bigram dequeue()
	{
		return pop();
	}
	
	/**
	 * returns the value in the first Bigram in phrase
	 * 
	 * @return
	 *   the value in the first Bigram
	 */
	public Bigram peek()
	{
		return getFirst();
	}
	
	/**
	 * Creates and returns a phrase object that is a queue with
	 * a list of Bigrams that represent String s.
	 * 
	 * @param s
	 *   the string used to represent the Bigram queue.
	 *   
	 * @return ph
	 *   the phrase object that is created from the String
	 *   s.
	 */
	public static Phrase buildPhraseFromStringforEnc( String s )
	{
		Phrase ph = new Phrase();
		s = s.toUpperCase();
		s = s.replaceAll("J","I");
		
		String mod = "";

		for ( int x = 0; x < s.length(); x++ )
		{
			if( Character.isLetter( s.charAt(x) ) )
			{
				if( x != 0 )
				{
					if( s.charAt(x) == s.charAt( x - 1 ) )
					{
						mod += "X";
					}
				}
				mod += s.charAt(x);
			}
		}
		
		if( mod.length() % 2 == 1 )
		{
			mod += 'X';
		}
		
		char[] modArray = mod.toCharArray();
	
		for( int x = 0; x < modArray.length; x = x + 2 )
		{
			char first = modArray[x];
			char second = modArray[x + 1];
			Bigram b = new Bigram();
	    	b.setFirst(first);
			b.setSecond(second);
			ph.enqueue(b);	
		}
		return ph;
	}
	
	/**
	 * returns a Phrase object that has been created by encrypting
	 * this phrase object.
	 * 
	 * @param key
	 *   the KeyTable used to encrypt this Phrase.
	 *   
	 * <dt>Precondition:
	 *   <dd>key is not null.
	 *   
	 * @return ph
	 *   the new Phrase object that is created by encrypting
	 *   this Phrase object. 
	 *   
	 * @throws IllegalArgumentException
	 *   thrown if key is null. 
	 */
	public Phrase encrypt( KeyTable key )
	{
		if( key == null )
		{
			throw new IllegalArgumentException();
		}
		
		Phrase ph = new Phrase();
		
		Bigram b;
		while ( !isEmpty() )
		{
			b = remove();
			char ch1 = b.getFirst();
			char ch2 = b.getSecond();
			if( key.findCol(ch1) == key.findCol(ch2) )
			{
				ph.enqueue( encTopToBottom( b, key ) );
			}
			else if( key.findRow(ch1) == key.findRow(ch2))
			{
				ph.enqueue( encSideToSide( b, key ));
			}
			else
			{
				ph.enqueue( cornerToCorner( b, key ));
			}
			
		}
		
		return ph;
	}
	
	/**
	 * Helper Method: Encrypts the bigram that has its letters 
	 * in the same row and returns the encrypted bigram. 
	 *  
	 * @param a
	 *   the bigram that is going to be encrypted. 
	 *   
	 * @param key 
	 *   the key used for encryption
	 *   
	 * @return b
	 *   the encrypted bigram.
	 */
	private Bigram encSideToSide( Bigram a, KeyTable key )
	{
		Bigram b; 
		
		char ch1 = a.getFirst();
		char ch2 = a.getSecond();
		
		char[][] keyArray = key.getKeyTable();
		int row = key.findRow( ch1 );
		
		if( key.findCol(ch1) + 1 == 5 )
		{
			ch1 = keyArray[row][0];
		}
		else
		{
			ch1 = keyArray[row][key.findCol(ch1) + 1];
		}
		if( key.findCol(ch2) + 1 == 5 )
		{
			ch2 = keyArray[row][0];
		}
		else
		{
			ch2 = keyArray[row][key.findCol(ch2) + 1];
		}
		
		b = new Bigram( ch1, ch2 );
		
		return b;
	}
	
	/**
	 * Helper Method: Encrypts the bigram that has its letters in 
	 * the same column and returns the encrypted bigram. 
	 *  
	 * @param a
	 *   the bigram that is going to be encrypted. 
	 *   
	 * @param key 
	 *   the key used for encryption
	 *   
	 * @return b
	 *   the encrypted bigram.
	 */
	private Bigram encTopToBottom( Bigram a, KeyTable key )
	{
		Bigram b; 
		
		char ch1 = a.getFirst();
		char ch2 = a.getSecond();
		
		
		char[][] keyArray = key.getKeyTable();
		int col = key.findCol( ch1 );
		
		if( key.findRow(ch1) + 1 == 5 )
		{
			ch1 = keyArray[0][col];
		}
		else
		{
			ch1 = keyArray[key.findRow(ch1) + 1][col];
		}
		
		if( key.findRow(ch2) + 1 == 5 )
		{
			ch2 = keyArray[0][col];
		}
		else
		{
			ch2 = keyArray[key.findRow(ch2) + 1][col];
		}
		
		b = new Bigram( ch1, ch2 );
		
		return b;
	}
	
	/**
	 * Helper Method: Can be used to encrypt or decrypt and Bigram
	 * where the characters are neither in the same row or column and 
	 * returns the encrypted or decrypted Bigram. 
	 * 
	 * @param a
	 *   the Bigram to be encrypted or decrypted.
	 *   
	 * @param key
	 *   the key used for encryption or decryption.
	 *   
	 * @return b
	 *   the decrypted or encrypted Bigram. 
	 */
	private Bigram cornerToCorner( Bigram a, KeyTable key )
	{
		Bigram b;
		char ch1 = a.getFirst();
		char ch2 = a.getSecond();
		
		
		int row1 = key.findRow( ch1 );
		int col1 = key.findCol( ch1 );
		
		int row2 = key.findRow( ch2 );
		int col2 = key.findCol( ch2 );
		
		char[][] keyArray = key.getKeyTable();
		
		ch1 = keyArray[row1][col2];
		ch2 = keyArray[row2][col1];
		
		b = new Bigram(ch1, ch2);
		
		return b;
		
	}
	
	/**
	 * Decrypts this phrase and stores the decrypted bigrams into
	 * a new Phrase queue object and returns that object. 
	 * 
	 * @param key
	 *   the key used to decryt the Phrase.
	 *   
	 * <dt>Precondition:
	 *   <dd>key is not null.
	 *   
	 * @return ph
	 *   the new Phrase object that is a queue of Bigram objects 
	 *   that represent the decrypted version of this Phrase.
	 *   
	 * @throw IllegalArgumentException
	 *   thrown if key is null. 
	 */
	public Phrase decrypt( KeyTable key )
	{
		if( key == null )
		{
			throw new IllegalArgumentException();
		}
		
		Phrase ph = new Phrase();
		
		Bigram b;
		while ( !isEmpty() )
		{
			b = remove();
			char ch1 = b.getFirst();
			char ch2 = b.getSecond();
			if( key.findCol(ch1) == key.findCol(ch2) )
			{
				ph.enqueue( decTopToBottom( b, key ) );
			}
			else if( key.findRow(ch1) == key.findRow(ch2))
			{
				ph.enqueue( decSideToSide( b, key ));
			}
			else
			{
				ph.enqueue( cornerToCorner( b, key ));
			}
		}
		return ph;
	}
	
	/**
	 * Helper Method: Decrypts the bigram that has its letters 
	 * in the same row and returns the decrypted bigram. 
	 *  
	 * @param a
	 *   the bigram that is going to be decrypted. 
	 *   
	 * @param key 
	 *   the key used for decryption
	 *   
	 * @return b
	 *   the decrypted bigram.
	 */
	private Bigram decSideToSide( Bigram a, KeyTable key )
	{
		Bigram b; 
		
		char ch1 = a.getFirst();
		char ch2 = a.getSecond();
		
		
		char[][] keyArray = key.getKeyTable();
		int row = key.findRow( ch1 );
		
		if( key.findCol(ch1) == 0 )
		{
			ch1 = keyArray[row][4];
		}
		else
		{
			ch1 = keyArray[row][key.findCol(ch1) - 1];
		}
		if( key.findCol(ch2) == 0 )
		{
			ch2 = keyArray[row][4];
		}
		else
		{
			ch2 = keyArray[row][key.findCol(ch2) - 1];
		}
		
		b = new Bigram( ch1, ch2 );
		
		return b;
	}
	
	/**
	 * Helper Method: Decrypts the bigram that has its letters 
	 * in the same column and returns the decrypted bigram. 
	 *  
	 * @param a
	 *   the bigram that is going to be decrypted. 
	 *   
	 * @param key 
	 *   the key used for decryption
	 *   
	 * @return b
	 *   the decrypted bigram.
	 */
	private Bigram decTopToBottom( Bigram a, KeyTable key )
	{
		Bigram b; 
		
		char ch1 = a.getFirst();
		char ch2 = a.getSecond();
		
		char[][] keyArray = key.getKeyTable();
		int col = key.findCol( ch1 );
		
		if( key.findRow(ch1) == 0 )
		{
			ch1 = keyArray[4][col];
		}
		else
		{
			ch1 = keyArray[key.findRow(ch1) - 1][col];
		}
		
		if( key.findRow(ch2) == 0 )
		{
			ch2 = keyArray[4][col];
		}
		else
		{
			ch2 = keyArray[key.findRow(ch2) - 1][col];
		}
		
		b = new Bigram( ch1, ch2 );
		return b;
	}

	/**
	 * returns the string representation of the phrase
	 * object.
	 * 
	 * @return
	 *   the string representation of the phrase object. 
	 */
	@Override
	public String toString()
	{
		return "Phrase [ first=" + getFirst() + ", last=" + getLast() 
				+ ", modCount=" + modCount + "]";
	}
	
	
}
