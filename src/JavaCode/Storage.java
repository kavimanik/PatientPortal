// Class that stores all the Doctors, Nurses and Patients

package JavaCode;

import java.util.ArrayList;

import javafx.fxml.FXMLLoader;

public class Storage {

	//ArrayLists to keep track of all the users within the system
	private static ArrayList<Patient> allPatients;
	private static ArrayList<Doctor> allDoctors;
	private static ArrayList<Nurse> allNurses;
	private static User currentUser;
	
	//constructor
	public Storage(){
		allPatients = new ArrayList<Patient>();
		allDoctors = new ArrayList<Doctor>();
		allNurses = new ArrayList<Nurse>();
	}
	
	// Getter, returns the variable from ArrayList
	// i is the index of the variable in its respective Array List
	public static Nurse getNurse(int i) { return allNurses.get(i); }
	public static Doctor getDoctor(int i) { return allDoctors.get(i); }
	public static Patient getPatient(int i) { return allPatients.get(i); }
	public static User getCurrentUser() { return currentUser; }
	public static ArrayList<Patient> getAllPatients() { return allPatients; }
	
	// Checks if this username and password combination already exists in array list
	public static boolean exisit(String role, String user, String pass) {
		switch(role) {
		case "Doctor":
			for(int i = 0; i < allDoctors.size(); i++) { if(getDoctor(i).getUser().equals(user) && getDoctor(i).getPass().equals(pass)) { return true; }} break;
		case "Nurse":
			for(int i = 0; i < allNurses.size(); i++) { if(getNurse(i).getUser().equals(user) && getNurse(i).getPass().equals(pass)) { return true; }} break;
		case "Patient":
			for(int i = 0; i < allDoctors.size(); i++) { if(getDoctor(i).getUser().equals(user) && getDoctor(i).getPass().equals(pass)) { return true; }} break;
		default: //Should not get here
		}
		return false;
	}
	
	// Gets the Size of any of the ArrayLists with "Doctor", "Nurse" or "Patient"
	public static int getSize(String a) {
		switch(a) {
		case "Doctor": return allDoctors.size();
		case "Nurse": return allNurses.size();
		case "Patient": return allPatients.size();
		default: return -1; // Should never reach here
	}}
	
	// Adder, adds a class to the respective linkedList
	public static void addNurse(Nurse i) { allNurses.add(i); }
	public static void addDoctor(Doctor i) { allDoctors.add(i); }
	public static void addPatient(Patient i) { allPatients.add(i); }
	public static void setCurrentUser(User i) { currentUser = i; }
	
	// Search Function, returns empty User not found
	public static ArrayList<User> search(String role, String First, String Last) {
		ArrayList<User> a = new ArrayList<User>();
		switch(role) {
		case "Doctor": 
			for(int i = 0; i < allDoctors.size(); i++) {
        		if(getDoctor(i).getFirstName().equals(First) && getDoctor(i).getLastName().equals(Last)) { a.add(getDoctor(i)); }} return a;
		case "Nurse":
			for(int i = 0; i < allNurses.size(); i++) {
        		if(getNurse(i).getFirstName().equals(First) && getNurse(i).getLastName().equals(Last)) { a.add(getNurse(i)); }} return a;
		case "Patient":
			for(int i = 0; i < allPatients.size(); i++) {
        		if(getPatient(i).getFirstName().equals(First) && getPatient(i).getLastName().equals(Last)) { a.add(getPatient(i)); }} return a;
		default: return a;// Shouldn't reach here
		}
	}
	
	public static Doctor searchDoc(String First, String Last) {
		for(int i = 0; i < allDoctors.size(); i++) {
    		if(getDoctor(i).getFirstName().equals(First) && getDoctor(i).getLastName().equals(Last)) { return getDoctor(i); }}
		// If the Doctor isn't found
		return new Doctor("", "", "", "", "", "");
	}
	public static Nurse searchNurse(String First, String Last) {
		for(int i = 0; i < allNurses.size(); i++) {
    		if(getNurse(i).getFirstName().equals(First) && getNurse(i).getLastName().equals(Last)) { return getNurse(i); }}
		// If the Nurse isn't found
		return new Nurse("", "", "", "", "", "");
	}
	public static Patient searchPatient(String First, String Last) {
		for(int i = 0; i < allPatients.size(); i++) {
    		if(getPatient(i).getFirstName().equals(First) && getPatient(i).getLastName().equals(Last)) { return getPatient(i); }}
		// If the Patient isn't found
		return new Patient("", "", "", "", "");
	}
	
	
	//Prints all the elements of an array specified by the role
	public static void print(String role) {
		switch(role) {
		case "Doctor": 
			for(int i = 0; i < allDoctors.size(); i++) { System.out.println(getDoctor(i).toString()); } 	break;
		case "Nurse":
			for(int i = 0; i < allNurses.size(); i++) { System.out.println(getNurse(i).toString()); } 		break;
		case "Patient":
			for(int i = 0; i < allPatients.size(); i++) { System.out.println(getPatient(i).toString()); } 	break;
		default: System.out.println("Shouldn't reach here, Print ArrayList"); break;
		}
	}
}