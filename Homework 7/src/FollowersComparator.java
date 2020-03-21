import java.util.Comparator;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FollowersComparator implements Comparator<User>
{
	/**
	 * Compares two users based on their Followers count
	 * 
	 * @param first
	 *   the first User for which the followers are collected
	 * 
	 * @param second 
	 *   the second User for which the followers are collected
	 */
	@Override
	public int compare(User first, User second) 
	{
		int size1 = first.getFollowers().size();
		int size2 = second.getFollowers().size();
		return size2 - size1 ;
	}

}
