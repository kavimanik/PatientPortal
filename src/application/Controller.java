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
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {
	
	@FXML // fx:id="roleCombo"
	private ComboBox<String> roleCombo;
	
    @FXML
    private void switchToCreateAccount(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../CreateAccount.fxml"));
        thisStage.getScene().setRoot(loader);
    }
    
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	ObservableList<String> roles = FXCollections.observableArrayList("Doctor", "Nurse", "Patient");
    	this.roleCombo = new ComboBox<>(roles);
    	roleCombo.setVisibleRowCount(3);
    }

}
