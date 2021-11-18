package application;

import JavaCode.*;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class DoctorPageController {
	
	@FXML //button for switching to "search patient" page 
    private void switchToSearchPatient(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("../SearchPatient.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML //button for switching to "messaging center" page (for the doctor and nurse's perspective)
    private void switchToMessageCenter(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("../MessageCenterDocAndNurse.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML
	//button for switching to "prescribe medication" page 
    private void switchToPrescribeMedication(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        Parent loader = FXMLLoader.load(getClass().getResource("../PrescribeMedication.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
}
