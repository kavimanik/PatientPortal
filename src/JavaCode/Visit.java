package JavaCode;

import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;    

public class Visit {

	//private int date;
	private String date;
	private String weight;
	private String height;
	private String bodyTemp;
	private String bloodPressure;
	private String allergies;
	private String healthConcerns;
	private String physicalTestResults;
	private String immunizationRecords;
	private ArrayList<Prescription> prescription;
	
	
	

	public Visit(String w, String height2, String temp, String bp, String allergies, String hc, String ptr, String ir, ArrayList<Prescription> prescript){ //TODO change Date/prescription
		date = getDate();
		weight = w;
		height = height2;
		bodyTemp = temp;
		bloodPressure = bp;
		this.allergies = allergies;
		healthConcerns = hc;
		physicalTestResults = ptr;
		immunizationRecords = ir;
		prescription = prescript;
	}
	
	public String getDate()
	{
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date today = new Date(System.currentTimeMillis());
		//System.out.println(formatter.format(today));

		return formatter.format(today);
	}
	
	
	public String toString() {
		return "Date: " + date + "\nWeight: " + weight + "\nHeight: " + height + "\nBodyTemp: " + bodyTemp + "\nBloodPressure: " 
	+ bloodPressure + "\nAllergies: " + allergies + "\nHealth Concerns: " + healthConcerns + "\nPhysical Test Results: " + physicalTestResults 
	+ "\nImmunization Records: " + immunizationRecords + "\nPrescription: " + prescription;
	}
	public String fileToString()
	{
		return weight + "," + height + "," + bodyTemp + "," + bloodPressure + "," + allergies + "," + healthConcerns + "," + physicalTestResults + "," + immunizationRecords + "," + prescription;
	}
}


