package JavaCode;

import java.util.ArrayList;

public class Nurse extends User {
	
	public ArrayList<Patient> patientList; //each nurse has a list of their patients
	
	//Constructor
	public Nurse(String first, String last, String user, String pass, String role, String birth) { 
		super(first, last, user, pass, role, birth);
		patientList = new ArrayList<Patient>();
		}
	
	//Change Patient Information
	public void setWeight(Patient patient, String newWeight) { patient.setWeight(newWeight); }
	public void setHeight(Patient patient, String newHeight) { patient.setHeight(newHeight); }
	public void setBodyTemp(Patient patient, String newTemp) { patient.setTemp(newTemp); }
	public void setBloodPressure(Patient patient, String newPres) { patient.setBloodPres(newPres); }
	public void setAllergies(Patient patient, String newAllergies) { patient.setAllergies(newAllergies); }
	public void setHealthConcerns(Patient patient, String newConcerns) { patient.setHealthConcerns(newConcerns); }
	
	public ArrayList<Patient> getAllPatients() { return patientList; }

	//Search for a Patient
	//search using just patient's name
	public Patient searchPatient(String patientName) {
		for(int i = 0; i < patientList.size(); i++) {
			if(patientList.get(i).getFirstName().compareTo(patientName) == 0) {
				return patientList.get(i);
			}
		}
		return new Patient(); //if the patient does not exist, return a new Patient object 
	}

	// Changes to Patient List
	public void addPatient(String patientFirst, String patientLast) {
		Patient a = Storage.searchPatient(patientFirst, patientLast);
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

	public String fileToString() 
	{
		return "NURI " + this.getFirstName() + ":" + this.getLastName() + ";" + this.getUser() + "," + this.getPass() + ".Nurse/" + this.getBirth() + "\n";
	}
}
