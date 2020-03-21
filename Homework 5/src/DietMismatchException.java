import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class DietMismatchException extends Exception
{
	/**
	 * the exception throw if the animals diet doesn't match the prey
	 * 
	 * @param s
	 *   the default constructor for the exception to throw a string
	 *   if this exception is thrown
	 */
	public DietMismatchException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}
