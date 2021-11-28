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
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MessageCenterController {

	
	@FXML // fx:id="cbDocOrNurse"
	private ComboBox<String> cbDocOrNurse;
	
	@FXML // fx:id="textMessage"
	private TextField textMessage;
	
	@FXML // fx:id="lvMessageBoard"
	private ListView<String> lvMessageBoard;
	
	@FXML // fx:id="buttonSend"
	private Button buttonSend;
	
	@FXML // fx:id="buttonHome"
	private Button buttonHome;
	
	@FXML // fx:id="buttonUpdate"
	private Button buttonUpdate;
	
    @FXML
    //code for the combo box to select either doctor or nurse
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	cbDocOrNurse.getItems().addAll("Doctor", "Nurse");
    	cbDocOrNurse.setVisibleRowCount(2);
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
        if(toPerson == "Doctor" && !msg.equals("")) {
        	// Sends Msg to Doctor
        	a.docMessage(msg, "Patient");
        	textMessage.setText("");
        	
        }else if(toPerson == "Nurse" && !msg.equals("")){
        	// Sends Msg to Nurse
        	a.nurseMessage(msg, "Patient");
        	textMessage.setText("");
        }else {
        	System.out.println("Wasn't able to send message to a Nurse or Doctor"); // Should Not Get Here
        }
        
        // Update the Message Board with the New Msg
        if(toPerson != null) {
        	ArrayList<String> msgs = new ArrayList<>();
            if(toPerson.equals("Doctor")) {
            	msgs = a.docMsg;
            } 
            else if(toPerson.equals("Nurse")){
            	msgs = a.nurseMsg;
            }
            // Clears the Board
            lvMessageBoard.getItems().clear();
            
            // Gets all the messages
            for(int i = 0; i < msgs.size(); i++) {
            	lvMessageBoard.getItems().add(msgs.get(i));
            }
        }else {
        	System.out.println("Please Select Doctor or Nurse");
        }
        
	}
	
	@FXML
	//code for the send message button
    private void backBtn(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        //thisStage.hide();
        Parent loader = FXMLLoader.load(getClass().getResource("../PatientHomePage.fxml"));
        thisStage.getScene().setRoot(loader);
        
	}
	
	
	@FXML
	//code for the send message button
    private void updateBtn(ActionEvent event) throws IOException {
        
        String toPerson = cbDocOrNurse.getValue();
        Patient a = Storage.searchPatient(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
        
        // Update the Message Board with the New Msg
        if(toPerson != null) {
        	ArrayList<String> msgs = new ArrayList<>();
            if(toPerson.equals("Doctor")) {
            	msgs = a.docMsg;
            } 
            else if(toPerson.equals("Nurse")){
            	msgs = a.nurseMsg;
            }
            
            // Clears the Board
            lvMessageBoard.getItems().clear();
            
            // Gets all the messages
            for(int i = 0; i < msgs.size(); i++) {
            	lvMessageBoard.getItems().add(msgs.get(i));
            }
        }else {
        	System.out.println("Please Select Doctor or Nurse");
        }
        
	}
}
