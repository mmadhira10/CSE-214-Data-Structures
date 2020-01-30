package PlayLists;

import java.util.*;
import java.util.Scanner;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm
 *         - 4:53pm
 */
public class Player 
{
	/**
	 * this is the main method for this project that runs the code
	 * @param args
	 *   the default parameter for the main method
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		SongLinkedList playlist = new SongLinkedList();

		do 
		{
			System.out.print("\n");
			System.out.print("\n");
			System.out.print("\n(A)   Add Song to Playlist");
			System.out.print("\n(F)   Go to Next Song");
			System.out.print("\n(B)   Go to Previous Song");
			System.out.print("\n(R)   Remove Song from Playlist");
			System.out.print("\n(L)   Play a Song");
			System.out.print("\n(C)   Clear the Playlist");
			System.out.print("\n(S)   Shuffle Playlist");
			System.out.print("\n(Z)   Random Song");
			System.out.print("\n(P)   Print Playlist");
			System.out.print("\n(T)   Get the total amount of songs "
					+ "in the playlist");
			System.out.print("\n(Y)   Continue Play");
			System.out.print("\n(Q)   Exit the Playlist");
			System.out.print("\nPlease enter a command:");

			char response = in.next().charAt(0);
			in.nextLine();
		
			// if (response.length() > 0) {

			switch (response) 
			{
			case 'A':
				Song s = new Song();
				System.out.print("Enter song title: ");
				//in.nextLine();
				String sName = in.nextLine();
				s.setName(sName + "");

				System.out.print("\nEnter artist(s) of the song: ");
				//in.nextLine();
				String sArtist = in.nextLine();
				s.setArtist(sArtist + " ");

				System.out.print("\nEnter album: ");
				//in.nextLine();
				String sAlbum = in.nextLine();
				s.setAlbum(sAlbum + " ");

				System.out.print("\nEnter length (in seconds): ");
				int sLength = in.nextInt();
				s.setLength(sLength);

				playlist.insertAfterCursor(s);

				System.out.print("\n");
				System.out.print("\n" + "'" + sName + "'" + " by " 
				  + sArtist + " is added to your playlist.");
				System.out.print("\n");

				break;
			case 'F':
				try
				{
					playlist.cursorForwards();
					System.out.print("\nCursor moved to next song.");
				} 
				catch (Exception e) 
				{
					System.out.print( "\nCan't move forward.");

				}

				break;
			case 'B':
				try 
				{
					playlist.cursorBackwards();
					System.out.print("\nCursor moved to previous song.");
				} 
				catch (Exception e) 
				{
					System.out.print("Can't move backward.");
				}

				break;
			case 'R':

				Song song = playlist.removeCursor();
				System.out.print("\n" + "'" + song.getName() + "'" + " by " 
				  + song.getArtist()
						+ " was removed from the playlist.");

				break;
			case 'L':
				System.out.print("\nEnter name of song to play: ");
				//in.nextLine();
				String name = in.nextLine();
				if (playlist.c == null)
				{
					playlist.play(name);
				}
				else
				{
					playlist.c.stop();
					playlist.play(name);
				}
				
				break;
			case 'C':
				playlist.deleteAll();
				System.out.print("\nYour playlist is empty.");
				break;
			case 'S':
				playlist.shuffle();
				System.out.print("\nPlaylist shuffled.");
				break;
			case 'Z':
				System.out.print("\nPlaying a random song...");
				String somesong = playlist.random().getName();
				playlist.play(somesong);
				System.out.print( "\n" + "'" + somesong + "'"
				  + " is playing.");
				break;
			case 'P':
				playlist.printPlaylist();
				break;
			case 'T':
				if (playlist.getSize() == 0)
				{
					System.out.print("\nYour playlist is empty.");
				} 
				else
				{
					System.out.print("\nYour playlist contains " 
					  + playlist.getSize() + " songs.");
				}
				break;
			case 'Y':
				SongNode temp = playlist.cursor;
				playlist.cursor = playlist.head;
				while ( playlist.cursor != null )
				{ 
					String name1 = playlist.cursor.getData().getName();
					if (playlist.c == null)
					{
						playlist.play( name1 );
					}
				}
				playlist.cursor = temp;
				break;
			default:
				// if (response.charAt(0) == 'Q') {
				if (response == 'Q')
				{
					quit = true;
					System.out.print("\n Program terminated.");
				}
				break;
			}
			// }
		} 
		while (quit == false);
	}
}
