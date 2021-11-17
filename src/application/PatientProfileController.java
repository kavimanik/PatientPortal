package application;

import java.io.IOException;

import JavaCode.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PatientProfileController {
	
	@FXML // fx:id="ftName"
	private TextField ftName;
	
	@FXML // fx:id="tfBirthday"
	private TextField tfBirthday;

	@FXML // fx:id="ftPhoneNumber"
	private TextField ftPhoneNumber;

	@FXML // fx:id="ftEmail"
	private TextField ftEmail;
	
	@FXML // fx:id="ftInsurance"
	private TextField ftInsurance;
	
	@FXML // fx:id="ftPharmacy"
	private TextField ftPharmacy;
	
	@FXML
    private void switchToPatientHomePage(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        
        // Takes in the Patient's Info and Sets it to their profile
        String[] name = ftName.getText().split("\\s+");
        String bday = tfBirthday.getText();
        String num = ftPhoneNumber.getText();
        String email = ftEmail.getText();
        String insure = ftInsurance.getText();
        String phar = ftPharmacy.getText();
        
        // Sets the information in the patient
        Patient a = Storage.searchPatient(name[0], name[1]);
        a.setBirth(bday);
        a.setPhoneNumber(num);
        a.setEmail(email);
        a.setInsurance(insure);
        a.setPharmacy(phar);
        
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../PatientHomePage.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
    @FXML
    public void setText(MouseEvent event) {
    	event.consume();
    	//Patient a = Storage.searchPatient(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
    	//ftName.setText(a.getFirstName()+ " " + a.getLastName());
    	//tfBirthday.setText(a.getBirth());
    	//ftPhoneNumber.setText(a.getPhoneNumber());
    	//ftEmail.setText(a.getEmail());
    	//ftInsurance.setText(a.getInsurance());
    	//ftPharmacy.setText(a.getPharmacy());
    }
}
