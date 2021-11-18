package JavaCode;
import java.util.ArrayList;

public class Patient extends User {

	private String phoneNum;
	private String email;
	private String insurance;
	private String pharmacy;
	private Doctor assignedDr;
	private Nurse assignedNurse;
	private String weight;
	private String height;
	private String temperature;
	private String bloodPressure;
	private String allergies;
	private String healthConcerns;
	private String physicalTestResults;
	private String immunizationRecords;
	
	public ArrayList<Visit> pastVisits;
	
	private ArrayList<Prescription> prescribedMeds;
	
	public ArrayList<String> docMsg;
	public ArrayList<String> nurseMsg;

	//Constructor
	public Patient() { this("", "", "", "", ""); }
	public Patient(String first, String last, String user, String pass, String birth) {
		super(first, last, user, pass, "Patient", birth);
		phoneNum = "";
		email = "";
		insurance = "";
		pharmacy = "";
		weight = "";
		height = "";
		temperature = "";
		allergies = "";
		healthConcerns = "";
		physicalTestResults = "";
		immunizationRecords = "";
		pastVisits = new ArrayList<Visit>();
		prescribedMeds = new ArrayList<Prescription>();
		docMsg = new ArrayList<String>();
		nurseMsg = new ArrayList<String>();
		assignedDr = null;
		assignedNurse = null;
	}

