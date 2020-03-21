import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class Passage 
{
	
	String title;
	int wordCount;
	Hashtable <String, Double> similarTitles;
	Hashtable <String, Integer> freq = new Hashtable<String, Integer>();

	
	
	/**
	 * constructs an object passage by creating a title and
	 * calling the parse method
	 * 
	 * @param title
	 *   the title of this passage
	 *   
	 * @param file
	 *   the file of this passage
	 */
	public Passage( String title, File file )
	{
		this.title = title;
		parseFile( file );
		similarTitles = new Hashtable<String, Double> ();
	}
	
	/**
	 * reads a text file and counts the number of occurrences of 
	 * a word excluding stop words and inserts them into a table
	 * 
	 * @param file
	 *   the file needed to be parsed
	 */
	public void parseFile( File file )
	{
		Scanner stdin;
		try 
		{
			File stop = new File( "StopWords.txt" );
			Scanner stdin2 = new Scanner( stop );
			ArrayList<String> stopword = new ArrayList<String>();
			
			while( stdin2.hasNext() )
			{
				stopword.add(stdin2.next());
			}
			
			stdin = new Scanner(file);
			
			while( stdin.hasNext() )
			{
				String str = stdin.next().toLowerCase();
				
				String word = "";
				
				for( Character ch : str.toCharArray())
				{
					if( Character.isLetter(ch))
					{
						word = word + ch;
					}
				}
				
				if( !stopword.contains( word ))
				{
					if(freq.containsKey( word ))
					{
						freq.put(word, freq.get(word) + 1 );
					}
					else
					{
						freq.put(word, 1);
					}
				}
			}
			wordCount = getWords().size();
		} 
		catch (FileNotFoundException e)
		{
			System.out.print("ERROR: File doesn't exist!");
		}
	}
	
	/**
	 * calculates the similarity between two passages 
	 * using the formula given and changes the similarTitles
	 * as need be
	 * 
	 * @param passage1
	 *   the first passage needed to be compared
	 *   
	 * @param passage2
	 *   the second passage needed to be compared
	 *   
	 * @return
	 *   the percentage similarity between the two passages
	 */
	public static double cosineSimilarity( Passage passage1, Passage passage2)
	{
//		ArrayList<String> words = new ArrayList<String>();
//		for( String word : passage1.getWords() )
//		{
//			words.add( word );
//		}
//		
//		for( String word : passage2.getWords())
//		{
//			if( !words.contains(word) )
//			{
//				words.add( word );
//			}
//		}
		
		double numSum = 0;
		double denomSum1 = 0;
		double denomSum2 = 0;
		
		Set<String> words = passage1.getWords();
		for (String word : words)
		{
			double p1 = 0;
			double p2 = 0;
			
			if( passage2.getFreq().containsKey( word ))
			{
				p2 = passage2.getFreq().get(word) / passage2.getWordCount();
			}
			
			if( passage1.getFreq().containsKey( word ))
			{
				p1 = passage1.getFreq().get(word) / passage1.getWordCount();
			}
			//System.out.println(numSum);
			numSum = numSum + (p1 * p2);
			denomSum1 = denomSum1 + p1 * p1;
			denomSum2 = denomSum2 + p2 * p2;
		}
		
		
		double cos = numSum / (Math.sqrt(denomSum1) + Math.sqrt(denomSum2));
		cos = Math.acos(cos);
		//System.out.println(cos);
		
		passage1.getSimilarTitles().put(passage2.getTitle(), cos);
		passage2.getSimilarTitles().put(passage1.getTitle(), cos);
		
		return cos;
	}
	
	/**
	 * gives back the frequency of a given word in 
	 * this passage object
	 * 
	 * @param word
	 *   the word that the frequency is being looked for
	 *   
	 * @return
	 *   double data type for the frequency of a word in this passage
	 */
	public double getWordFrequency( String word )
	{
		if( freq.containsKey( word ) )
		{
			return freq.get( word ) / wordCount;
		}
		return 0;
	}
	
	/**
	 * gives back set of all the words in this passage
	 * 
	 * @return
	 *   the words in this passage
	 */
	public Set<String> getWords()
	{
		return freq.keySet();	
	}
	
	/**
	 * returns the similar titles and all their percentage similarities
	 * 
	 * @return
	 *   the string for the percentage similarities and titles
	 */
	public String toString()
	{
		return title;
	}

	/**
	 * returns the title of the passage
	 * 
	 * @return
	 *   the title of the passage
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * returns the word count of the passage
	 * 
	 * @return wordCount
	 *   the number of words in the passage excluding stop words
	 */
	public int getWordCount()
	{
		return wordCount;
	}

	/**
	 * returns the similarTitles table
	 * 
	 * @return similarTitles
	 *   the similarTitles table that has the cosine similarities 
	 *   and titles
	 */
	public Hashtable<String, Double> getSimilarTitles()
	{
		return similarTitles;
	}

	/**
	 * sets title to a new value
	 * 
	 * @param title
	 *   the new title
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}

	/**
	 * sets the word count of this passage to a new value
	 * 
	 * @param wordCount
	 *   the new value
	 */
	public void setWordCount(int wordCount)
	{
		this.wordCount = wordCount;
	}

	/**
	 * sets the table similarTitles to a new table
	 * 
	 * @param similarTitles
	 *   the new similarTitles
	 */
	public void setSimilarTitles(Hashtable<String, Double> similarTitles) 
	{
		this.similarTitles = similarTitles;
	}

	/**
	 * the frequency of words table 
	 * 
	 * @return freq
	 *   the frequency table
	 */
	public Hashtable<String, Integer> getFreq()
	{
		return freq;
	}

	/**
	 * sets frequency of words table to a new value
	 * 
	 * @param freq
	 *   new frequency of words table
	 */
	public void setFreq(Hashtable<String, Integer> freq)
	{
		this.freq = freq;
	}	
	
}
