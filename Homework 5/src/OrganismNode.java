import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class OrganismNode 
{
	private String name;
	private boolean isPlant;
	private boolean isHerbivore;
	private boolean isCarnivore;
	
	private OrganismNode left;
	private OrganismNode middle;
	private OrganismNode right;
	private OrganismNode parent;
	
	/**
	 * constructor for creating an OrganismNode object with
	 * just a name
	 * 
	 * @param name
	 *   the name of the Organism
	 * 
	 */
	public OrganismNode( String name )
	{
		this.left = null;
		this.middle = null;
		this.right = null;
		this.name = name;
		isPlant = false;
		isHerbivore = false;
		isCarnivore = false;
		parent = null;
	}
	
	/**
	 * the default constructor that sets all parameters 
	 * for this object to the default values
	 * 
	 */
	public OrganismNode()
	{
		left = null;
		middle = null;
		right = null;
		name = "";
		isPlant = false;
		isHerbivore = false;
		isCarnivore = false;
		parent = null;
	}
	
	/**
	 * adds a preyNode as prey to this node. Add nodes in the
	 * order of left middle right.
	 * 
	 * 
	 * @param preyNode
	 *   the prey to this Node
	 *   
	 * <dt>Preconditions:
	 *   <dd>this node is not a plant. atleast one of the three child
	 *   node positions of this node is available. the type of prey correctly 
	 *   corresponds to the diet of this node
	 *   
	 * <dt>Postconditions:
	 *   <dd>either an exception is thrown or preyNode is added
	 *   
	 * @throws PositionNotAvailableException
	 *   thrown if there is no space for the child to be added
	 *   
	 * @throws IsPlantException
	 *   thrown if the node added to is a Plant
	 *   
	 * @throws DietMismatchException
	 *   if the diet of this node doesn't match its prey.
	 *   
	 */
	public void addPrey( OrganismNode preyNode ) throws 
		PositionNotAvailableException, IsPlantException, DietMismatchException
	{	
		if( isPlant() == true )
		{
			throw new IsPlantException( "Can't add prey to plant!");
		}
		if( !(isHerbivore == true && isCarnivore == true) )
		{
			if( isHerbivore() == true && isCarnivore() == false 
					&& preyNode.isPlant() == false 
					|| isCarnivore() == true && 
					isHerbivore() == false && preyNode.isPlant() == true )
			{
				throw new DietMismatchException( "The prey doesn't match with the predator");
			}
		}
		
		if( getLeft() == null )
		{
			setLeft( preyNode );
		}
		else if( getMiddle() == null )
		{
			setMiddle( preyNode );
		}
		else if( getRight() == null )
		{
			setRight( preyNode );
		}
		else
		{
			throw new PositionNotAvailableException( "No space to add Prey!" );
		}
	}

	/**
	 * returns the name of this node
	 * 
	 * @return name
	 *  the name of the node
	 */
	public String getName() 
	{
		return name;
	}

	/**
	 * returns whether this is a Plant
	 * 
	 * @return isPlant
	 *   true if Plant otherwise false
	 */
	public boolean isPlant()
	{
		return isPlant;
	}

	/**
	 * returns whether is Herbivore or not.
	 * 
	 * @return isHerbivore
	 *   returns whether it is true or false
	 */
	public boolean isHerbivore() 
	{
		return isHerbivore;
	}

	/**
	 * returns whether is Carnivore or not
	 * 
	 * @return isCarnivore
	 *   true or false for whether it is carnivore or not
	 */
	public boolean isCarnivore() 
	{
		return isCarnivore;
	}

	/**
	 * returns left of this node
	 * 
	 * @return left
	 *   the left of this node
	 */
	public OrganismNode getLeft()
	{
		return left;
	}

	/**
	 * returns middle of this node
	 * 
	 * @return middle
	 *   the middle node
	 */
	public OrganismNode getMiddle() 
	{
		return middle;
	}

	/**
	 * returns the right of this node
	 * 
	 * @return right
	 *   the right node
	 */
	public OrganismNode getRight()
	{
		return right;
	}
	
	/**
	 * sets new Name 
	 * 
	 * @param name
	 *   the new name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * sets Plant to true or false
	 * 
	 * @param isPlant
	 *   the parameter for setting either true or false
	 */
	public void setPlant(boolean isPlant)
	{
		this.isPlant = isPlant;
	}
	
	/**
	 * sets herbivore to true or false
	 * 
	 * @param isHerbivore
	 *   the parameter for setting either true or false
	 */
	public void setHerbivore(boolean isHerbivore)
	{
		this.isHerbivore = isHerbivore;
	}
	
	/**
	 * sets Carnivore to true or false
	 * 
	 * @param isCarnivore
	 *   the parameter for setting either true or false
	 */
	public void setCarnivore(boolean isCarnivore)
	{
		this.isCarnivore = isCarnivore;
	}
	
	/**
	 * sets Left to new value
	 * 
	 * @param left
	 *   the parameter for setting it to either the new left
	 */
	public void setLeft(OrganismNode left)
	{
		this.left = left;
	}
	
	/**
	 * sets middle to new value
	 * 
	 * @param middle
	 *   the parameter for setting it to either the new middle
	 */
	public void setMiddle(OrganismNode middle)
	{
		this.middle = middle;
	}
	
	/**
	 * sets right to new value
	 * 
	 * @param right
	 *   the parameter for setting it to either the new right
	 */
	public void setRight(OrganismNode right) 
	{
		this.right = right;
	}

	/**
	 * returns parent
	 * 
	 * @return parent
	 *   returns the parent
	 */
	public OrganismNode getParent() 
	{
		return parent;
	}

	/**
	 * sets to the new parent.
	 * 
	 * @param parent 
	 *   the new parent
	 */
	public void setParent(OrganismNode parent) 
	{
		this.parent = parent;
	}
}	
