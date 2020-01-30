package PlayLists;

import javax.sound.*;
import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm
 *         - 4:53pm
 */
public class Song 
{

	String artist;
	String album;
	String name;
	int length;

	/**
	 * default constructor for the class without any parameters
	 */
	public Song()
	{

	}

	/**
	 * Constructor to initialize a song object with the given parameters to
	 * represent a song
	 * 
	 * @param artist 
	 * 		the artist who sang the song
	 * @param album  
	 * 		the album the song was part of
	 * @param name   
	 * 		the name of the song
	 * @param length 
	 * 		the time interval of the song
	 */
	public Song(String artist, String album, String name, int length) 
	{
		this.artist = artist;
		this.album = album;
		this.name = name;
		this.length = length;
	}

	/**
	 * returns the song's artist
	 * 
	 * @return artist 
	 * 		the artist who sang the song
	 */
	public String getArtist()
	{
		return artist;

	}

	/**
	 * returns the song's album
	 * 
	 * @return album 
	 * 		the album the song is apart of
	 */
	public String getAlbum()
	{
		return album;

	}

	/**
	 * returns the name of the song
	 * 
	 * @return name 
	 * 		the name of the song
	 */
	public String getName() 
	{
		return name;

	}

	/**
	 * returns the length of the song
	 * 
	 * @return length 
	 * 		the time interval of the song
	 */
	public int getLength()
	{
		return length;
	}

	/**
	 * sets value to a different artist
	 * 
	 * @param artist 
	 * 		the different artist
	 */
	public void setArtist(String artist) 
	{
		this.artist = artist;
	}

	/**
	 * sets value to a different album
	 * 
	 * @param album 
	 * 		the different album
	 */
	public void setAlbum(String album) 
	{
		this.album = album;
	}

	/**
	 * sets value to a different song name
	 * 
	 * @param name 
	 * 		the different song name
	 */
	public void setName(String name) 
	{
		this.name = name;
	}

	/**
	 * sets value to a different song length
	 * 
	 * @param length 
	 * 		the different song length
	 */
	public void setLength(int length) 
	{
		this.length = length;
	}

}
