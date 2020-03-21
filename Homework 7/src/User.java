import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class User implements Serializable
{
	String user;
	int indexPos;
	static int userCount;
	ArrayList<User> following = new ArrayList<User>();
	ArrayList<User> followers = new ArrayList<User>();
	
	/**
	 * The default constructor that sets the name of the user
	 * and sets the indexPos of the object and User count
	 * 
	 * @param user
	 *   the name of this User object
	 */
	public User( String user )
	{
		this.user = user;
		indexPos = userCount;
		userCount++;
	}

	/**
	 * returns the user's name
	 * @return
	 *   name of the user
	 */
	public String getUser() 
	{
		return user;
	}

	/**
	 * returns the index of User
	 * 
	 * @return
	 *   index of the user
	 */
	public int getIndexPos()
	{
		return indexPos;
	}

	/**
	 * return userCount value
	 * 
	 * @return
	 *   the userCount value
	 */
	public static int getUserCount()
	{
		return userCount;
	}

	/**
	 * sets the User name to new value
	 * 
	 * @param user
	 *   the new user name
	 */
	public void setUser(String user)
	{
		this.user = user;
	}

	/**
	 * sets the index to a new index for the 
	 * User object
	 * 
	 * @param indexPos
	 *   the new index pos for the object
	 */
	public void setIndexPos(int indexPos)
	{
		this.indexPos = indexPos;
	}

	/**
	 * sets UserCount to new value 
	 * 
	 * @param userCount
	 *   new value for userCount
	 */
	public static void setUserCount(int userCount)
	{
		User.userCount = userCount;
	}

	/**
	 * returns the Following ArrayList for all the 
	 * people following this User
	 * 
	 * @return
	 *   the ArrayList of the Users following this User
	 */
	public ArrayList<User> getFollowing()
	{
		return following;
	}

	/**
	 * returns the ArrayList of followers for this User
	 * 
	 * @return
	 *   the ArrayList of followers for this User
	 */
	public ArrayList<User> getFollowers()
	{
		return followers;
	}

	/**
	 * sets the ArrayList of following to new value
	 * 
	 * @param follow
	 *   new array list of following
	 */
	public void setFollowing(ArrayList<User> follow)
	{
		this.following = follow;
	}

	/**
	 * sets the ArrayList of Followers to a new value
	 * 
	 * @param followers
	 *   new ArrayList of following 
	 */
	public void setFollowers(ArrayList<User> followers)
	{
		this.followers = followers;
	}
}
