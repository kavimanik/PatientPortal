package JavaCode;
import java.util.ArrayList;

public class Patient extends User {

	private int phoneNum;
	private String email;
	private String insurance;
	private String pharmacy;
	private Doctor assignedDr;
	private Nurse assignedNurse;
	private int weight;
	private int height;
	private int temperature;
	private int bloodPressure;
	private String allergies;
	private String healthConcerns;
	private String physicalTestResults;
	private String immunizationRecords;
	
	private ArrayList<Visit> pastVisits;
	
	private ArrayList<Prescription> prescribedMeds;
	
	private ArrayList<String> docMsg;
	private ArrayList<String> nurseMsg;

	//Constructor
	public Patient() { this("", "", "", "", 0); }
	public Patient(String first, String last, String user, String pass, int birth) {
		super(first, last, user, pass, "Patient", birth);
		phoneNum = 0;
		email = "";
		insurance = "";
		pharmacy = "";
		pastVisits = new ArrayList<Visit>();
		assignedDr = null;
		assignedNurse = null;
	}

	//private PatientProfilePage profile;

	//Messaging
	// The message will always start with D:, N: or P: indicating who the send is
	// All users will be able to use the methods but will pass in their respective roles
	public void docMessage(String msg, String role) {
		switch(role) {
		case "Doctor":
			docMsg.add("D:" + msg);
			break;
		case "Patient":
			docMsg.add("P:" + msg);
			break;
		default:
			// Notify User that message was unable to send
			// Should not reach this
			break;
		}
	}
	public void nurseMessage(String msg, String role) {
		switch(role) {
		case "Doctor":
			nurseMsg.add("N:" + msg);
			break;
		case "Patient":
			nurseMsg.add("P:" + msg);
			break;
		default:
			// Notify User that message was unable to send
			// Should not reach this
			break;
		}
	}
	
	public ArrayList<String> getMessage(String role){
		switch(role) {
		case "Doctor":
			return docMsg;
		case "Nurse":
			return nurseMsg;
		default:
			// Should not get here
			return new ArrayList<String>();
		}
	}
		
	// Make a Visit object that uses all of the Patients current information
	public void makeAVisit() {
		Visit a = new Visit(weight, height, temperature, bloodPressure, allergies, healthConcerns, physicalTestResults, immunizationRecords, prescribedMeds);
		pastVisits.add(a);
	}
	
	
	//Setters
	public void setPhoneNumber(int num) { phoneNum = num; }
	public void setFirstName(String name) { super.setFirstName(name); }
	public void setLastName(String name) { super.setLastName(name); }
	public void setUser(String user) { super.setUser(); }
	public String setPass() { return super.getPass(); }
	public void setBirthdate(int date) { super.setBirth(date); }
	
	public void setEmail(String mail) { email = mail; }
	public void setInsurance(String insure) { insurance = insure; }
	public void setPharmacy(String pharm) { pharmacy = pharm; }
	public void setDoctor(Doctor d) { assignedDr = d; }
	public void setNurse(Nurse n) { assignedNurse = n; }
	public void setWeight(int w) {	weight = w; }
	public void setHeight(int h) {	height = h; }
	public void setTemp(int t) { temperature = t; }
	public void setBloodPres(int bp) { bloodPressure = bp; }
	public void setAllergies(String a) { allergies = a; }
	public void setHealthConcerns(String hc) { healthConcerns = hc; }

	// Getters
	public int getPhoneNumber() { return phoneNum; }
	public String getFirstName() { return super.getFirstName(); }
	public String getLastName() { return super.getLastName(); }
	public String getUser() { return super.getUser(); }
	public String getPass() { return super.getPass(); }
	public String getRole() { return super.getRole(); }
	public int getBirthdate() { return super.getBirth();}
	
	public String getEmail() { return email; }
	public String getInsurance() { return insurance; }
	public String getPharmacy() { return pharmacy; }
	public Doctor getDoctor() { return assignedDr; }
	public Nurse getNurse() { return assignedNurse; }
	public int getWeight() { return weight; }
	public int getHeight() { return height; }
	public int getTemp() { return temperature; }
	public int getBloodPres() { return bloodPressure; }
	public String getAllergies() { return allergies; }
	public String getHealthConcerns() { return healthConcerns; }
	
	//public void viewPastVisits() {}

}
