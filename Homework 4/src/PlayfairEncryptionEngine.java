import java.util.*;

/**
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class PlayfairEncryptionEngine 
{
	/**
	 * The main method for this program. The main method prompts 
	 * the user to first create the key and then later choose from five 
	 * options for whether they want to print the key, change the key, 
	 * encrypt a word, decrypt a work, or quit from the program. 
	 * 
	 * @param args
	 *   this is the default parameter for the main method. 
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		KeyTable key = new KeyTable();
		
		System.out.print("\nEnter key phrase: ");
	
		String str = in.nextLine().toUpperCase();
		key = KeyTable.buildFromString( str );
		System.out.print("\nGeneration Success!");
		
		do
		{
			System.out.print("\n");
			System.out.print("\nMenu:");
			System.out.print("\n(CK) - Change key");
			System.out.print("\n(PK) - Print key");
			System.out.print("\n(EN) - Encrypt");
			System.out.print("\n(DE) - Decrypt");
			System.out.print("\n(Q) - Quit");
			System.out.print("\n");
			System.out.print("\nPlease select an option: ");
			
			String response = in.next().toLowerCase();
			System.out.print("\n");
			
			switch( response )
			{
			case "pk":
				for( int r = 0; r < key.getKeyTable().length; r++ )
				{
					for( int c = 0; c < key.getKeyTable()[0].length; c++ )
					{
						System.out.print(key.getKeyTable()[r][c] + " ");
					}
					System.out.println();
				}
				break;
			case "ck":
				try
				{
					System.out.print("\nEnter key phrase: ");
					in.nextLine();
					String s = in.nextLine().toUpperCase();
					
					KeyTable temp = KeyTable.buildFromString( s );
					key = temp;
					
					System.out.print("\nGeneration Success!");
				}
				catch( IllegalArgumentException e) 
				{
					System.out.print( "\nKey is Empty!");
				}
				break;
			case "en":
				System.out.print("\nPlease enter a phrase to encrypt: ");
				in.nextLine();
				String s = in.nextLine().toUpperCase();
				
				Phrase p = new Phrase();
				p = Phrase.buildPhraseFromStringforEnc( s );
				
				Phrase k = p.encrypt( key );
				
				System.out.print("\nEncrypted text is: ");
				String enc = "";
				Bigram b;
				while( k.size() != 0 )
				{
					b = k.dequeue();
					char first = b.getFirst();
					char second = b.getSecond();
					enc += first;
					enc += second;
				}
				System.out.print( enc );
				
				break;
			case "de":
				System.out.print("\nPlease enter a phrase to decrypt: ");
				in.nextLine();
				try
				{
					String s2 = in.nextLine().toUpperCase();
					Phrase decWord = new Phrase();
				
					char[] s2Array = s2.toCharArray();
					for( int x = 0; x < s2Array.length; x = x + 2 )
					{
						char first = s2Array[x];
						char second = s2Array[x + 1];
						Bigram c = new Bigram();
			    		c.setFirst(first);
						c.setSecond(second);
						decWord.enqueue(c);	
					}
					decWord = decWord.decrypt(key);
					System.out.print("\nDecrypted text is: ");
				
					String dec = "";
					Bigram e;
				
					while( decWord.size() != 0 )
					{
						e = decWord.dequeue();
						char first = e.getFirst();
						char second = e.getSecond();
						dec += first;
						dec += second;
					}
				
					System.out.print( dec );
				}
				catch( Exception e )
				{
					System.out.print( "\nCan't have J and/or text needs to be even" );
				}
				break;
			default:
				if (response.equals("q"))
				{
					quit = true;
					System.out.print("\nProgram terminating...");
				}
				break;
			}
		}
		while( quit == false );
	}
}
