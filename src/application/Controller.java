package application;

import JavaCode.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;  
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import application.*;

public class Controller{ //This is the controller class for the Login page   
	
	@FXML // fx:id="roleCombo"
	private ComboBox<String> roleCombo;
	
	@FXML // fx:id="tfUserName"
	private TextField tfUserName;
	
	@FXML // fx:id="tfPassword
	private TextField tfPassword;
	
    @FXML
    //if the user clicks the "create account" button
    private void switchToCreateAccount(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../CreateAccount.fxml"));
        thisStage.getScene().setRoot(loader);
    }
    
    @FXML
    //if the user types in the "username" and "password" textfields
    public void switchToUserHomePage(ActionEvent event) throws IOException {
    	event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //getting the text from "username" and "password" textfields
        String username = tfUserName.getText();
        String password = tfPassword.getText();
        
        //if either of the textfields are empty sent an error message
        if(username.equals("") || password.equals("")) {
        	Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");
            alert.showAndWait();
        } 
        //else begin to check if the username and password exists for the role selected
        else if(roleCombo.getValue() == "Nurse") {
        	// Checks if the Nurse Exists in the list of nurses
        	for(int i = 0; i < Storage.getSize("Nurse"); i++) {
        		if(Storage.getNurse(i).getUser().equals(username) && Storage.getNurse(i).getPass().equals(password)) {
                	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../NurseHomePage.fxml")));
                	Storage.setCurrentUser(Storage.getNurse(i));
        		}
        	}
        }
        else if(roleCombo.getValue() == "Doctor") {
        	// Checks if the Doctor Exists in the list of nurses
        	for(int i = 0; i < Storage.getSize("Doctor"); i++) {
        		if(Storage.getDoctor(i).getUser().equals(username) && Storage.getDoctor(i).getPass().equals(password)) {
                	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../DoctorHomePage.fxml")));
                	Storage.setCurrentUser(Storage.getDoctor(i));
        		}
        	}
        } 
        else if(roleCombo.getValue() == "Patient") {
        	// Checks if the Patient Exists in the list of nurses
        	for(int i = 0; i < Storage.getSize("Patient"); i++) {
        		if(Storage.getPatient(i).getUser().equals(username) && Storage.getPatient(i).getPass().equals(password)) {
                	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../PatientHomePage.fxml")));
                	Storage.setCurrentUser(Storage.getPatient(i));
    }}}}
    
    @FXML
    //code for the combo box with the roles 
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	roleCombo.getItems().addAll("Doctor", "Nurse", "Patient");
    	roleCombo.setVisibleRowCount(3);
    }
}
