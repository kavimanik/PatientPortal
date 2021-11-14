package JavaCode;

import java.util.ArrayList;

public class Visit {

	private int date;
	private int weight;
	private int height;
	private int bodyTemp;
	private int bloodPressure;
	private String allergies;
	private String healthConcerns;
	private String physicalTestResults;
	private String immunizationRecords;
	private Prescription prescription;

	Visit(int w, int h, int temp, int bp, String allergies, String hc, String ptr, String ir, Prescription prescript){
		// Date = set to the current date
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
}
