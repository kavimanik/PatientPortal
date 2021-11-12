package JavaCode;
abstract public class User {

	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String role;
	private int birthdate;
	
	public User(String first, String last, String user, String pass, String roles, int birth){
		firstName = first;
		lastName = last;
		username = user;
		password = pass;
		role = roles;
		birthdate = birth;
	}

	//public void makeAcc() {}

	public void loginPortal() {
		
	}

	public void viewPatientPersonalInfo() {

	}

	public void viewPatientMedInfo() {

	}

	public void accessMesPortal() {

	}

	public Visit[] viewPastVisits() {
		
	}
	
	//Setters
	public void setFirstName(String name) {
		firstName = name;
	}
	public void setLastName(String name) {
		lastName = name;
	}
	public void setBirth(int birth) {
		birthdate = birth;
	}
	public String getUser() { return username; }
	public String getPass() { return password; }
	public String getRole() { return role; }
	
	//Getters
	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public String getUser() { return username; }
	public String getPass() { return password; }
	public String getRole() { return role; }
	public int getBirth() { return birthdate; }
}
