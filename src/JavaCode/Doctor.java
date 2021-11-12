package JavaCode;
import java.util.ArrayList;

public class Doctor extends Nurse {

	public ArrayList<Patient> patientList;
	
	//Constructor
	public Doctor(String first, String last, String user, String pass, String role, int birth) { super(first, last, user, pass, "Doctor", birth); }
	
	
	public void setPhyTestResults(Patient patient,String newTest) {
		
	}

	public void setImmuneRecords(Patient patient,String newImmune) {
		
	}

	public void prescribeMeds(Patient patient, String newMed, int newDose) {

	}

	public void addPatient(String newPatient) {
		Patient a = searchPatient(newPatient);
		patientList.add(a);
		a.setDoctor(this);
	}

	public void removePatient(String removedPatient) {
		patientList.remove(searchPatient(removedPatient));

	}

}
