package application;

import java.io.IOException;

import JavaCode.Storage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

public class NursePageController {
	
	@FXML
	//button for switching to the "search patient" page
    private void switchToSearchPatient(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../SearchPatient.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML
	//button for switching to the "message center" page (for the doctor and nurse perspective)
    private void switchToMessageCenter(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../MessageCenterDocAndNurse.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML
	// Button to log off and to go back to the log in screen
    private void logOff(ActionEvent event) throws IOException {
        Storage.setCurrentUser(null);
		
		event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../login.fxml"));
        thisStage.getScene().setRoot(loader);
    }
}
