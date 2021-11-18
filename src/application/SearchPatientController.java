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
	//code for list view
	//all patients with the same first and last name (as the one that was entered) will be displayed in the list view
	private void populateListView(ActionEvent event) throws IOException {
		event.consume();
		lvSearches.getItems().clear();
		
		//get the information from the text fields
		String firstName = tfFirstName.getText();
		String lastName = tfLastName.getText();
		
		//search for the patient with same name
		ArrayList<User> list = Storage.search("Patient", firstName, lastName);
		
		//display the patients and their birthdays in the list view
		for(int i = 0; i < list.size(); i++) {
			lvSearches.getItems().add(list.get(i).getFirstName() + " " + list.get(i).getLastName() + " " + list.get(i).getBirth());
		}
	}
	
	@FXML
	//code for the selecting one of the patients from the list view
	private void handleMouseClick(MouseEvent event) throws IOException {
		event.consume();
		//the line (patient's first name, last name, and birthday) that was selected from the list view
		String patientName = lvSearches.getSelectionModel().getSelectedItem().toString();
		
		//find the index of the character where the birthday starts 
		int count = 0;
		for(int j = 0; j < patientName.length(); j++) {
			if(Character.isDigit(patientName.charAt(j))) {
				count = j;
				break;
			}
		}
		
		//string with only the patient's name
		String fullName = patientName.substring(0,count-1);
		
		//separating the name into first and last
		count = 0;
		for(int i = 0; i < fullName.length(); i++) {
			if(fullName.charAt(i) == ' '){
				count = i;
				break;
			}
		}
		
		String firstName = fullName.substring(0,count);
		String lastName = fullName.substring(count+1,fullName.length());
		
		//search for the patient 
		Patient patient = Storage.searchPatient(firstName, lastName);
		
		//send the user to the patient's medical information page 
		//the page should be updated with the patient's most recent information 
		Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        AnchorPane loader = FXMLLoader.load(getClass().getResource("../PatientMedicalInfo.fxml"));
        thisStage.getScene().setRoot(loader);
        ObservableList<Node> list = loader.getChildren();
        
        //setting the text fields with the patient's most recent information 
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
