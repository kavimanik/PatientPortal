package application;

import java.io.IOException;

import JavaCode.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PatientPageController {
	
	// Change Pages in Patient Profiles
	@FXML
    private void switchToPatientProfile(ActionEvent event) throws IOException {
        event.consume();
        
        User user = Storage.getCurrentUser();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        Patient patient = Storage.searchPatient(firstName, lastName);
        
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        AnchorPane loader = FXMLLoader.load(getClass().getResource("../PatientProfile.fxml"));
        thisStage.getScene().setRoot(loader);
        
        
        ObservableList<Node> list = loader.getChildren();
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i).getId() != null && list.get(i).getId().equals("ftName")) {
        		TextField ftName = (TextField) list.get(i);
        		ftName.setText(firstName + " " + lastName);
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfBirthday")) {
        		TextField tfBirthday = (TextField) list.get(i);
        		tfBirthday.setText(patient.getBirth());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("ftPhoneNumber")) {
        		TextField ftPhoneNumber = (TextField) list.get(i);
        		ftPhoneNumber.setText(patient.getPhoneNumber());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("ftEmail")) {
        		TextField ftEmail = (TextField) list.get(i);
        		ftEmail.setText(patient.getEmail());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("ftInsurance")) {
        		TextField ftInsurance = (TextField) list.get(i);
        		ftInsurance.setText(patient.getInsurance());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("ftPharmacy")) {
        		TextField ftPharmacy = (TextField) list.get(i);
        		ftPharmacy.setText(patient.getPharmacy());
        	}
        	
        }
    }
	
	@FXML
    private void switchToMessagePortal(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../MessageCenter.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML
    private void switchToPatientMedicalInfo(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../PatientMedicalInfo.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	// Submit new information
	
}
