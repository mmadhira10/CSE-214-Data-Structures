package PlayLists;

import javax.sound.*;

import java.io.File;
import java.util.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class SongLinkedList
{
	SongNode head;
	SongNode tail;
	SongNode cursor;
	int size;
	Clip c;

	/**
	 * The default constructor for the Linked list 
	 * that sets all the fields to null and puts the size
	 * to 0
	 */
	public SongLinkedList()
	{
		head = null;
		tail = null;
		cursor = null;
		size = 0;
	}

	/**
	 * plays the song asked for
	 * 
	 * @param name
	 *   the name of the song asked to play
	 *   
	 * <dt>Preconditions: 
	 *    <dd> The name must match an actual song name in the playlist 
	 *    and there must be a file associated with it
	 *    
	 * <dt>Postconditions: 
	 *    <dd>  The song is now playing.
	 *    
	 * @throws IllegalArgumentException
	 *   Indicates that the following input to the play is invalid
	 */
	public void play(String name) throws IllegalArgumentException
	{
		try 
		{

			AudioInputStream AIS = 
					AudioSystem.getAudioInputStream( new File( name+".wav" ));
			c = AudioSystem.getClip();
			c.open(AIS);   
			c.start();
			
		}
		catch (Exception ex) 
		{
				
		}
	}

	/**
	 * This moves the cursor forward to the next node.
	 * 
	 * <dt>Preconditions:
	 *    <dd> the list is not empty
	 *    
	 * <dt>Postconditions:
	 *    <dd> The song has moved to next node or has stayed at the
	 *    tail
	 * 
	 * @throws Exception
	 *   Indicates that the cursor has tried moved to a node that is null
	 */
	public void cursorForwards() throws Exception  
	{
		if ( cursor == tail )
		{
			throw new Exception( "Can't move forward anymore.");
		}
		if( cursor != null )
		{
			cursor = cursor.getNext();
		}
		
	}

	/**
	 * This moves the cursor backwards to the previous node
	 * 
	 * <dt>Preconditions:
	 *    <dd> the list is not empty
	 * 
	 * <dt>Postconditions:
	 *    <dd> The cursor has been advanced or has remained at the head
	 *    of the list
	 *    
	 * @throws Exception
	 *   Indicates that the cursor has tried moved to a node that is null
	 */
	public void cursorBackwards() throws Exception 
	{
		if ( cursor == head )
		{
			throw new Exception( "Can't move backward anymore.");
		}
		
		if( cursor != null )
		{
			cursor = cursor.getPrev();
		}
		
	}

	/**
	 * Insets the cursor into the playlist after the cursor position
	 * in which the cursor is moved manually
	 * 
	 * @param newSong
	 *   The song that is going to be inserted
	 *   
	 * <dt>Preconditions:
	 *    <dd> the newSong object has been instantiated
	 *    
	 * <dt>Postconditions:
	 *    <dd> the object is added after the cursor while the order
	 *    of the play list is preserved and the cursor now points to
	 *    the inserted node
	 *    
	 * @IllegalArgumentException
	 *   Indicates the newSong object is null
	 */
	public void insertAfterCursor(Song newSong) 
	{
		if (newSong == null)
		{
			throw new IllegalArgumentException();
		}

		SongNode song = new SongNode(null, null, newSong);

		if (head != null) 
		{
			if (cursor.getNext() == null) 
			{
				cursor.setNext(song);
				tail = song;
				tail.setPrev( cursor );
			} 
			else
			{
				song.setNext(cursor.getNext());
				cursor.setNext(song);
				song.getNext().setPrev( song );
				song.setPrev( cursor );
			}
			cursor = song;
		}

		if (head == null) 
		{
			head = song;
			cursor = song;
			tail = song;
		}
		size++;
	}

	/**
	 * Removes the songNode that is pointed by the cursor and returns
	 * the song in the node
	 * 
	 * <dt>Preconditions:
	 *    <dd> the cursor is not null
	 *   
	 * <dt>Postconditions:
	 *    <dd> the SongNode pointed to by cursor has been removed 
	 *    from the playlist and after the cursor references next node or
	 *    previous 
	 * 
	 * @return the removed song
	 *   the song that was removed
	 */
	public Song removeCursor() 
	{
		SongNode temp = null;
		if( cursor != null )
		{
			temp = cursor;
			if ( cursor.getNext() == null && cursor.getPrev() == null )
			{
				head = null;
				cursor = null;
				tail = null;
			}
			else if( cursor.getNext() == null )
			{
				
				cursor = cursor.getPrev();
				tail = cursor;
				cursor.setNext(null);
			}
			else if( cursor.getPrev() == null )
			{
				cursor = cursor.getNext();
				head = cursor;
				cursor.setPrev( null );
			}
			else
			{
				cursor = cursor.getPrev();
				cursor.setNext( cursor.getNext().getNext());
				cursor = cursor.getNext();
				cursor.setPrev( cursor.getPrev().getPrev());
			}
			size--;
		}
		
		return temp.getData();
		
	}

	/**
	 * returns the song of the Linked list 
	 * 
	 * @return size
	 *   the size of the SongLinkedList
	 */
	public int getSize() 
	{
		return size;
	}

	/**
	 * Selects one of the songs at random 
	 * in the the play list and plays it.
	 * 
	 * <dt>Postconditions:
	 *    <dd> The randomly selected song is playing
	 *    
	 * @return The random song
	 *   a song was randomly selected
	 */
	public Song random() 
	{
		SongNode temp = cursor;
		temp = head;
		int number = ( int ) (Math.random() * size);
		
		for( int x = 0; x < number; x++ )
		{
			temp = temp.getNext();
		}
		
		return temp.getData();
	}
	
	/**
	 * Helper Method to Shuffle: adds the randomly selected object to the 
	 * end of the list
	 * 
	 * @param node
	 *   the node that was randomly removed
	 */
	private void shuffleInsert( SongNode node )
	{	
		if (head != null) 
		{
			if (cursor.getNext() == null) 
			{
				cursor.setNext( node );
				tail = node;
				tail.setPrev( cursor );
			} 
			else
			{
				node.setNext(cursor.getNext());
				cursor.setNext(node);
				node.getNext().setPrev( node );
				node.setPrev( cursor );
			}
			cursor = node;
		}

		if (head == null) 
		{
			head = node;
			cursor = node;
			tail = node;
		}
	}
	
	/**
	 * Helper Method to Shuffle: Removes a random SongNode from the list
	 * 
	 * @return random SongNode 
	 *   the random songNode is removed pointed to by temp cursor
	 * 
	 */
	private SongNode shuffleRemove()
	{
		 int number = ( int )( Math.random() * size);
		 cursor = head;
		 int n = 0;
		 while( n < number )
		 {
			 cursor = cursor.getNext();
			 n++;
		 }
		 size--;
		 return remove();
	}
	
	/**
	 * Helper Method to Shuffle: removes the temporary cursor
	 * 
	 * <dt>Preconditions:
	 *    <dd>The temp cursor is not null
	 *    
	 * @param temp
	 *   the temp cursor 
	 */
	private SongNode remove()
	{
		SongNode temp = null;
		if( cursor != null )
		{
			temp = cursor;
			if ( cursor.getNext() == null && cursor.getPrev() == null )
			{
				head = null;
				cursor = null;
				tail = null;
			}
			else if( cursor.getNext() == null )
			{
				cursor = cursor.getPrev();
				tail = cursor;
				cursor.setNext(null);
			}
			else if( cursor.getPrev() == null )
			{
				cursor =  cursor.getNext();
				head = cursor;
				cursor.setPrev( null );
			}
			else
			{
				cursor = cursor.getPrev();
				cursor.setNext( cursor.getNext().getNext());
				cursor = cursor.getNext();
				cursor.setPrev( cursor.getPrev().getPrev());
			}
		}
		return temp;
		
	}

	/**
	 * Randomly shuffles the objects in the playlist
	 * 
	 * <dt>Postconditions:
	 *    <dd> The playlist's order is random and the cursor should
	 *    reference the song previously pointed to
	 */
	public void shuffle()
	{
		SongLinkedList newList = new SongLinkedList();
		SongNode rand = cursor;
		int sicksize = size;
		int n = 0;
		while( n < sicksize )
		{
			SongNode song = shuffleRemove();
			song.setNext( null );
			song.setPrev( null );
			newList.shuffleInsert( song );
			n++;
		}
		head = newList.head;
		tail = newList.tail; 
		cursor = rand;
		size = sicksize;
	}

	/**
	 * prints the playlist into a neatly formatted table.
	 */
	public void printPlaylist() 
	{
		SongNode temp = cursor;
		cursor = head;
		System.out.printf
			("%5s %25s %25s %25s", "Song", "| Artist", "| Album", "| Length");
		System.out.println();
		System.out.println
		("---------------------------------------------------------------------"
				+ "----------------------------------------------------");
		while (cursor != null) 
		{
			System.out.format("%5s %25s %25s %25d", cursor.getData().getName(), 
					cursor.getData().getArtist(),
					cursor.getData().getAlbum(), cursor.getData().getLength());
			if( cursor == temp )
			{
				System.out.print(  "    <-");
			}
			System.out.println();
			cursor = cursor.getNext();
		}
		cursor = temp;
	}

	/**
	 * this method will delete all the songs in the playlist
	 * 
	 * <dt>Postconditions:
	 *    <dd> Each song has been removed
	 */
	public void deleteAll() 
	{
		head = null;
		cursor = null;
		tail = null;
		size = 0;
	}

	/**
	 * returns the string version of the list
	 * 
	 * @returns string representation of LinkedList
	 *   the string representation of the SongLinkedList
	 */
	@Override
	public String toString() 
	{
		return "SongLinkedList [head=" + head + ", tail=" + tail + 
				", cursor=" + cursor + ", size=" + size + "]";
	}

}
