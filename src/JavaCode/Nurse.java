package JavaCode;

import java.util.ArrayList;

public class Nurse extends User {
	
	public ArrayList<Patient> patientList;
	public Patient currentPatient;
	
	//Constructor
	public Nurse(String first, String last, String user, String pass, String role, String birth) { super(first, last, user, pass, role, birth); }
	
	//Change Patient Information
	public void setWeight(Patient patient, int newWeight) { patient.setWeight(newWeight); }
	public void setHeight(Patient patient, String newHeight) { patient.setHeight(newHeight); }
	public void setBodyTemp(Patient patient, int newTemp) { patient.setTemp(newTemp); }
	public void setBloodPressure(Patient patient, String newPres) { patient.setBloodPres(newPres); }
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
	
	public String toString()
	{
		//String allPatients = "";
		//for(int i = 0; i < patientList.size() -1; i++){ allPatients = allPatients + "First Name: " +  patientList.get(i).getFirstName() + "\nLast Name: " + patientList.get(i).getLastName() 
			//	+ "Birthdate: " +  patientList.get(i).getBirth() + '\n'; }
		
		return "First name: " + this.getFirstName() + "\nLastName: " + this.getLastName() + "\nUsername: " + this.getUser() + "\nPassword: " 
	+ this.getPass() + "\nBirth: " + this.getBirth();
	}
}
