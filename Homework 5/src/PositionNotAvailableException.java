import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class PositionNotAvailableException extends Exception 
{
	/**
	 * check if there is a position available
	 * 
	 * @param s
	 *   throws a line to print out for this exception
	 */
	public PositionNotAvailableException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}
