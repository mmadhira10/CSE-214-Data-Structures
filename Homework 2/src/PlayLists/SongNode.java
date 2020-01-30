package PlayLists;

import javax.sound.*;
import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 
 * Monday 4pm - 4:53pm
 */
public class SongNode 
{
	SongNode prev;
	SongNode next;
	Song data;

	/**
	 * default SongNode constructor
	 */
	public SongNode() 
	{

	}

	/**
	 * The SongNode class that initializes a new SongNode object with following
	 * variables
	 * 
	 * @param prev 
	 *   the previous node
	 * @param next 
	 *   the next node
	 * @param data 
	 *   the song that exists in the node
	 */
	public SongNode(SongNode prev, SongNode next, Song data)
	{
		this.prev = prev;
		this.next = next;
		this.data = data;
	}

	/**
	 * the song returned from the node
	 * 
	 * @return data 
	 *   returns the song
	 */
	public Song getData() 
	{
		return data;
	}

	/**
	 * sets a new song at the node
	 * 
	 * @param song 
	 *   the song wanted at the new node
	 */
	public void setData(Song song) 
	{
		data = song;
	}

	/**
	 * returns the next node
	 * 
	 * @return next 
	 *   the following SongNode
	 */
	public SongNode getNext()
	{
		return next;
	}

	/**
	 * sets the next SongNode
	 * 
	 * @param newNext 
	 *   the new node the following SongNode is set to
	 */
	public void setNext(SongNode newNext)
	{
		next = newNext;
	}

	/**
	 * returns the previous SongNode
	 * 
	 * @return prev 
	 *   the previous SongNode
	 */
	public SongNode getPrev()
	{
		return prev;
	}

	/**
	 * sets the value to a new previous node
	 * 
	 * @param newPrev 
	 *   the new previous SongNode
	 */
	public void setPrev(SongNode newPrev)
	{
		prev = newPrev;
	}
}
