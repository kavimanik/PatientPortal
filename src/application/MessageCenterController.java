package application;

import java.io.IOException;
import java.util.ArrayList;

import JavaCode.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MessageCenterController {

	
	@FXML // fx:id="cbDocOrNurse"
	private ComboBox<String> cbDocOrNurse;
	
	@FXML // fx:id="textMessage"
	private TextField textMessage;
	
	@FXML // fx:id="tfMessageBoard"
	private ListView<String> lvMessageBoard;
	
	@FXML // fx:id="buttonSend"
	private Button buttonSend;
	
    @FXML
    //code for the combo box to select either doctor or nurse
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	cbDocOrNurse.getItems().addAll("Doctor", "Nurse");
    	cbDocOrNurse.setVisibleRowCount(2);
    	
    	Patient a = Storage.searchPatient(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
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
	//code for the send message button
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
        	textMessage.setText("");

        	
        }else if(toPerson == "Nurse"){
        	// Sends Msg to Nurse
        	a.nurseMessage("Nurse", msg);
        	textMessage.setText("");

        }else {
        	System.out.println("Wasn't able to send message to a Nurse or Doctor"); // Should Not Get Here
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
        
}
