package application;

//import JavaCode.*;

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
	
//	private static ArrayList<Patient> allPatients;
//	private static ArrayList<Doctor> allDoctors;
//	private static ArrayList<Nurse> allNurses;
// 	private static User currentUser;
	
	public static void main(String[] args) throws FileNotFoundException {
		int i = 0;
		
		// Reads the load file, if empty, nothing will the created
		//readFile();
		
		// Launches the JavaFX Scene
		launch(args);

//		Login in Page
//
//		// If creates a new account
//		if(i == 0/* create a new account button is selected*/) {
//			switch("Doctor"/* selected role*/) {
//			case "Doctor": 	allDoctors.add(new Doctor());
//							break;
//			case "Nurse":	allNurses.add(new Nurse());
//							break;
//			case "Patient":	allPatients.add(new Patient());
//							break;
//			}
//			//Returns them to the login Page
//			i++;
//		}
//		else if(i == 1) {
//			// Login and password is entered
//			// Change Page to main page associated with the account
//			switch( // selected role from drop down box)	{
//				case Doctor:
//					for(int i = 0; i < allDoctors.size(); i++){
//						if( allDoctors.get(i).getUsername().equal( // username input ) && allDoctors.get(i).getPassword().equal( // password input ){
//							currentUser = allDoctors.get(i);
//						}
//					}
//					if(currentUser == null){
//						// Keep on Login Page, Notify User account doesn't exist
//					}else{
//						// Set to Doctor Homepage
//					}
//					break;
//				case Nurse:
//					for(int i = 0; i < allNurse.size(); i++){
//						if( allDoctors.get(i).getUsername().equal( // username input ) && allDoctors.get(i).getPassword().equal( // password input ){
//							currentUser = allNurses.get(i);
//						}
//					}
//					if(currentUser == null){
//						// Keep on Login Page, Notify User account doesn't exist
//					}else{ // Set to Nurse Home Page
//					}
//					break;
//				case Patient:
//					for(int i = 0; i < allNurse.size(); i++){
//						if( allDoctors.get(i).getUsername().equal( // username input ) && allDoctors.get(i).getPassword().equal( // password input ){
//							currentUser = allNurses.get(i);
//						}
//					}
//					if(currentUser == null){
//						// Keep on Login Page, Notify User account doesn't exist
//					}else{
//						// Set to Patient Home Page
//					}
//					break;
//
//			}
		
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
		      //appData = new File("C:\\Users\\randa\\eclipse-workspace\\CSE360FileRead\\src\\appData.txt");
			  //appData = new File("C:\\Users\\Brand\\Desktop\\School\\SophmoreYear\\CSE-360\\PatientPortal\\src\\application\\appData.txt");
		      
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
		return true; // we've successfully read the file
	}
    
    public static boolean saveFile() throws FileNotFoundException{
    	return true;
    }
//    public static void displayMessages(Patient p, String role) {
//    	// Updates the text box for msg between Nurse, Doctors and Patients
//    	for(int i = 0; i < p.size(); i++) {
//    		
//    	}
//    	
//   }
}