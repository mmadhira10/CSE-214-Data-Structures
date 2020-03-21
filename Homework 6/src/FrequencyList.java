import java.util.ArrayList;
import java.util.Hashtable;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FrequencyList 
{
	String word;
	ArrayList<Integer> frequencies;
	Hashtable<String, Integer> passageIndices;
	
	/**
	 * The default constructor that given a word gives the frequency of 
	 * that element amongst several passages
	 * 
	 * @param word
	 *   the word that sets the field
	 *   
	 * @param passages
	 *   the passages used to set frequencies and passageIndicies
	 */
	public FrequencyList( String word, ArrayList<Passage> passages )
	{
		this.word = word;
		frequencies = new ArrayList<Integer>();
		passageIndices = new Hashtable<String, Integer>();
		
		int x = 1;
		for (Passage p : passages )
		{
			frequencies.add(p.getFreq().get(word));
			passageIndices.put(p.getTitle(), x);
			x++;
		}
	}
	
	/**
	 * adds a new passage to this FrequencyList
	 * 
	 * <dt>Postcondition:
	 *   <dd>passage indicies now holds p's title which points to the 
	 *   next available spot in the ArrayList. The arraylist now contains the 
	 *   frequency of that word in Passage p
	 *   
	 * @param p
	 *   the passage that's going to be added to this
	 *   FrequencyList
	 * 
	 */
	public void addPassage( Passage p )
	{
		frequencies.add( p.getFreq().get(word));
		passageIndices.put( p.getTitle(), frequencies.size() );
	}
	
	/**
	 * returns the frequncy of word in the given Passage and returns 0
	 * if the the Passage doesn't contain FrequencyList
	 * 
	 * @param p
	 * 
	 * @return
	 */
	public int getFrequency( Passage p )
	{
		if(passageIndices.containsKey( p.getTitle() ))
		{
			return frequencies.get(passageIndices.get( p.getTitle() ) - 1);
		}
		
		return 0;
	} 
}
