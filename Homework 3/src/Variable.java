import java.util.*;

/**
 * 
 * @author Mihir Madhira
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm
 *         - 4:53pm
 */
public class Variable
{
	String value;
	String name;

	/**
	 * the constructor to create an object for this 
	 * class
	 * 
	 * @param val
	 *   the value for the object
	 * @param varName
	 *   variable's name
	 */
	public Variable(String val, String varName)
	{
		value = val;
		name = varName;
	}

	/**
	 * to return a value from an object
	 * 
	 * @return value
	 *   the value of an object
	 */
	public String getValue() 
	{
		return value;
	}

	/**
	 * sets a new value for the variable
	 * 
	 * @param value
	 *   the new value for the variable
	 */
	public void setValue(String value) 
	{
		this.value = value;
	}

	/**
	 * returns the variable's name
	 * 
	 * @return name
	 *   gives back the name of this variable 
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * sets a new name for the variable
	 * 
	 * @param name
	 *   the new name for the variable
	 */
	public void setName(String name)
	{
		this.name = name;
	}

}
