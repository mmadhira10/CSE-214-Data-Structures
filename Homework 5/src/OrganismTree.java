import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class OrganismTree
{
	private OrganismNode root;
	private OrganismNode cursor;
	
	/**
	 * Constructor that creates a new food pyramid with apex
	 * Predator being the root of the tree as well as the initial 
	 * cursor.
	 * 
	 * @param apexPredator
	 *   the predator that forms the tree as the 
	 *   root
	 *   
	 * <dt>Postcondition:
	 *   <dd>an organism tree is made as the apex predator 
	 *   is the root as well as the cursor for the tree.
	 *   
	 */
	public OrganismTree( OrganismNode apexPredator )
	{
		root = apexPredator;
		cursor = root;

	}
	
	/**
	 * moves the cursor back to the root of the tree
	 * 
	 * <dt>Postcondition:
	 *   <dd>cursor references root of the tree.
	 */
	public void cursorReset()
	{
		cursor = root;
	}
	
	/**
	 * moves cursor to one of the cursor's children
	 * 
	 * @param name
	 *   the parameter of which node the cursor 
	 *   should point to next
	 *   
	 * <dt>Precondition:
	 *   <dd>a valid name that the cursor is pointing to
	 * 
	 * <dt>Postcondition:
	 *   <dd>Either an exception is thrown or the cursor points
	 *   to the node whose name is referenced
	 *   
	 * @throws IllegalArgumentException
	 *   the exception thrown if the name is invalid.
	 */
	public void moveCursor(String name) throws IllegalArgumentException
	{
		if( cursor.getLeft().getName().equals(name))
		{
			cursor = cursor.getLeft();
		}
		else if( cursor.getMiddle().getName().equals(name))
		{
			cursor = cursor.getMiddle();
		}
		else if(cursor.getRight().getName().equals(name) )
		{
			cursor = cursor.getRight();
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * Returns a string that includes the organism at the cursor and 
	 * all the its possible prey
	 * 
	 * <dt>Postcondition:
	 *   <dd>cursor has not moved from its spot
	 *   
	 * @return preyList
	 *   a string that contains the list of prey
	 *   
	 * @throws IsPlantException
	 *   this is thrown if the cursor already points 
	 *   to a plant object.
	 */
	public String listPrey() throws IsPlantException
	{
		if( cursor.isPlant() == true )
		{
			throw new IsPlantException("Plants are not predators.");
		}
		
		String preyList = "";
		
		if( cursor != null )
		{
			preyList = cursor.getName() + " -> ";
		}
		
		if( cursor.getLeft() != null )
		{
			preyList += cursor.getLeft().getName();
		}
		
		if( cursor.getMiddle() != null )
		{
			if( cursor.getName().length() + 4 < preyList.length())
			{
				preyList += ", ";
			}
			preyList += cursor.getMiddle().getName();
		}
		
		if( cursor.getRight() != null )
		{
			if( cursor.getName().length() + 4 < preyList.length())
			{
				preyList += ", ";
			}
			preyList += cursor.getRight().getName();
		}
		return preyList;
	}
	
	/**
	 * returns a string that represents a food chain that
	 * starts from the apex all the way to the cursor
	 * 
	 * <dt>Postcondition:
	 *   <dd>cursor has not moved.
	 *   
	 * @return chain
	 *   the string that has the food chain from apex to cursor
	 */
	public String listFoodChain()
	{
		
		OrganismNode temp = cursor;
		String chain = "";
		
		while( cursor != null )
		{
			chain = " -> " + cursor.getName() + chain;
			cursor = cursor.getParent();
		}
		
		chain = chain.substring(4);
		cursor = temp;
		
		return chain;
 	}
	
	/**
	 * prints out the entire organism tree
	 * starting from where the cursor is pointing all the way to
	 * all its leaves and branches using a certain format. 
	 * 
	 * <dt>Postconditions:
	 *   <dd>cursor has not moved and the root has not changed. 
	 */
	public void printOrganismTree()
	{
		preOrderPrint(cursor, "");
	}
	
	/**
	 * Helper Method: This method traverse the entire tree 
	 * starting from cursor and prints out each node using 
	 * given format.
	 * 
	 * @param org
	 *   the organism that printing of the tree should start with
	 *   
	 * @param indent
	 *   the amount of spaces that need to be created for each node
	 */
	private void preOrderPrint ( OrganismNode org, String indent )
	{
		if( org != null )
		{
			if( org.isPlant() == true )
			{
				System.out.println( indent + "- " + org.getName() );
			}
			else
			{
				System.out.println( indent + "|- " + org.getName());
			}
			
			preOrderPrint( org.getLeft(), indent + "    " );
			
			preOrderPrint( org.getMiddle(), indent + "    " );
			
			preOrderPrint( org.getRight(), indent + "    " );
		}
	}
	
	/***
	 * returns a list of all the plants currently at the cursor and 
	 * beneath it in the food pyramid
	 * 
	 * <dt>Postconditions:
	 *   <dd>cursor has not moved and the root has not changed
	 *   
	 * @return holder
	 *   the string for all the plants below cursor
	 */
	public String listAllPlants()
	{
		String holder = "";
		holder = preOrderPlants( cursor, holder );
		
		return holder;
	}
	
	/**
	 * Helper Method: a method to help traverse the tree
	 * starting from cursor all the way to the leaves.
	 * 
	 * @param org
	 *   the node for which we will try to find all the leaves for
	 *   
	 * @param s
	 *   the string that we will add all the leaves to
	 *   
	 * @return s
	 *   the string with all the leaves 
	 */
	private String preOrderPlants( OrganismNode org, String s)
	{
		if( org != null )
		{
			if( org.isPlant() == true )
			{
				
				if( org == cursor )
				{
					System.out.print(  org.getName() );
					s += org.getName();
				}
				else
				{
					System.out.print(", " + org.getName());
					s += ", " + org.getName();
				}
				
			}
			
			preOrderPlants( org.getLeft(), s);
			
			preOrderPlants( org.getMiddle(), s);
		
			preOrderPlants( org.getRight(), s);
		}
		return s;
	}
	
	/**
	 * creates an Animal node with a new diet and name and adds 
	 * it as a child to the cursor.
	 * 
	 * @param name
	 *   the name of the child node
	 *   
	 * @param isHerbivore
	 *   whether it is a herbivore
	 *   
	 * @param isCarnivore
	 *   whether it is a carnivore
	 *   
	 * <dt>Preconditions: 
	 *   <dd>name does not reference a direct child of the cursor and
	 *   the cursor has an available position for another child node
	 *   
	 * @throws IllegalArgumentException
	 *   thrown if the name refernces to the exact name
	 *   of its would be siblings
	 *   
	 * @throws PositionNotAvailableException
	 *   if there is no more space left to add an object.
	 */
	public void addAnimalChild(String name, boolean isHerbivore, 
			boolean isCarnivore) throws IllegalArgumentException,  
				PositionNotAvailableException	
	{
		name = name.toLowerCase();
		
		if(cursor.getLeft() != null && 
				cursor.getLeft().getName().equals( name ) ||
				cursor.getRight() != null &&
				cursor.getMiddle().getName().equals( name ))
		{
			throw new IllegalArgumentException();
		}
		
		OrganismNode obj = new OrganismNode( name );
		
		obj.setCarnivore(isCarnivore);
		obj.setHerbivore(isHerbivore);
		obj.setParent(cursor);
		
		try 
		{
			cursor.addPrey( obj );
		} 
		catch (IsPlantException e)
		{
			System.out.print("\nERROR: This prey cannot be added as it does"
					+ " not match the diet of the predator.");
		}
		catch (DietMismatchException e) 
		{
			System.out.print("\nERROR: this is not apart of the prey's diet");
		}
	}
	
	/**
	 * adds a plant object to the cursor which must be a omnivore
	 * or herbivore
	 * 
	 * @param name
	 *   name of the plant
	 *   
	 * <dt>Preconditions: 
	 *   <dd>either exception thrown or new plant node is added
	 *   with name name and cursor has spot to put a new child.
	 *  
	 * <dt>Postconditions: 
	 *   <dd>either a new exception is thrown or a new plant
	 *   node has been created and cursor has not moved
	 *   
	 * @throws IllegalArgumentException
	 *   thrown if the name matches to one of its would be siblings
	 *   
	 * @throws PositionNotAvailableException
	 *  thrown if there is no availble spot for a child to be added
	 */
	public void addPlantChild(String name) throws IllegalArgumentException, 
		PositionNotAvailableException
	{
		name = name.toLowerCase();
		
		if(cursor.getLeft() != null && 
				cursor.getLeft().getName().equals( name ) ||
				cursor.getRight() != null &&
				cursor.getMiddle().getName().equals( name ))
		{
			throw new IllegalArgumentException();
		}
		
		OrganismNode obj = new OrganismNode( name );
		
		obj.setPlant(true);
		obj.setParent(cursor);
		
		try 
		{
			cursor.addPrey( obj);
		} 
		catch (IsPlantException e)
		{
			System.out.print("\nERROR: Plants can not eat plants");
		}
		catch (DietMismatchException e) 
		{
			System.out.print("\nERROR: this is not apart of the prey's diet");
		}
	}
	
	/**
	 * deletes the node child of cursor with name name and shifts
	 * all other nodes as well as deleting descendants of the deleted
	 * node.
	 * 
	 * @param name
	 *   the name of the node that is gonna be deleted.
	 *   
	 * <dt>Preconditions: 
	 *   <dd>the name references a direct child of the cursor.
	 *   
	 * <dt>Postconditions:
	 *   <dd>the child with name name has been removed along with all its
	 *   descendants. The other nodes have shifted. The cursor has not moved. 
	 *   
	 * @throws IllegalArgumentException
	 *   if the name doesn't reference a direct child of the cursor. 
	 */
	public void removeChild(String name) throws IllegalArgumentException
	{
		if(cursor.getLeft().getName().equals(name) )
		{
			cursor.setLeft(null);
			if( cursor.getMiddle() != null )
			{
				cursor.setLeft( cursor.getMiddle() );
				cursor.setMiddle( null );
			}
			if( cursor.getRight() != null )
			{
				cursor.setMiddle( cursor.getRight() );
				cursor.setRight( null );
			}
		}
		else if( cursor.getMiddle().getName().equals(name) )
		{
			cursor.setMiddle( null );
			if( cursor.getRight() != null )
			{
				cursor.setMiddle( cursor.getRight() );
				cursor.setRight( null );
			}
		}
		else if( cursor.getRight().getName().equals(name) )
		{
			cursor.setRight( null );
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

	/**
	 * returns the root of the tree.
	 * 
	 * @return root
	 *   the root of the tree
	 */
	public OrganismNode getRoot() 
	{
		return root;
	}

	/**
	 * returns the cursor
	 * 
	 * @return cursor
	 * returns the cursor
	 */
	public OrganismNode getCursor()
	{
		return cursor;
	}

	/**
	 * sets to a new root
	 * 
	 * @param root
	 *   new root
	 */
	public void setRoot(OrganismNode root)
	{
		this.root = root;
	}

	/**
	 * sets to a new cursor
	 * 
	 * @param cursor
	 *   new cursor
	 */
	public void setCursor(OrganismNode cursor)
	{
		this.cursor = cursor;
	}
}
