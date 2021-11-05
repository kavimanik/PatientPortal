import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
public class Main {

	public static void main(String[] args) throws FileNotFoundException 
	{
		readFile();

	}
	public static boolean readFile() throws FileNotFoundException
	{
		File appData = null; // Initialize it to null, to ensure we can use it later. If the file ends up actually being null, we'll leave the method before we use it.
		try //create the text file to store the data, if it already exists we move on.
		{
		      appData = new File("C:\\Users\\randa\\eclipse-workspace\\CSE360FileRead\\src\\appData.txt");
		      if (appData.createNewFile()) {
		        System.out.println("File created: " + appData.getName());
		        return false; // there is no data to read
		      } else {
		        System.out.println("File already exists.");
		      }
		} 
		catch (IOException e) // Should never reach this Code
		{
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		}
		
		Scanner scanner = new Scanner(appData); // creates a scanner of the text file, now we run through it looking for identifiers.
		while (scanner.hasNextLine()) // this line starts iterating us through the whole file 
		{
            //System.out.println(currentLine + " is the current line");
            //System.out.println(subStringIdentifier + " is the current Identifier");
			
			String currentLine = scanner.nextLine(); // put the line into this string, notably this passes through the line in the file, so no going back
			String subStringIdentifier = currentLine.substring(0, 4); // take the substring of the first 4 characters, This is our identifier for each type of data 
			// we will need to be reading. Essentially the rest of the code will be comparing the identifier to see what we should be doing with our next Line.
            if(subStringIdentifier.compareTo("NOD:") == 0)
            {
            	int numOfDoctors = Integer.parseInt(currentLine.substring(5));
            	System.out.println(numOfDoctors);
            }
            if(subStringIdentifier.compareTo("NON:") == 0)
            {
            	int numOfNurses = Integer.parseInt(currentLine.substring(5));
            	System.out.println(numOfNurses);
            }
            if(subStringIdentifier.compareTo("NOP:") == 0)
            {
            	int numOfPatients = Integer.parseInt(currentLine.substring(5));
            	System.out.println(numOfPatients);
            }
            
        }
		
		scanner.close();
		return true; // we've succesfully read the file
	}

}
