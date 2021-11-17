package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class PatientPageController {
	
	// Change Pages in Patient Profiles
	@FXML
    private void switchToPatientProfile(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../PatientProfile.fxml"));
        thisStage.getScene().setRoot(loader);
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
