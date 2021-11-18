package application;

import JavaCode.*;

import java.util.ArrayList;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PrescribeMedicationController {
	
	@FXML // fx:id="cbDosageAmount"
	private ComboBox<String> cbDosageAmount;
	
	@FXML // fx:id="cbPatients"
	private ComboBox<String> cbPatients;
	
	@FXML // fx:id="buttonAddPrescription"
	private Button buttonAddPrescription;
	
	@FXML // fx:id="buttonSendToPharmacy"
	private Button buttonSendToPharmacy;
	
	@FXML // fx:id="tfNewMedicationName"
	private TextField tfNewMedicationName;
    
    @FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	//Doctor a = Storage.searchDoc(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
    	//ArrayList<Patient> b = a.getAllPatients();
    	//for(int i = 0; i < b.size(); i++) { cbPatients.getItems().add(b.get(i).getFirstName() + " " + b.get(i).getLastName()); }
    	//cbPatients.setVisibleRowCount(b.size());
    	
    	Nurse a;
    	Doctor b;
    	if(Storage.getCurrentUser().getRole().equals("Doctor")) {
        	b = Storage.searchDoc(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
        	for(int i = 0; i < b.patientList.size(); i++) { 
        		cbPatients.getItems().addAll(b.patientList.get(i).getFirstName() + " " + b.patientList.get(i).getLastName()); 
        	}
        	cbPatients.setVisibleRowCount(b.patientList.size());
    	}else {
        	a = Storage.searchNurse(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
        	for(int i = 0; i < a.patientList.size(); i++) { 
        		cbPatients.getItems().addAll(a.patientList.get(i).getFirstName() + " " + a.patientList.get(i).getLastName()); 
        	}
        	cbPatients.setVisibleRowCount(a.patientList.size());
    	
    	cbDosageAmount.getItems().addAll("1", "2", "3", "4", "5");
    	cbDosageAmount.setVisibleRowCount(5);
    }
}
    
    @FXML
    private void addPresciption(ActionEvent event) throws IOException {
		event.consume();
	    Node node = (Node) event.getSource();
	    Stage thisStage = (Stage) node.getScene().getWindow();
	    
    	// Gets Values for Prescription and Name of Patient from JavaFX
    	String dosage = cbDosageAmount.getValue();
    	String prescipt = tfNewMedicationName.getText();
    	String[] name = cbPatients.getValue().split("\\s+");		// ["John", "Doe"]
    	
    	// Adds it to the Patient's prescribedMeds List
    	Storage.searchPatient(name[0], name[1]).addAPrescription(prescipt, dosage);
	    
    	//Sends the Doctor back to the same PrescribeMeds Page
        Parent loader = FXMLLoader.load(getClass().getResource("../PrescribeMedication.fxml"));
	    thisStage.getScene().setRoot(loader);
    }
    
    @FXML
    private void sendToPharmacy(ActionEvent event) throws IOException {
		
    	//Sends the Doctor back to the main pages after sending the mediation to the Pharmacy
		event.consume();
	    Node node = (Node) event.getSource();
	    Stage thisStage = (Stage) node.getScene().getWindow();
	    //thisStage.hide();
	    Parent loader = FXMLLoader.load(getClass().getResource("../DoctorHomePage.fxml"));
	    thisStage.getScene().setRoot(loader);
    }

}
