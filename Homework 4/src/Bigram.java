import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class Bigram 
{
	private char first;
	private char second;
	
	/**
	 * default constructor for Bigram
	 * where no variables are set
	 */
	public Bigram ()
	{
		
	}
	
	/**
	 * Constructor in which you can set your variables
	 * for fields first and second. 
	 * 
	 * @param first
	 *   the first character in Bigram.
	 *   
	 * @param second
	 *   the second character in Bigram
	 */
	public Bigram( char first, char second )
	{
		this.first = first;
		this.second = second;
	}

	/**
	 * returns first character in Bigram. 
	 * 
	 * @return first
	 *   the first character in Bigram
	 */
	public char getFirst() 
	{
		return first;
	}

	/**
	 * sets new value for the first character
	 * 
	 * @param first
	 *   the new first character 
	 */
	public void setFirst(char first) 
	{
		this.first = first;
	}

	/**
	 * returns the second character in Bigram.
	 * 
	 * @return second 
	 *   the second character in Bigram
	 */
	public char getSecond() 
	{
		return second;
	}

	/**
	 * sets the new value for the second character
	 * 
	 * @param second
	 *   the new second character
	 */
	public void setSecond(char second) 
	{
		this.second = second;
	}

	/**
	 * returns the string representation of Bigram. 
	 * 
	 * @return 
	 *   the string representation of Bigram.
	 */
	@Override
	public String toString() 
	{
		return "Bigram [first=" + first + ", second=" + second + "]";
	}
	
	
}