	//Messaging
	// The message will always start with D:, N: or P: indicating who the send is (this is for file reading)
	// All users will be able to use the methods but will pass in their respective roles
	public void docMessage(String msg, String role) {
		switch(role) {
		case "Doctor":
			docMsg.add("D}" + msg);
			break;
		case "Patient":
			docMsg.add("P}" + msg);
			break;
		default:
			// Notify User that message was unable to send
			// Should not reach this
			break;
		}
	}
	public void addDocMessage(String msg) // used for reading of the file
	{
		docMsg.add(msg);
	}
	public void nurseMessage(String msg, String role) {
		switch(role) {
		case "Nurse":
			nurseMsg.add("N}" + msg);
			break;
		case "Patient":
			nurseMsg.add("P}" + msg);
			break;
		default:
			// Notify User that message was unable to send
			// Should not reach this
			break;
		}
	}
	public void addNurseMessage(String msg)
	{
		nurseMsg.add(msg);
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
	
	// Adds a Prescription to the list
	public void addAPrescription(String name, String dosage) {
		Prescription a = new Prescription(name, dosage);
		prescribedMeds.add(a);
	}
	
	
	//Setters
	public void setPhoneNumber(String num) { phoneNum = num; }
	public void setFirstName(String name) { super.setFirstName(name); }
	public void setLastName(String name) { super.setLastName(name); }
	public void setUser(String user) { super.setUser(); }
	public void setPass(String pass) { super.setPass(); }
	public void setBirthdate(String date) { super.setBirth(date); }
	public void setPhysicalTestResults(String results) {physicalTestResults = results; }
	public void setImmunizationRecord(String records) {immunizationRecords = records; }
	
	public void setEmail(String mail) { email = mail; }
	public void setInsurance(String insure) { insurance = insure; }
	public void setPharmacy(String pharm) { pharmacy = pharm; }
	public void setDoctor(Doctor d) { assignedDr = d; }
	public void setNurse(Nurse n) { assignedNurse = n; }
	public void setWeight(String w) {	weight = w; }
	public void setHeight(String h) {	height = h; }
	public void setTemp(String t) { temperature = t; }
	public void setBloodPres(String bp) { bloodPressure = bp; }
	public void setAllergies(String a) { allergies = a; }
	public void setHealthConcerns(String hc) { healthConcerns = hc; }

	// Getters
	public String getPhoneNumber() { return phoneNum; }
	public String getFirstName() { return super.getFirstName(); }
	public String getLastName() { return super.getLastName(); }
	public String getUser() { return super.getUser(); }
	public String getPass() { return super.getPass(); }
	public String getRole() { return super.getRole(); }
	public String getBirthdate() { return super.getBirth();}
	
	public String getEmail() { return email; }
	public String getInsurance() { return insurance; }
	public String getPharmacy() { return pharmacy; }
	public Doctor getDoctor() { return assignedDr; }
	public Nurse getNurse() { return assignedNurse; }
	public String getWeight() { return weight; }
	public String getHeight() { return height; }
	public String getTemp() { return temperature; }
	public String getBloodPres() { return bloodPressure; }
	public String getAllergies() { return allergies; }
	public String getHealthConcerns() { return healthConcerns; }
	public String getPhysicalTestResults() {return physicalTestResults; }
	
	
	public String toString()
	{
		// Complies All the ArrayList in Patient into a Printable Strings for toString
		String allPastVisits, allPrescribedMeds, allDocMsg, allNurseMsg;
		allPastVisits = ""; allPrescribedMeds = ""; allDocMsg = ""; allNurseMsg = "";
		int numOfVisits = 0;
		for(int i = 0; i < pastVisits.size(); i++)
		{ 
			numOfVisits++;
			allPastVisits = allPastVisits + "\nVisit " + numOfVisits + "\n" + pastVisits.get(i).toString() + "\n";
		}
		for(int i = 0; i < prescribedMeds.size(); i++){ allPrescribedMeds = allPrescribedMeds +" \n" + prescribedMeds.get(i).toString() + "\n"; }
		for(int i = 0; i < docMsg.size(); i++){ allDocMsg = allDocMsg + docMsg.get(i)+ "\n"; }
		for(int i = 0; i < nurseMsg.size(); i++){ allNurseMsg = allNurseMsg + nurseMsg.get(i)+ "\n"; }
		
		/* First Name: Jon
		 * Last Name: Smith
		 * Username: Smith
		 * Password: Jon
		 * Birth: 01011990
		 * Phone Num: 1234567890
		 * Email: JonSmith@gmail.com
		 * Insurance:
		 * Pharmacy:
		 * Doctor First:
		 * Doctor Last:
		 * Nurse First:
		 * Nurse Last:
		 * Weight:
		 * Height:
		 * BodyTemp:
		 * BloodPressure:
		 * Allergies:
		 * Health Concerns:
		 * Physical Test Results:
		 * Immunization Records: 
		 * PastVisits:
		 * 
		 * Prescribed Meds:
		*/
		String doctorToString = "\nDoctor First Name:\nDoctor Last Name:";
		if(this.getDoctor() != null)
		{
			doctorToString = "\nDoctor First Name: " + this.getDoctor().getFirstName() + "\nDoctor Last Name: " + this.getDoctor().getLastName();
		}
		String nurseToString = "\nNurse First Name:\nNurse Last Name:";
		if(this.getNurse() != null)
		{
			nurseToString = "\nNurse First Name: " + this.getNurse().getFirstName() + "\nNurse Last Name: " + this.getNurse().getLastName();
		}
		return "First name: " + this.getFirstName() + "\nLast Name: " + this.getLastName() + "\nUsername: " + this.getUser() + "\nPassword: " + this.getPass() 
		+ "\nBirth: " + this.getBirth() + "\nPhone Num: " + this.phoneNum + "\nEmail: " + this.email + "\nInsurance: " + this.insurance + "\nPharmacy: " + this.pharmacy 
		+ doctorToString + nurseToString + "\nWeight: " + this.weight + "\nHeight: " + this.height + "\nBodyTemp: " + this.temperature 
		+ "\nBloodPressure: " + this.bloodPressure + "\nAllergies: " + this.allergies  + "\nHealth Concerns: " + this.healthConcerns + "\nPhysical Test Results: " + 
		this.physicalTestResults + "\nImmunizationRecords: " + this.immunizationRecords + "\nPastVisits:\n" + allPastVisits + "\nPrescribed Meds: " + allPrescribedMeds + 
		"\nDoctor Messages:\n" + allDocMsg + "\nNurse Messages:\n" + allNurseMsg;
	}

}
