package application;

import JavaCode.*;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class DoctorPageController {
	
	@FXML // fx:id="cbPatients"
	private ComboBox<String> cbPatients;
	
	@FXML
    private void switchToSearchPatient(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../SearchPatient.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML
    private void switchToMessageCenter(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../MessageCenterDocAndNurse.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
	@FXML
    private void switchToPrescribeMedication(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../PrescribeMedication.fxml"));
        thisStage.getScene().setRoot(loader);
    }
	
    @FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	cbPatients.getItems().addAll("Doctor", "Nurse", "Patient");
    	cbPatients.setVisibleRowCount(3);
    }
}
