import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FollowGraph implements Serializable
{
	private ArrayList<User> users;
	public static final int MAX_USERS = 100;
	private boolean[][] connections;

	/**
	 * Default Constructor that initializes the ArrayList and 
	 * connections array
	 */
	public FollowGraph()
	{
		users = new ArrayList<User>();
		connections = new boolean[ MAX_USERS ][ MAX_USERS ];
	}
	
	/**
	 * returns the index of User with the given userName
	 * 
	 * <dt>Preconditions: 
	 *   <dd>checks to see if user exists if it doesn't return
	 *   -1
	 * @param userName
	 *   the UserName of the user wanted to be found
	 *   
	 * @return
	 *   the index of user in users
	 */
	private int findUser( String userName )
	{
		int i = -1;
		for( int ind = 0; ind < users.size(); ind++ )
		{
			if( users.get(ind).getUser().equals( userName ) )
			{
				i = ind;
			}
		}
		return i;
	}
	
	/**
	 * adds userName to users
	 * 
	 * <dt>Preconditions:
	 *   <dd>the size of users is already full or the user with
	 *   the given name already exists in the graph
	 *   
	 * @param userName
	 *   the user's name for the user that wants to be added
	 */
	public void addUser( String userName )
	{
		int i = findUser( userName );
		
		if( users.size() == MAX_USERS )
		{
			System.out.print("\nNo more people can be added!");
			System.out.print("\n");
			return;
		}
		
		if( i == -1 ) 
		{
			User a = new User( userName );
			users.add( a );
		}
		
		//System.out.print( findUser(userName) +" ");
//		followers.put( userName, 0 );
//		following.put( userName, 0 );
	}
	
	/**
	 * adds a connections between two users starting from userFrom
	 * to userTo
	 * 
	 * <dt>Preconditions:
	 *   <dd>checks to see if both users exist and sees if there is 
	 *   a connection already between both users
	 *   
	 * @param userFrom
	 *   the source of the connections
	 *   
	 * @param userTo
	 *   the destination of the connection
	 */
	public void addConnection( String userFrom, String userTo )
	{	
		int from = findUser( userFrom );
		int to = findUser( userTo );
		
		//System.out.println( from + " " + to );
		if( from == -1 || to == -1 )
		{
			
			System.out.print("\nERROR: Users do not exist");
			System.out.print("\n");
			return;
		}
		
		if( users.get( from ).getFollowing().contains(users.get( to )))
		{
			System.out.print( "\nERROR: Connection already does exist");
			System.out.print("\n");
			return;
		}
		
//		if( connections[from][to] == true )
//		{
//			System.out.print( "\nERROR: Connection already exists");
//			System.out.print("\n");
//			return;
//		}
		
		connections[from][to] = true;
		
//		followers.put( userTo, followers.get( userTo ) + 1 );
//		following.put( userFrom, following.get( userFrom ) + 1 );
		users.get( to ).getFollowers().add( users.get( from ) );
		users.get( from ).getFollowing().add( users.get( to ) );
	}
	
	/**
	 * removes a user with the given userName from the graph as well
	 * as removes all connection to and from that user
	 * 
	 * <dt>Preconditions:
	 *   <dd>checks to see if the user doesn't exist in the graph
	 *   
	 * @param userName
	 *   the name of the user wanted to be removed
	 */
	public void removeUser( String userName )
	{
		boolean[][] temp = new boolean[100][100];
		
		int i = findUser( userName );
		
		if( i == -1 )
		{
			System.out.print( "\nERROR: User already doesn't exist");
			System.out.print("\n");
			return;
		}
		
		User removed = users.remove(i);
		
		
		for( int row = 0; row < connections.length; row++ )
		{
			for( int col = 0; col < connections[0].length; col++ )
			{
				int r = 0;
				int c = 0;
				
				if( row < i )
				{
					r = row;
				}
				else if( row > i )
				{
					r = row - 1;
					User.userCount--;
				}
				
				if( col > i )
				{
					c = col - 1;
					User.userCount--;
				}
				else if( col < i )
				{
					c = col;
					
				}
				
				temp[r][c] = connections[row][col];	
			}
		}
		connections = temp;
		
		for( User u : users )
		{
			if( u.getFollowers().contains(removed ));
			{
				u.getFollowers().remove( removed );
			}
			if( u.getFollowing().contains( removed ));
			{
				u.getFollowing().remove( removed );
			}
		}
	}
	
	/**
	 * removes a connection from the the userFrom user to the 
	 * userTo user
	 * 
	 * <dt>Preconditions:
	 *   <dd>checks to see if both users exists and already
	 *   don't have a connections
	 *   
	 * @param userFrom
	 *   the source of the connection
	 *   
	 * @param userTo
	 *   the destination of the connection
	 */
	public void removeConnection( String userFrom, String userTo )
	{
		int from = findUser( userFrom );
		int to = findUser( userTo );
		
		if( from == -1 || to == -1 )
		{
			System.out.print("\nERROR: Users do not exist");
			System.out.print("\n");
			return;
		}
		
		if( !users.get( from ).getFollowing().contains(users.get( to )))
		{
			System.out.print( "\nERROR: Connection already doesn't exist");
			System.out.print("\n");
			return;
		}
//		if( connections[from][to] == false )
//		{
//			System.out.print( "\nERROR: Connection already doesn't exist");
//			System.out.print("\n");
//			return;
//		}
		
		connections[from][to] = false;
		
//		followers.put( userTo, followers.get( userTo ) - 1 );
//		following.put( userFrom, following.get( userFrom ) - 1 );
		users.get( to ).getFollowers().remove( users.get( from ) );
		users.get( from ).getFollowing().remove( users.get( to ) );
	}
	
	/**
	 * displays the shortest path from one user to another user
	 * and gives all the intermediate steps. If multiple exists it 
	 * takes only one path
	 * 
	 * @param userFrom
	 *   the source of the connection
	 *   
	 * @param userTo
	 *   the destination of the connection
	 *   
	 * @return
	 *   the shortest distance from the given source of a connection
	 *   to the the given destination of the connection
	 *   
	 * @throws IOException 
	 *   if user doesn't exist
	 */
	public String shortestPath( String userFrom, String userTo ) 
			throws IOException
	{
		int from = findUser( userFrom );
		int to = findUser( userTo );
		
		if( from == -1 || to == -1 )
		{
			throw new IOException();
		}
		
		double[][] dist = new double[users.size()][users.size()];
		User[][] next = new User[users.size()][users.size()];
		
		for( int row = 0; row < connections.length; row ++ )
		{
			for( int col = 0; col < connections[0].length; col ++ )
			{
				if( connections[row][col] == true )
				{
					dist[row][col] = 1;
					next[row][col] = users.get(col);
				}
			}
		}
		
		for( int k = 1; k < users.size(); k++ )
		{
			for( int i = 1; i < users.size(); i++ )
			{
				for( int j = 1; j < users.size(); j++ )
				{
					if( dist[i][j] > dist[i][k] + dist[k][j])
					{
						dist[i][j] = dist[i][k] + dist[k][j];
						next[i][j] = next[i][k];					
					}
				}
			}
		}
		
		if( next[from][to] == null )
		{
			return null;
		}
		
		String path = userFrom;
		
		while( from != to )
		{
			
			
		}
		
		return path; 
		
	}
	
	
	
	/**
	 * gives all paths from the given user userFrom to the given user
	 * userTo and gives all the intermediate step for each path
	 * 
	 * @param userFrom
	 *   the source of the connection
	 *   
	 * @param userTo
	 *   the destination of the connection
	 *   
	 * @return
	 *   the Arraylist for all the path from source to destination
	 */
	public ArrayList<String> allPaths( String userFrom, String userTo )
	{
		return null;
	}
	
	/**
	 * prints out all the users by using the given comparator that
	 * compares each user object depending on their follower, following, 
	 * or name
	 * 
	 * @param comp
	 *   the wanted comparator to comapare each user
	 */
	public void printAllUsers( Comparator comp )
	{
		ArrayList<User> temp = users;
		Collections.sort( temp, comp );
		
		System.out.printf("%5s %25s %25s", "Users:", "Number of Followers", 
				"Number Following");
		System.out.println();
		
		for( User u : temp )
		{
			String use = u.getUser();
//			System.out.format("%5s %25d %25d", use, followers.get( use ), 
//					following.get(use) );
			System.out.format("%5s %25d %25d", use, u.getFollowers().size(), 
					u.getFollowing().size() );
			System.out.println();
		}
	}
	
	/**
	 * prints all followers to a user
	 * 
	 * <dt>Preconditions:
	 *   <dd>checks to see if user exists
	 *   
	 * @param userName
	 *   the name of the user
	 */
	public void printAllFollowers( String userName )
	{
		int i = findUser( userName );
		
		if( i != -1 )
		{
			for( int col = 0; col < connections[i].length; col ++ )
			{
				if( connections[i][col] == true)
				{
					System.out.print( "\n" + users.get(col) + " ");
				}
			}
		}
	}
	
	/**
	 * prints all the users this user is following
	 * 
	 * <dt>Preconditions:
	 *   <dd>checks to see if this user exists
	 *   
	 * @param userName
	 *   the name of this user 
	 */
	public void printAllFollowing( String userName )
	{
		int i = findUser( userName );
		
		if( i != -1)
		{
			for( int row = 0; row < connections.length; row ++ )
			{
				if( connections[row][i] == true)
				{
					System.out.print( "\n" + users.get(row) + " ");
				}
			}
		}
	}
	
	/**
	 * finds all paths that go from this user back to user
	 * basically setting both to source and destination
	 * 
	 * @return
	 *   ArrayList of all the loops of one the different loops in 
	 *   a FollowGraph
	 */
	public ArrayList<String> findAllLoops()
	{
		return null;
	}

	/**
	 * loads all users that are given in a certain text
	 * 
	 * <dt>Precondition:
	 *   <dd>checks to see if the file is valid
	 *   
	 * @param filename
	 *   the name of the file that has all the users
	 */
	public void LoadAllUsers( String filename )
	{
		File file = new File( filename );
		try 
		{
			Scanner stdin = new Scanner(file);
			while( stdin.hasNextLine() )
			{
				String user = stdin.nextLine();
				addUser( user );
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print( "ERROR: invalid file name");
		}
	}
	
	/**
	 * loads all connections that are given in a certain text
	 * 
	 * <dt>Precondition:
	 *   <dd>checks to see if the file is valid and each
	 *   user given is valid
	 *   
	 * @param filename
	 *   the name of the file that has all the connections
	 */
	public void loadAllConnections( String filename )
	{
		File file = new File( filename );
		try 
		{
			Scanner stdin = new Scanner(file);
			while( stdin.hasNextLine() )
			{
				String line = stdin.nextLine();
				String srcUser = line.substring(0 , line.indexOf(','));
				String destUser = line.substring( line.indexOf(',') + 2 );
				addConnection( srcUser, destUser );
			}
		} 
		catch (FileNotFoundException e) 
		{
			System.out.print( "ERROR: invalid file name");
		}
	}

	/**
	 * returns the ArrayList of all users
	 * 
	 * @return
	 *   the ArrayList of all users
	 */
	public ArrayList<User> getUsers() 
	{
		return users;
	}

	/**
	 * returns the boolean of all connections in 
	 * this 
	 * 
	 * @return
	 *   the boolean array of all connections
	 */
	public boolean[][] getConnections() 
	{
		return connections;
	}

//	public Hashtable<String, Integer> getFollowers()
//	{
//		return followers;
//	}
//
//	public Hashtable<String, Integer> getFollowing()
//	{
//		return following;
//	}

	/**
	 * sets the ArrayList of all users to a new value
	 * 
	 * @param users
	 *   new ArrayList of users
	 */
	public void setUsers(ArrayList<User> users)
	{
		this.users = users;
	}

	/**
	 * the 2d boolean array for all connections in 
	 * this
	 * 
	 * @param connections
	 *   the new 2d array for this
	 */
	public void setConnections(boolean[][] connections)
	{
		this.connections = connections;
	}

//	public void setFollowers(Hashtable<String, Integer> followers)
//	{
//		this.followers = followers;
//	}
//
//	public void setFollowing(Hashtable<String, Integer> following)
//	{
//		this.following = following;
//	}
}
