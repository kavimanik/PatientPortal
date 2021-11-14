package JavaCode;

import java.util.ArrayList;

public class Nurse extends User {
	
	public ArrayList<Patient> patientList;
	public Patient currentPatient;
	
	//Constructor
	public Nurse(String first, String last, String user, String pass, String role, int birth) { super(first, last, user, pass, role, birth); }
	public Nurse(String first, String last, String user, String pass, int birth) { super(first, last, user, pass, "Nurse", birth); }
	
	//Change Patient Information
	public void setWeight(Patient patient, int newWeight) { patient.setWeight(newWeight); }
	public void setHeight(Patient patient, int newHeight) { patient.setHeight(newHeight); }
	public void setBodyTemp(Patient patient, int newTemp) { patient.setTemp(newTemp); }
	public void setBloodPressure(Patient patient, int newPres) { patient.setBloodPres(newPres); }
	public void setAllergies(Patient patient, String newAllergies) { patient.setAllergies(newAllergies); }
	public void setHealthConcerns(Patient patient, String newConcerns) { patient.setHealthConcerns(newConcerns); }

	public Patient searchPatient(String patientName) {
		for(int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getFirstName().compareTo(patientName) == 0) {
				return patientList.get(i);
			}
		}
		return new Patient();
	}

	public Patient searchPatient(String patientName, int bday) {
		return new Patient();
	}

	// Changes to Patient List
	public void addPatient(String patient) {
		Patient a = searchPatient(patient);
		patientList.add(a);
		a.setNurse(this);
	}
	public void removePatient(String patient) {
		Patient a = searchPatient(patient);
		a.setNurse(null);
		patientList.remove(a);
	}
	
	// Message Patient
	public void msgPatient(Patient p, String msg) { p.nurseMessage(msg, "Nurse"); }
}
