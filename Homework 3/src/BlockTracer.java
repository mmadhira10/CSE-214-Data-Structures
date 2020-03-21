
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm
 *         - 4:53pm
 */
public class BlockTracer
{
	/**
	 * the main method of the this project 
	 * that follows four different arguments 
	 * whether it be {, int , },or /*print 
	 * and give commands to follow for each
	 * 
	 * @param args
	 *   the default parameter of the main method
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		boolean quit = false;
		Stack<Block> st = new Stack<Block>();
		do
		{
			while( !st.empty())
			{
				st.pop();
			}
			System.out.print("\n");
			System.out.print("\n");
			System.out.print("\nEnter File Name: ");
			String fileName = in.next();
			File file = new File(fileName);
			Scanner stdin = null;
			try 
			{
				stdin = new Scanner(file);
				Block a;
				while (stdin.hasNextLine()) 
				{

					String str = stdin.nextLine();
					if (str.contains("{"))
					{
						a = new Block();
						st.push(a);
					}
					if (str.contains("int ")) 
					{
						int index = str.indexOf("int ") + 4;
						String mod = str.substring(index, 
								str.length()).replaceAll("//s", "");
						String name = "";
						String value = "";

						char[] characters = mod.toCharArray();

						for (char c : characters) 
						{
							if (c == '=')
							{

							} 
							else if (Character.isLetter(c))
							{
								name += c;
							}
							else if (Character.isDigit(c))
							{
								value += c;
							} 
							else if (c == ',')
							{
								if (value.equals(""))
								{
									value = "0";
								}
								Block b = st.pop();
								b.add(name, value);
								st.push(b);
								name = "";
								value = "";
							} 
							else if (c == ';')
							{
								if (value.equals(""))
								{
									value = "0";
								}
								Block b = st.pop();
								b.add(name, value);
								st.push(b);
								break;
							}
						}
					}
					if (str.contains("/*$print"))
					{
						if (str.contains("LOCAL"))
						{
							Block b = st.pop();
							b.printBlock();
							st.push(b);
						} 
						else 
						{
							int index1 = str.indexOf("/*$print") + 9;
							int index2 = str.indexOf("*/");
							String variableName = 
									str.substring(index1, index2);
							String blockVar = "";
							String blockVal = "";
							Stack<Block> temp = new Stack<Block>();

							while ( blockVar == "" && !st.empty() )
							{
								Block b = st.pop();
								ArrayList<Variable> abc = b.getlist();
								for( int x = 0; x < abc.size(); x++ )
								{
									if (abc.get(x).getName().
											equals(variableName)) 
									{
										blockVar = variableName;
										blockVal = abc.get(x).getValue();
										break;
									}
								}
								
								temp.push(b);
							}
							if (blockVar.equals(variableName))
							{
								System.out.println();
								System.out.printf("%5s %25s", 
										"Variable Name", "Initial Value");
								System.out.println();
								System.out.printf("%1s %25s", 
										blockVar, blockVal);
								System.out.println();
							} 
							else
							{
								
								System.out.print
								  ("Variable not found: " + variableName + "\n");
						
							}

							while (!temp.empty())
							{
								st.push(temp.pop());
							}

						}
					}
					if (str.contains("}"))
					{
						st.pop();
						
					}
				}
			}
			catch (FileNotFoundException e)
			{
				System.out.print("File doesn't exist!");
			}
		} 
		while (quit != true);
	}
}
