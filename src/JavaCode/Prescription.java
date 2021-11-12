package JavaCode;
public class Prescription 
{
	private String medName;
	private int dosage;

	Precription(){ this("", ""); }
	Precription(String med, int num){
		medName = med;
		dosage = num;
	}
	
	//Setter
	public void setMedName(String med) { medName = med; }
	public void setDosage(int num) { dosage = num; }
	
	//Getter
	public String setMedName(String med) { return medName; }
	public int setDosage(int num) { return dosage; }

}
