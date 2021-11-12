package JavaCode;
import java.util.ArrayList;

public class Patient extends User {

	private int phoneNum;
	private String email;
	private String insurance;
	private String pharmacy;
	private ArrayList<Visit> pastVisits;
	private Doctor assignedDr;
	private Nurse assignedNurse;
	private int weight;
	private int height;
	private int temperature;
	private int bloodPressure;
	private String allergies;
	private String healthConcerns;
	
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

	//Setters
	public void setFirstName(String name) {
		super.setFirstName(name);
	}

	public void setLastName(String name) {
		super.setLastName(name);
	}

	public void setBirthdate(int date) {
		super.setBirth(date);
	}
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
	public String getFirstName() { return super.getFirstName(); }
	public String getLastName(String name) { return super.getLastName(); }
	public String getUser() { return super.getUser(); }
	public String getPass() { return super.getPass(); }
	public String getRole() { return super.getRole(); }
	public int getBirthdate(int date) { return super.getBirth();}
	
	public void viewPastVisits() {}

}
