import java.util.ArrayList;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FrequencyTable extends ArrayList<FrequencyList>
{
	static ArrayList<String> listOfWords = new ArrayList<String>();
	static FrequencyTable table = new FrequencyTable();
	
	/**
	 * goes through passages and creates a list of frequncyLists for each 
	 * word in each passage
	 * 
	 * @param passages
	 *   the List of passages that buildTable works off
	 *   from
	 *   
	 * <dt>Postcondition:
	 *   <dd>A new freqencyTable has been constructed that contains an 
	 *   entire collection from the FrequencyList with info contained
	 *   from the passages
	 *   
	 * @return
	 *   the FrequencyTable constructed using each passage
	 *   contained in passages
	 */
	public static FrequencyTable buildTable( ArrayList<Passage> passages )
	{
		
		for( Passage p : passages)
		{
			for( String s : p.getFreq().keySet())
			{
				if( !listOfWords.contains(s))
				{
					listOfWords.add(s);
				}
			}
		}
		
		for( String s : listOfWords )
		{
			FrequencyList freq = new FrequencyList( s, passages);
			table.add( freq );
		}
		return table;
		
	}
	
	/**
	 * adds a new passage in this table and changes all the list
	 * of FrequencyLists in table accordingly
	 * 
	 * @param p
	 *   the passage that is being iterated over and later
	 *   added into the table
	 * 
	 * <dt>Precondition:
	 *   <dd>p is not empty or null
	 *   
	 * <dt>Postcondition:
	 *   <dd>p's value for each key has been mapped to 
	 *   each FrequencyList in the table
	 *   
	 * @throws IllegalArgumentException
	 *   if p is either null or empty
	 */
	public void addPassage( Passage p ) throws IllegalArgumentException
	{
		
	}
	
	/**
	 * returns the frequency of a given word in the given passage
	 * 
	 * @param word
	 *   the word that the frequency is being looked for
	 *   
	 * @param p
	 *   the passage you want to return the frequency of the given word
	 *   
	 * @return
	 *   the frequency of the given word in the given passage p
	 */
	public int getFrequency( String word, Passage p )
	{
		return modCount;
		
	}
}
