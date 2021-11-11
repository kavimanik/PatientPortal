package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CreateAccountController {
	
	@FXML // fx:id="roleCombo2"
	private ComboBox<String> roleCombo2;
	
	@FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	//ObservableList<String> roles = FXCollections.observableArrayList("Doctor", "Nurse", "Patient");
    	//this.roleCombo = new ComboBox<>(roles);
    	roleCombo2.getItems().addAll("Doctor", "Nurse", "Patient");
    	roleCombo2.setVisibleRowCount(3);
    }
	
	@FXML
    private void switchToLogin(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../login.fxml"));
        thisStage.getScene().setRoot(loader);
    }
}
