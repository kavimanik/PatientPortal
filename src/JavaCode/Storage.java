// Class that stores all the Doctors, Nurses and Patients

package JavaCode;

import java.util.ArrayList;

import javafx.fxml.FXMLLoader;

public class Storage {

	private static ArrayList<Patient> allPatients;
	private static ArrayList<Doctor> allDoctors;
	private static ArrayList<Nurse> allNurses;
	private static User currentUser;
	
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
	public static User getCurrentUser(int i) { return currentUser; }
	
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
	public static User Search(String role, String First, String Last, String Birth) {
		switch(role) {
		case "Doctor": 
			for(int i = 0; i < allDoctors.size(); i++) {
        		if(getDoctor(i).getFirstName().equals(First) && getDoctor(i).getLastName().equals(Last)) { return getDoctor(i); }}
			return new User("", "", "", "", "", "");
		case "Nurse":
			for(int i = 0; i < allNurses.size(); i++) {
        		if(getNurse(i).getFirstName().equals(First) && getNurse(i).getLastName().equals(Last)) { return getNurse(i); }}
			return new User("", "", "", "", "", "");
		case "Patient":
			for(int i = 0; i < allPatients.size(); i++) {
        		if(getPatient(i).getFirstName().equals(First) && getPatient(i).getLastName().equals(Last)) { return getPatient(i); }}
			return new User("", "", "", "", "", "");
		default: return new User("", "", "", "", "", "");// Shouldn't reach here
		}
	}
}