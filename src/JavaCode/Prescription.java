package JavaCode;
public class Prescription 
{
	private String medName;
	private String dosage;

	//constructors
	public Prescription(){ this("", ""); }
	public Prescription(String med, String num){
		medName = med;
		dosage = num;
	}
	
	//Setter
	public void setMedName(String med) { medName = med; }
	public void setDosage(String num) { dosage = num; }
	
	//Getter
	public String getMedName(String med) { return medName; }
	public String getDosage(int num) { return dosage; }

	public String toString() { return "Med Name: " + medName + "\nDosage: " + dosage; }
}
