import java.util.Comparator;
/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class NameComparator implements Comparator<User>
{
	/**
	 * Users compared based on their name
	 * 
	 * @param first
	 *   the first User compared based on their name
	 *   
	 * @param second 
	 *   the second User compared based on their name 
	 */
	@Override
	public int compare(User first, User second) 
	{
		String a = first.getUser();
		String b = second.getUser();
		return a.compareToIgnoreCase( b );
	}

}
