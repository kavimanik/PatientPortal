// Class that stores all the Doctors, Nurses and Patients

package JavaCode;

import java.util.ArrayList;

public class Storage {

	private static ArrayList<Patient> allPatients;
	private static ArrayList<Doctor> allDoctors;
	private static ArrayList<Nurse> allNurses;
	private static User currentUser;
	
	public Storage(){}
	
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
}