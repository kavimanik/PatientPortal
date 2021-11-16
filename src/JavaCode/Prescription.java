package JavaCode;
public class Prescription 
{
	private String medName;
	private int dosage;

	Prescription(){ this("", 0); }
	Prescription(String med, int num){
		medName = med;
		dosage = num;
	}
	
	//Setter
	public void setMedName(String med) { medName = med; }
	public void setDosage(int num) { dosage = num; }
	
	//Getter
	public String getMedName(String med) { return medName; }
	public int getDosage(int num) { return dosage; }

	public String toString() { return "Med Name: " + medName + "\nDosage: " + dosage; }
}
