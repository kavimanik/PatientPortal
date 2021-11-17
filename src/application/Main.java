package application;

import JavaCode.*;

import java.util.ArrayList;
	
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		Storage s = new Storage();
		// Reads the load file, if empty, nothing will the created
		readFile();
		
		// Launches the JavaFX Scene
		launch(args);
	}
	
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../login.fxml"));
    
        Scene scene = new Scene(root, 500, 500);
        
        stage.setTitle("Welcome");
        stage.setScene(scene);
        stage.show();

    }
    
    public static boolean readFile() throws FileNotFoundException
	{
		File appData = null; // Initialize it to null, to ensure we can use it later. If the file ends up actually being null, we'll leave the method before we use it.
		try //create the text file to store the data, if it already exists we move on.
		{
			String workingDirectory = System.getProperty("user.dir");				
			appData = new File(workingDirectory, "appData.txt");
							
			if (appData.createNewFile()) {
				System.out.println("File created, it is called: " + appData.getName() + " \nat the directory: " + appData.getAbsolutePath());
			} else {
				System.out.println("File already exists at: " + appData.getAbsolutePath());
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
            if(subStringIdentifier.compareTo("DOCI") == 0)
            {	
            												//First Name                              //Last Name                                                                          //    Username                                                //Password
            	Doctor doctor = new Doctor( currentLine.substring(5,currentLine.indexOf(":")), currentLine.substring(currentLine.indexOf(":")+1,currentLine.indexOf(";")), currentLine.substring(currentLine.indexOf(";")+1,currentLine.indexOf(",")), currentLine.substring(currentLine.indexOf(",")+1,currentLine.indexOf(".")), "Doctor", currentLine.substring(currentLine.indexOf("/")+1));
            	Storage.addDoctor(doctor);
            }
            else if(subStringIdentifier.compareTo("NURI") == 0)
            {
            	Nurse nurse = new Nurse( currentLine.substring(5,currentLine.indexOf(":")), currentLine.substring(currentLine.indexOf(":")+1,currentLine.indexOf(";")), currentLine.substring(currentLine.indexOf(";")+1,currentLine.indexOf(",")), currentLine.substring(currentLine.indexOf(",")+1,currentLine.indexOf(".")), "Nurse", currentLine.substring(currentLine.indexOf("/")+1));
            	Storage.addNurse(nurse);
            }
            else if(subStringIdentifier.compareTo("PATI") == 0)
            {
            	System.out.println(currentLine);
            	currentLine = currentLine.substring(5); // remove the identifier from the line before splitting
            	String[] splitInfo = currentLine.split(":");
            	Patient patient = new Patient(splitInfo[0],splitInfo[1],splitInfo[2],splitInfo[3],splitInfo[4]);
            	patient.setPhoneNumber(Integer.parseInt(splitInfo[5]));
            	patient.setEmail(splitInfo[6]);
            	patient.setInsurance(splitInfo[7]);
            	patient.setPharmacy(splitInfo[8]);
            	// splitInfo 9 and 10 are the doctors first/last name if they have one associated with them.
            	//splitInfo 11 and 12 are the nurse's first/last name if they have one associated with them.
            	patient.setWeight(Integer.parseInt(splitInfo[13]));
            	patient.setHeight(splitInfo[14]);
            	patient.setTemp(Integer.parseInt(splitInfo[15]));
            	patient.setBloodPres(splitInfo[16]); 
            	patient.setAllergies(splitInfo[17]);
            	patient.setHealthConcerns(splitInfo[18]);
            	patient.setPhysicalTestResults(splitInfo[19]);
            	patient.setImmunizationRecord(splitInfo[20]);
            	//21 is Past visits
            	//22 is the prescriptions
            	//patient.setBloodPres(Integer.parseInt(splitInfo[16])); TODO make it a string
            	patient.setAllergies(splitInfo[17]);
            	patient.setHealthConcerns(splitInfo[18]);
            	// 19 is physical test results
            	//20 is immunization record
            	//21 is past visits
            	//22 is prescribed Medicine
            	Storage.addPatient(patient);
            }
        }
		System.out.println(Storage.getPatient(0).toString());
		//System.out.println(Storage.getDoctor(0).toString());
		//System.out.println(Storage.getDoctor(1).toString());
        //System.out.println(Storage.getNurse(0).toString());
		scanner.close();
		return true; // we've successfully read the file
	}
    
    public static boolean saveFile() throws FileNotFoundException{
    	return true;
    }
}