package application;

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

public class Controller{
	
	@FXML // fx:id="roleCombo"
	private ComboBox<String> roleCombo;
	
	@FXML // fx:id="tfUserName"
	private TextField tfUserName;
	
	@FXML // fx:id="tfPassword
	private TextField tfPassword;
	
    @FXML
    private void switchToCreateAccount(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../CreateAccount.fxml"));
        thisStage.getScene().setRoot(loader);
    }
    
    @FXML
    private void switchToUserHomePage(ActionEvent event) throws IOException {
    	event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        String username = tfUserName.getText();
        String password = tfPassword.getText();
        if(username.equals("") || password.equals("")) {
        	Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Required Fields Empty");

            alert.showAndWait();
        }
        else if(roleCombo.getValue() == "Nurse") {
        	// Checks if the Nurse Exists in the list of nurses
        	// Loads the Nurse's Page
        	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../NurseHomePage.fxml")));
        }
        else if(roleCombo.getValue() == "Doctor") {
        	// Loads the Nurse's Page
        	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../DoctorHomePage.fxml")));
        } 
        else if(roleCombo.getValue() == "Patient") {
        	// Loads the Nurse's Page
        	thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../PatientHomePage.fxml")));
        } 
    }
    
    
    @FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	roleCombo.getItems().addAll("Doctor", "Nurse", "Patient");
    	roleCombo.setVisibleRowCount(3);
    }

}
