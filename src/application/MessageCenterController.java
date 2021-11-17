package application;

import java.io.IOException;

import JavaCode.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MessageCenterController {

	
	@FXML // fx:id="cbDocOrNurse"
	private ComboBox<String> cbDocOrNurse;
	
	@FXML // fx:id="textMessage"
	private TextField textMessage;
	
	@FXML // fx:id="tfMessageBoard"
	private TextField tfMessageBoard;
	
	@FXML // fx:id="buttonSend"
	private Button buttonSend;
	
	@FXML
    private void sendMsgButton(ActionEvent event) throws IOException {
        event.consume();
        
        // Pulls the information from the JavaFx Page
        String msg = textMessage.getText();
        String toPerson = cbDocOrNurse.getValue();
        Patient a = Storage.searchPatient(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
        
        // Determines the receiver of the msg
        if(toPerson == "Doctor") {
        	// Sends Msg to Doctor
        	a.docMessage("Doctor", msg);
        	
        }else if(toPerson == "Nurse"){
        	// Sends Msg to Nurse
        	a.nurseMessage("Nurse", msg);
        }else {
        	System.out.println("Wasn't able to send message to a Nurse or Doctor"); // Should Not Get Here
        }
        
        // Update the Message Board with the New Msg
        
	}
        
        
        //Node node = (Node) event.getSource();
        //Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        //Parent loader = FXMLLoader.load(getClass().getResource("../SearchPatient.fxml"));
        //thisStage.getScene().setRoot(loader);
}
