package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
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
}
