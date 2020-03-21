import java.util.*;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class FoodPyramid 
{
	/**
	 * Default constructor and creates other constructors 
	 * and objects for these methods to work
	 * 
	 * @param args
	 *   default parameter for the main method
	 */
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("\nWhat is the name of the apex predator?: ");
		String predator = in.nextLine().toLowerCase();
		OrganismNode pred = new OrganismNode( predator );
		
		boolean terminate = false;
		String type = "";
		
		while( terminate != true)
		{
			System.out.print("\nIs the organism an herbivore / a carnivore / an omnivore? (H / C / O): ");
			type = in.nextLine().toUpperCase();
			if( type.equals("H") || type.equals("O") || type.equals("C"))
			{
				terminate = true;
				System.out.print("\nConstructing food pyramid. . .");
			}
			else
			{
				System.out.println("\nfalse type of diet!");
			}
		}
		System.out.print("\n");
		
		if( type.equals("H") )
		{
			pred.setHerbivore( true );
		}
		else if( type.equals("C") )
		{
			pred.setCarnivore(true);
		}
		else
		{
			pred.setCarnivore(true);
			pred.setHerbivore(true);
		}
		
		OrganismTree tree = new OrganismTree( pred );
		boolean quit = false;
		
		do
		{
			System.out.print("\nMenu: ");
			System.out.print("\n");
			System.out.print("\n(PC) - Create New Plant Child");
			System.out.print("\n(AC) - Create New Animal Child");
			System.out.print("\n(RC) - Remove Child");
			System.out.print("\n(P) - Print Out Cursor’s Prey");
			System.out.print("\n(C) - Print Out Food Chain");
			System.out.print("\n(F) - Print Out Food Pyramid at Cursor");
			System.out.print("\n(LP) - List All Plants Supporting Cursor");
			System.out.print("\n(R) - Reset Cursor to Root");
			System.out.print("\n(M) - Move Cursor to Child");
			System.out.print("\n(Q) - Quit");
			System.out.print("\n");
			System.out.print("\nPlease select an option: ");
			
			String response = in.next().toUpperCase();
			System.out.print("\n");
			
			switch( response )
			{
			case "PC":
				System.out.print("What is the name of the organism?: ");
				in.nextLine();
				String org = in.nextLine().toLowerCase();
				
				try 
				{
					tree.addPlantChild(org);
					OrganismNode left = tree.getCursor().getLeft();
					OrganismNode middle = tree.getCursor().getMiddle();
					OrganismNode right = tree.getCursor().getRight();
					
					if( left != null && left.getName().equals(org)
							|| middle != null && middle.getName().equals(org)
							|| right != null && right.getName().equals(org))
					{
						System.out.print("\nA(n) " + org + 
								" has successfully been added as prey for the " + 
									tree.getCursor().getName() +"!");
					}
				} 
				catch (IllegalArgumentException e)
				{
					System.out.print("\nError: prey already exists!");
				}
				catch (PositionNotAvailableException e) 
				{
					System.out.print("\nERROR: There is no more "
							+ "room for more prey for this predator.");
				}
				break;
			
			case "AC":
				System.out.print("What is the name of the organism?: ");
				in.nextLine();
				String organism = in.nextLine().toLowerCase();
				
				boolean isHerbivore = false;
				boolean isCarnivore = false;
				System.out.print("\nIs the "
						+ "organism an herbivore / "
						+ "a carnivore / an omnivore? (H / C / O): ");
				String typeChild = in.next().toUpperCase(); 
				
				if( typeChild.equals("H") )
				{
					isHerbivore = true;
				}
				else if( typeChild.equals("C") )
				{
					isCarnivore = true;
				}
				else
				{
					isCarnivore = true;
					isHerbivore = true;
				}
				
				try 
				{
					tree.addAnimalChild(organism, isHerbivore, isCarnivore);
					OrganismNode left = tree.getCursor().getLeft();
					OrganismNode middle = tree.getCursor().getMiddle();
					OrganismNode right = tree.getCursor().getRight();
					
					if( left != null && left.getName().equals(organism)
							|| middle != null && middle.getName().equals(organism)
							|| right != null && right.getName().equals(organism))
					{
						System.out.print("\nA(n) " + organism + 
								" has successfully been added as prey for the " + 
									tree.getCursor().getName() +"!");
					}
				} 
				catch (IllegalArgumentException e)
				{
					System.out.print("\nError: prey already exists");
				}
				catch (PositionNotAvailableException e) 
				{
					System.out.print("\nERROR: There is no more "
							+ "room for more prey for this predator.");
				}
				
				break;
				
			case "RC":
				System.out.print("\nWhat is the name of the organism "
						+ "to be removed?: ");
				in.nextLine();
				String child = in.nextLine().toLowerCase();
				
				try
				{
					tree.removeChild( child );
					System.out.print("\nA(n) " + child + 
							" has successfully been removed as prey for the " + 
								tree.getCursor().getName() +"!");
				}
				catch( IllegalArgumentException e )
				{
					System.out.print("\nERROR: this child doesn't exist!");
				}
				
				break;
				
			case "P":
				try
				{
					System.out.print("\n" + tree.listPrey());
					System.out.print("\n");
				} 
				catch (IsPlantException e) 
				{
					System.out.print("\nERROR: plants don't have any prey");
				}
				break;
				
			case "C":
				String c = tree.listFoodChain();
				System.out.print( c );
				
				break;
			case "F":
				tree.printOrganismTree();
				break;
				
			case "LP":
				tree.listAllPlants();
				break;
				
			case "R":
				tree.cursorReset();
				System.out.print("\nCursor successfully reset to root!");
				break;
				
			case "M":
				System.out.print("\nMove to?: ");
				in.nextLine();
				String name = in.nextLine().toLowerCase();
				
				tree.moveCursor( name );
				
				System.out.print("\nCursor successfully moved to "+ name +"!");
				System.out.print("\n");
				break;
				
			default:
				if( response.equals("Q"))
				{
					System.out.print("\nProgram terminating successfully...");
					quit = true;
				}
				break;
			}
		}
		while( quit != true);
	}
}
