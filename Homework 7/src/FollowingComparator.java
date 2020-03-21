import java.io.Serializable;
import java.util.Comparator;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FollowingComparator implements Comparator<User> 
{
	@Override
	public int compare(User first, User second) 
	{
		int size1 = first.getFollowing().size();
		int size2 = second.getFollowing().size();
		return size2 - size1 ;
	}

}
