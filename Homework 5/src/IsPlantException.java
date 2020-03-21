import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class IsPlantException extends Exception 
{
	/**
	 * checks if this is a plant and throws an exception 
	 * if its not supposed to be a plant
	 * 
	 * @param s
	 *   the parameter for throwing a string for this exception
	 */
	public IsPlantException(String s) 
    { 
        // Call constructor of parent Exception 
        super(s); 
    } 
}
