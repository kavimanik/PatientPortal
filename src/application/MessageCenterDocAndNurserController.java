package application;

import java.io.IOException;
import java.util.ArrayList;

import JavaCode.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MessageCenterDocAndNurserController {
	
	@FXML // fx:id="cbPatient"
	private ComboBox<String> cbPatient;
	
	@FXML // fx:id="textMessage"
	private TextField textMessage;
	
	@FXML // fx:id="lvMessageBoard"
	private ListView<String> lvMessageBoard;
	
	@FXML // fx:id="buttonSend"
	private Button buttonSend;
	
	@FXML
    private void sendMsgButton(ActionEvent event) throws IOException {
        event.consume();
        
        // Pulls the information from the JavaFx Page
        String msg = textMessage.getText();
        String[] patient = cbPatient.getValue().split("\\s+");
        Patient a = Storage.searchPatient(patient[0], patient[1]);
        
        // Determines the receiver of the msg
        switch(Storage.getCurrentUser().getRole()) {
        case "Doctor":
        	a.docMessage("Doctor", msg);
        	textMessage.setText("");
        	break;
        case "Nurse":
        	a.nurseMessage("Nurse", msg);
        	textMessage.setText("");
        	break;
        default: System.out.println("Wasn't able to send message to a Nurse or Doctor"); break; // Should Not Get Here
        }
        
        // Update the Message Board with the New Msg
        ArrayList<String> msgs = new ArrayList<>();
        if(Storage.getCurrentUser().getRole().equals("Doctor")) {
        	msgs = a.docMsg;
        } 
        else if(Storage.getCurrentUser().getRole().equals("Nurse")){
        	msgs = a.nurseMsg;
        }
        
        for(int i = 0; i < msgs.size(); i++) {
        	lvMessageBoard.getItems().add(msgs.get(i));
        }
	}
	
    @FXML
    //code for the combo box with the roles 
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	Nurse a;
    	Doctor b;
    	if(Storage.getCurrentUser().getRole().equals("Doctor")) {
        	b = Storage.searchDoc(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
        	for(int i = 0; i < b.patientList.size(); i++) { 
        		cbPatient.getItems().addAll(b.patientList.get(i).getFirstName() + " " + b.patientList.get(i).getLastName()); 
        	}
        	cbPatient.setVisibleRowCount(b.patientList.size());
    	}else {
        	a = Storage.searchNurse(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
        	for(int i = 0; i < a.patientList.size(); i++) { 
        		cbPatient.getItems().addAll(a.patientList.get(i).getFirstName() + " " + a.patientList.get(i).getLastName()); 
        	}
        	cbPatient.setVisibleRowCount(a.patientList.size());
    	}
    }
}
