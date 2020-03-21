import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 * 
 */
public class KeyTable
{
	private char[][] key;

	/**
	 * The default constructor for KeyTable that initializes
	 * the 5x5 matrix to manipulate on an use to encrypt
	 * and decrypt code.
	 * 
	 */
	public KeyTable()
	{
		key = new char[5][5];
	}

	/**
	 * Creates a new KeyTable object that creates the key
	 * with the given string
	 * 
	 * <dt>Precondition:
	 *   <dd>keyphrase is not null.
	 * 
	 * @param keyphrase
	 *   Gives the string keyphrase to put into the KeyTable 
	 *   object
	 *   
	 * @return table
	 *   returns a KeyTable object with the new key
	 */
	public static KeyTable buildFromString(String keyphrase) 
	{

		if ( keyphrase.equals( null ) ) 
		{
			throw new IllegalArgumentException();
		}

		KeyTable table = new KeyTable();
		keyphrase = keyphrase.replace( 'J', 'I' );
		String mod = "";

		for (char c : keyphrase.toCharArray())
		{
			String s = Character.toString(c);
			if ( Character.isLetter(c) && !mod.contains(s) && c != ' ')
			{
				mod += s;
			}
		}

		String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

		for (char c : alphabet.toCharArray())
		{
			String s = Character.toString(c);
			if (!mod.contains(s) ) 
			{
				mod += s;
			}
		}

		char[] modArray = mod.toCharArray();
		int x = 0;
		for ( int row = 0; row < table.key.length; row++ )
		{
			for( int col = 0; col < table.key[row].length; col++)
			{
				table.key[row][col] = modArray[x];
				x++;
			}
			
		}
		return table;
	}

	/**
	 * returns the key matrix field.
	 * 
	 * @return key
	 *   return the matrix in key object
	 */
	public char[][] getKeyTable()
	{
		return key;
	}

	/**
	 * returns the row that character c appears
	 * 
	 * @param c
	 *   the character for which row it finds
	 *   
	 * <dt>Precondition:
	 *   <dd>c is a valid letter in the key object.
	 *   
	 * @return r
	 *   the row index of character c
	 *   
	 * @throws IllegalArgumentException
	 *   thrown if c doesn't exist in matrix.
	 */
	public int findRow(char c)
	{
		int r = -1;
		for (int row = 0; row < key.length; row++)
		{
			for (int col = 0; col < key[0].length; col++)
			{
				if (key[row][col] == c) 
				{
					r = row;
				}
			}
		}

		if (r == -1) 
		{
			throw new IllegalArgumentException();
		}

		return r;
	}

	/**
	 * returns the column that character c appears
	 * 
	 * @param c
	 *   the character for which column it finds
	 *   
	 * <dt>Precondition:
	 *   <dd>c is a valid letter in the key object.
	 *   
	 * @return r
	 *   the row index of character c
	 *   
	 * @throws IllegalArgumentException
	 *   thrown if c doesn't exist in matrix.
	 */
	public int findCol(char c) 
	{
		int column = -1;
		for (int row = 0; row < key.length; row++) 
		{
			for (int col = 0; col < key[0].length; col++)
			{
				if (key[row][col] == c) 
				{
					column = col;
				}
			}
		}

		if (column == -1)
		{
			throw new IllegalArgumentException();
		}

		return column;
	}

	/**
	 * the default KeyTable is printed out
	 * 
	 * @return 
	 *   the String format of KeyTable object
	 */
	@Override
	public String toString()
	{
		return "KeyTable [getKeyTable()=" + Arrays.toString(getKeyTable()) 
			+ "]";
	}

}
