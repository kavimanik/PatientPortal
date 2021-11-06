package JavaCode;

import java.util.ArrayList;

public class Nurse extends User {

	private ArrayList<Patient> patientList;

	public void setWeight(Patient patient, int newWeight) {
		
	}

	public void setHeight(Patient patient, int newHeight) {

	}

	public void setBodyTemp(Patient patient, int newTemp) {

	}

	public void setBloodPressure(Patient patient, int newPres) {

	}

	public void setAllergies(Patient patient, String newAllergies) {

	}

	public void setHealthConcerns(Patient patient, String newConcerns) {

	}

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

}
