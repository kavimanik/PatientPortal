package JavaCode;

import java.util.ArrayList;
import java.text.SimpleDateFormat;  
import java.util.Date;    

public class Visit {

	//private int date;
	private String date;
	private int weight;
	private int height;
	private int bodyTemp;
	private int bloodPressure;
	private String allergies;
	private String healthConcerns;
	private String physicalTestResults;
	private String immunizationRecords;
	private ArrayList<Prescription> prescription;
	
	
	

	Visit(int w, int h, int temp, int bp, String allergies, String hc, String ptr, String ir, ArrayList<Prescription> prescript){
		date = getDate();
		weight = w;
		height = h;
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
}


