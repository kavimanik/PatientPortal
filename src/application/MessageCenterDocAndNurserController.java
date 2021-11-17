package application;

import java.io.IOException;

import JavaCode.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MessageCenterDocAndNurserController {
	
	@FXML // fx:id="cbPatient"
	private ComboBox<String> cbPatient;
	
	@FXML // fx:id="textMessage"
	private TextField textMessage;
	
	@FXML // fx:id="tfMessageBoard"
	private TextField tfMessageBoard;
	
	@FXML // fx:id="buttonSend"
	private Button buttonSend;
	
	@FXML
    private void sendMsgButton(ActionEvent event) throws IOException {
        event.consume();
        String msg = textMessage.getText();
        String[] patient = cbPatient.getValue().split("\\s+");
        
        Patient a = Storage.searchPatient(patient[0], patient[1]);
        
        switch(Storage.getCurrentUser().getRole()) {
        case "Doctor":
        	a.docMessage("Doctor", msg);
        	break;
        case "Nurse":
        	a.nurseMessage("Nurse", msg);
        	break;
        default: System.out.println("Wasn't able to send message to a Nurse or Doctor"); break; // Should Not Get Here
        }
        
        // Update the Message Board with the New Msg
	}
}
