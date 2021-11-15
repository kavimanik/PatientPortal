// Class that stores all the Doctors, Nurses and Patients

package JavaCode;

import java.util.ArrayList;

public class Storage {

	private static ArrayList<Patient> allPatients;
	private static ArrayList<Doctor> allDoctors;
	private static ArrayList<Nurse> allNurses;
	
	Storage(){}
	
	// i is the index of the variable in its respective Array List
	static Nurse getNurse(int i) { return allNurses.get(i); }
	static Doctor getDoctor(int i) { return allDoctors.get(i); }
	static Patient getPatient(int i) { return allPatients.get(i); }
	
	static void setNurse(Nurse i) { allNurses.add(i); }
	static void setDoctor(Doctor i) { allDoctors.add(i); }
	static void setPatient(Patient i) { allPatients.add(i); }
}
