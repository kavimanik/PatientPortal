package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

import JavaCode.*;

public class SearchPatientController {
	
	@FXML // fx:id="lvSearches"
	private ListView lvSearches;
	
	@FXML // fx:id="tfLastName"
	private TextField tfLastName;
	
	@FXML // fx:id="tfFirstName"
	private TextField tfFirstName;
	
	@FXML
	private void populateListView(ActionEvent event) throws IOException {
		event.consume();
		lvSearches.getItems().clear();
		String firstName = tfFirstName.getText();
		String lastName = tfLastName.getText();
		ArrayList<User> list = Storage.search("Patient", firstName, lastName);
		for(int i = 0; i < list.size(); i++) {
			lvSearches.getItems().add(list.get(i).getFirstName() + " " + list.get(i).getLastName() + " " + list.get(i).getBirth());
		}
	}
	
	@FXML
	private void handleMouseClick(MouseEvent event) throws IOException {
		event.consume();
		String patientName = lvSearches.getSelectionModel().getSelectedItem().toString();
		
		int count = 0;
		for(int j = 0; j < patientName.length(); j++) {
			if(Character.isDigit(patientName.charAt(j))) {
				count = j;
				break;
			}
		}
		String fullName = patientName.substring(0,count-1);
		
		count = 0;
		for(int i = 0; i < fullName.length(); i++) {
			if(fullName.charAt(i) == ' '){
				count = i;
				break;
			}
		}
		
		String firstName = fullName.substring(0,count);
		String lastName = fullName.substring(count+1,fullName.length());
		
		Patient patient = Storage.searchPatient(firstName, lastName);
		
		Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        AnchorPane loader = FXMLLoader.load(getClass().getResource("../PatientMedicalInfo.fxml"));
        thisStage.getScene().setRoot(loader);
        ObservableList<Node> list = loader.getChildren();
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i).getId() != null && list.get(i).getId().equals("tfPatientName")) {
        		TextField tfPatientName = (TextField) list.get(i);
        		tfPatientName.setText(fullName);
        	} 
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfWeight")) {
        		TextField tfPatientWeight = (TextField) list.get(i);
        		tfPatientWeight.setText(patient.getWeight());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfHeight")) {
        		TextField tfPatientHeight = (TextField) list.get(i);
        		tfPatientHeight.setText(patient.getHeight());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfBodyTemperature")) {
        		TextField tfBodyTemperature = (TextField) list.get(i);
        		tfBodyTemperature.setText(patient.getTemp());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfBloodPressure")) {
        		TextField tfBloodPressure = (TextField) list.get(i);
        		tfBloodPressure.setText(patient.getBloodPres());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfKnownAllergies")) {
        		TextField tfAllergies = (TextField) list.get(i);
        		tfAllergies.setText(patient.getAllergies());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfKnownAllergies")) {
        		TextField tfAllergies = (TextField) list.get(i);
        		tfAllergies.setText(patient.getAllergies());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfHealthConcerns")) {
        		TextField tfHealthConcerns = (TextField) list.get(i);
        		tfHealthConcerns.setText(patient.getHealthConcerns());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfPhysicalTest")) {
        		TextField tfPhysicalTest = (TextField) list.get(i);
        		tfPhysicalTest.setText(patient.getPhysicalTestResults());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfAssignedDoctor")) {
        		TextField tfAssignedDoctor = (TextField) list.get(i);
        		tfAssignedDoctor.setText(patient.getDoctor().getFirstName() + " " + patient.getDoctor().getLastName());
        	}
        	else if(list.get(i).getId() != null && list.get(i).getId().equals("tfAssignedNurse")) {
        		TextField tfAssignedNurse = (TextField) list.get(i);
        		tfAssignedNurse.setText(patient.getNurse().getFirstName() + " " + patient.getNurse().getLastName());
        	}
        	
        }
	}
}
