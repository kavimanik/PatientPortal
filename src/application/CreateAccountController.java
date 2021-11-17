package application;

import java.io.IOException;
import JavaCode.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CreateAccountController {
	
	@FXML // fx:id="roleCombo2"
	private ComboBox<String> roleCombo2;
	
	@FXML // fx:id="tfFirstName"
	private TextField tfFirstName;
	
	@FXML // fx:id="tfLastName"
	private TextField tfLastName;
	
	@FXML // fx:id="tfBirthday"
	private TextField tfBirthday;
	
	@FXML // fx:id="tfUserName2"
	private TextField tfUserName2;
	
	@FXML // fx:id="tfPassword2"
	private TextField tfPassword2;
	
	@FXML // fx:id="tfConfirmPassword"
	private TextField tfConfirmPassword;
	
	@FXML // fx:id="tfErrorText"
	private Label tfErrorText;
	
	
	@FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	//ObservableList<String> roles = FXCollections.observableArrayList("Doctor", "Nurse", "Patient");
    	//this.roleCombo = new ComboBox<>(roles);
    	roleCombo2.getItems().addAll("Doctor", "Nurse", "Patient");
    	roleCombo2.setVisibleRowCount(3);
    }
	
	@FXML
    private void switchToLogin(ActionEvent event) throws IOException {
		String role = roleCombo2.getValue();
		String firstName = tfFirstName.getText();
		String lastName = tfLastName.getText();
		String birthday = tfBirthday.getText();
		String userName = tfUserName2.getText();
		String password = tfPassword2.getText();
		String confirmPassword = tfConfirmPassword.getText();
		
		if(!password.equals(confirmPassword)) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Passwords do not match");
            alert.showAndWait();
            return;
		}
		else if(role.equals("") || firstName.equals("") || lastName.equals("") || 
				birthday.equals("") || userName.equals("") || password.equals("")) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Missing required fields");
            alert.showAndWait();
            return;
		}
		
		if(!Storage.exisit(role, userName, password)) {
			if(role.equals("Doctor")) {
				Doctor doctor = new Doctor(firstName, lastName, userName, password, role, birthday);
				Storage.addDoctor(doctor);
			}
			else if(role.equals("Nurse") && !Storage.exisit("Nurse", userName, password)) {
				Nurse nurse = new Nurse(firstName, lastName, userName, password, role, birthday);
				Storage.addNurse(nurse);
			}
			else if(role.equals("Patient") && !Storage.exisit("Patient", userName, password)) {
				Patient patient = new Patient(firstName, lastName, userName, password, birthday);
				Storage.addPatient(patient);
			}
			System.out.println("User added");
	        event.consume();
	        Node node = (Node) event.getSource();
	        Stage thisStage = (Stage) node.getScene().getWindow();
	        //thisStage.hide();
	        Parent loader = FXMLLoader.load(getClass().getResource("../login.fxml"));
	        thisStage.getScene().setRoot(loader);
		}
		else {
			tfErrorText.setText("Please Pick a differnt combination for a username and password");
		}

    }
}
