package JavaCode;
import java.util.ArrayList;

public class Doctor extends Nurse {

	public ArrayList<Patient> patientList; //each doctor has a list of their patients 
	
	//Constructor
	public Doctor(String first, String last, String user, String pass, String role, String birth) { 
		super(first, last, user, pass, "Doctor", birth);
		patientList = new ArrayList<Patient>();
	}
	
	//Change Patient Information
	public void setPhyTestResults(Patient patient,String newTest) { }
	public void setImmuneRecords(Patient patient,String newImmune) {}
	public void prescribeMeds(Patient patient, String newMed, int newDose) {}

	// Change Patient
	public void addPatient(String patientFirst, String patientLast) {
		Patient a = Storage.searchPatient(patientFirst,patientLast);
		patientList.add(a);
		//a.setDoctor(this); //set the patient's doctor as the current doctor
	}
	public void removePatient(String removedPatient) {
		Patient a = searchPatient(removedPatient);
		a.setDoctor(null); //patient is no longer associated with a doctor
		patientList.remove(a);
	}
	
	// Message Patient
	public void msgPatient(Patient p, String msg) { p.docMessage(msg, "Doctor"); } //doctors can only message patients
	
	//to format and print the Doctor's information
	public String toString()
	{
		return "First name: " + this.getFirstName() + "\nLastName: " + this.getLastName() + "\nUsername: " + this.getUser() + "\nPassword: " + this.getPass() + "\nBirth: " + this.getBirth();
	}

	//to format and print the Doctor's information when writing to the file
	public String fileToString() 
	{
		return "DOCI " + this.getFirstName() + ":" + this.getLastName() + ";" + this.getUser() + "," + this.getPass() + ".Doctor/" + this.getBirth() + "\n";
	}
}
