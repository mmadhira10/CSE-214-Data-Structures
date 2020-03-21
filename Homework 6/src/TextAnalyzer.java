import java.io.File;
import java.util.Scanner;

/**
 * 
 * @author Mihir Madhira 
 * id: 112805894 
 * recitation: 03 Jenny Room 217 Monday 4pm - 4:53pm
 */
public class TextAnalyzer
{
	FrequencyTable frequencyTable;
	
	/**
	 * the main method that displays the console
	 * to find the similarity between passages
	 * 
	 * @param args
	 *   the default parameter for the main method
	 */
	public static void main( String[] args )
	{
		Scanner in = new Scanner(System.in);
		System.out.print("\nEnter the directory of a folder of text files: ");
		String directoryPath = in.nextLine();
		
		System.out.print("\nReading texts...");
		System.out.print("\n");
		System.out.printf("\n" + "%5s %25s", "Text(title)", "Similarities(%)");
		
		File[] directoryOfFiles = new File(directoryPath).listFiles();
		
		for(File i : directoryOfFiles)
		{
			//System.out.print("\n"+ i.getName().substring(0, i.getName().length() - 4));
			Passage p = new Passage( i.getName().substring(0, i.getName().length() - 4), i );
			System.out.print("\n" + p.getTitle() + "          ");
			for( File ind : directoryOfFiles)
			{
				Passage p1;
				double cosine;
				if( !ind.equals(i))
				{
					p1 = new Passage( ind.getName().substring(0, ind.getName().length() - 4), ind );
					cosine = Passage.cosineSimilarity( p, p1 ) * 100 ;
					System.out.print( ind.getName().substring(0, ind.getName().length() - 4) + " ");
					System.out.print( cosine + " " );
				}
			}
			
		}
	}
}
