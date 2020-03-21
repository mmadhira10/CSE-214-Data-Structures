import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FollowGraphDriver implements Serializable
{
	/**
	 * The main method for this program that creates the interface
	 * to use to go buy the platform twittor to do certain 
	 * methods of action
	 * 
	 * @param args
	 *   the default parameter for this main method
	 */
	public static void main( String[] args )
	{
		
		FollowGraph twittor = new FollowGraph();
		
		try
		{
			FileInputStream file = new FileInputStream("twittor.obj");
			ObjectInputStream inStream = new ObjectInputStream(file);

			twittor = (FollowGraph) inStream.readObject();
		}
		catch( Exception e )
		{
			System.out.print("follow_graph.obj is not found. New object will be"
					+ "created.");
		}
		
		Scanner in = new Scanner(System.in);
		
		boolean terminate = false;
		
		do
		{
			System.out.print("\nMenu: ");
			System.out.print("\n");
			System.out.print("\n(U) Add User");
			System.out.print("\n(C) Add Connection");
			System.out.print("\n(AU) Load all Users");
			System.out.print("\n(AC) Load all Connections");
			System.out.print("\n(P) Print all Users");
			System.out.print("\n(L) Print all Loops");
			System.out.print("\n(RU) Remove User");
			System.out.print("\n(RC) Remove Connection");
			System.out.print("\n(SP) Find Shortest Path");
			System.out.print("\n(AP) Find All Paths");
			System.out.print("\n(Q) Quit");
			System.out.print("\n");
			System.out.print("\nEnter a selection: ");
			
			String response = in.next().toUpperCase();
			System.out.print("\n");
			
			switch( response )
			{
				case "U":
					System.out.print("\nPlease enter the name of the user: ");
					in.nextLine();
					String user = in.nextLine();
					twittor.addUser( user );
		
					break;
					
				case "C":
					System.out.print("\nPlease enter the source "
							+ "of the connection to add: ");
					in.nextLine();
					String from = in.nextLine();
					
					System.out.print("\nPlease enter the dest "
							+ "of the connection to add: ");
					
					String to = in.nextLine();
					twittor.addConnection( from, to );
					
					break;
					
				case "AU":
					System.out.print("Enter the file name: ");
					String file = in.next();
					twittor.LoadAllUsers(file);
					
					break;
				case "AC":
					System.out.print("Enter the file name: ");
					String file1 = in.next();
					twittor.loadAllConnections(file1);
					
					break;
				case "P":
					boolean quit = false;
					
					do
					{
						System.out.print("\n");
						System.out.print("\n(SA) Sort Users by Name");
						System.out.print("\n(SB) Sort Users by Number of Followers");
						System.out.print("\n(SC) Sort Users by Number of Following");
						System.out.print("\n(Q) Quit");
						System.out.print("\n");
						System.out.print("\nEnter a selection: ");
						System.out.print("\n");
						
						String smallMenu = in.next().toUpperCase();
						
						switch( smallMenu )
						{
						case "SA":
							NameComparator name = new NameComparator();
							twittor.printAllUsers( name );
							
							break;
						case "SB":
							FollowersComparator followers = new FollowersComparator();
							twittor.printAllUsers( followers );
							
							break;
						case "SC":
							FollowingComparator following = new FollowingComparator();
							twittor.printAllUsers( following );
							
							break;
						default:
							if( smallMenu.equals("Q") )
							{
								quit = true;
							}
						}
					}
					while( quit != true );
						
					break;
					
				case "L":
					break;
				case "RU":
					System.out.print("\nPlease enter the name of the user: ");
					in.nextLine();
					String user1 = in.nextLine();
					twittor.removeUser( user1 );
					
					break;
				case "RC":
					System.out.print("\nPlease enter the source "
							+ "of the connection to remove: ");
					in.nextLine();
					String from1 = in.nextLine();
					
					System.out.print("\nPlease enter the dest "
							+ "of the connection to remove: ");
					
					String to1 = in.nextLine();
					
					twittor.removeConnection( from1 , to1 );
					break;
					
				case "SP":
					System.out.print("\nPlease enter the desired source: ");
					in.nextLine();
					String from2 = in.nextLine();
					
					System.out.print("\nPlease enter the desired destination: ");
					String to2 = in.nextLine();
					
					try
					{
						twittor.shortestPath( from2 , to2 );
					}
					catch( IOException e )
					{
						System.out.print("\nUsers doesn't exist");
					}
					
					break;
				case "AP":
					break;
				default:
					if( response.equals("Q") )
					{
						System.out.print("\nFollowGraph object saved "
								+ "into file FollowGraph.obj." );
						FileOutputStream file3;
						try
						{
							file3 = new FileOutputStream("twittor.obj");
							ObjectOutputStream outStream = 
									new ObjectOutputStream(file3);
							FollowGraph library= new FollowGraph();

							outStream.writeObject(library);
							outStream.close();
						} 
						catch (Exception e)
						{
							System.out.print("\nException Doesn't exist.");
						}
						System.out.print("\n");
						System.out.print("\nProgram terminating...");
						terminate = true; 
						
					}
					break;
			}
		}
		while( terminate != true );
	}
}
