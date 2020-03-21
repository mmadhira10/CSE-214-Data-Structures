import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class Block
{
	ArrayList<Variable> blocks;
	
	/**
	 * creates the block object
	 */
	public Block()
	{
		blocks = new ArrayList<Variable>();
	}
	
	/**
	 * adds a name and value to a new variable
	 * that can be added to the block
	 * 
	 * @param name 
	 *   the name of the variable
	 * @param value
	 *   the value of the variable
	 */
	public void add( String name, String value )
	{
		Variable v = new Variable( value, name );
		blocks.add( v );
	}
	
	/**
	 * returns the size of the block
	 * @return blocks.size()
	 *   the size of the arraylist of blocks
	 */
	public int size()
	{
		return blocks.size();
	}

	/**
	 * gets the value of the variable
	 * 
	 * @param name
	 *   the name of the variable
	 * @return value
	 *   the value of the variable
	 */
	public String getVariable( String name )
	{
		String value = "";
		for( int x = 0; x < blocks.size(); x++ )
		{
			if ( blocks.get( x ).getName().equals( name ))
			{
				 value = blocks.get( x ).getValue();
			}
		}
		return value;
	}
	
	/**
	 * the searches for the variable 
	 * 
	 * @param name
	 *   the name of the variable it wants to get
	 * @return nameVar
	 *   the name of the variable from the block
	 */
	public String getVarName( String name )
	{
		String nameVar = "";
		for( int x = 0; x < blocks.size(); x++ )
		{
			if ( blocks.get( x ).getName().equals( name ))
			{
				 nameVar = blocks.get( x ).getName();
			}
		}
		return nameVar;
	}
	
	/**
	 * prints the block of local variables in a tabular
	 * format
	 */
	public void printBlock()
	{
		System.out.println();
		if( blocks.isEmpty() )
		{
			System.out.print("\nNo local variables to print.");
		}	
		else
		{
			
			System.out.printf("%5s %25s","Variable Name", "Initial Value");
			System.out.println();
			for( int x = 0; x < blocks.size(); x++ )
			{
				System.out.printf("%1s %25s", 
						blocks.get(x).getName(), blocks.get(x).getValue());
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
	/**
	 * returns the list in the block object
	 * @return blocks
	 *   the ArrayList of variables
	 */
	public ArrayList<Variable> getlist()
	{
		return blocks;
	}
}
