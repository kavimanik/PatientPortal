package JavaCode;
import java.util.ArrayList;

public class Doctor extends Nurse {

	public ArrayList<Patient> patientList;
	
	//Constructor
	public Doctor(String first, String last, String user, String pass, String role, String birth) { super(first, last, user, pass, "Doctor", birth); }
	
	//Change Patient Information
	public void setPhyTestResults(Patient patient,String newTest) { }
	public void setImmuneRecords(Patient patient,String newImmune) {}
	public void prescribeMeds(Patient patient, String newMed, int newDose) {}

	// Change Patient
	public void addPatient(String newPatient) {
		Patient a = searchPatient(newPatient);
		patientList.add(a);
		a.setDoctor(this);
	}
	public void removePatient(String removedPatient) {
		Patient a = searchPatient(removedPatient);
		a.setDoctor(null);
		patientList.remove(a);
	}
	public String toString()
	{
		return "First name: " + this.getFirstName() + "\nLastName: " + this.getLastName() + "\nUsername: " + this.getUser() + "\nPassword: " + this.getPass() + "\nBirth: " + this.getBirth();
	}
	
	// Message Patient
	public void msgPatient(Patient p, String msg) { p.docMessage(msg, "Doctor"); }
}
