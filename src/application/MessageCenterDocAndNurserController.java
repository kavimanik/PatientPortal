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
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
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
	
	@FXML // fx:id="buttonBack"
	private Button buttonBack;
	
	@FXML // fx:id="buttonUpdate"
	private Button buttonUpdate;
	
	@FXML
    private void sendMsgButton(ActionEvent event) throws IOException {
        event.consume();
        
        // Pulls the information from the JavaFx Page
        String msg = textMessage.getText();
        if(cbPatient.getValue() != null) {
            String[] patient = cbPatient.getValue().split("\\s+");
            Patient a = Storage.searchPatient(patient[0], patient[1]);
         if(!msg.equals("")) {
        	// Determines the receiver of the msg
             switch(Storage.getCurrentUser().getRole()) {
             case "Doctor":
             	a.docMessage(msg, "Doctor");
             	textMessage.setText("");

             	break;
             case "Nurse":
             	a.nurseMessage(msg, "Nurse");
             	textMessage.setText("");
             	break;
             default: System.out.println("Wasn't able to send message to a Nurse or Doctor"); break; // Should Not Get Here
             }
             
             // Update the Message Board with the New Msg
             if(a != null) {
             	ArrayList<String> msgs = new ArrayList<>();
                 if(Storage.getCurrentUser().getRole().equals("Doctor")) {
                 	msgs = a.docMsg;
                 } 
                 else if(Storage.getCurrentUser().getRole().equals("Nurse")){
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
         }else {
         	System.out.println("No Patient Selected");
         }
         }else {
        	 System.out.println("No Msg was found");
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
    
    @FXML
	//code for the send message button
    private void backBtn(ActionEvent event) throws IOException {
        event.consume();
        Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        
        User a = Storage.getCurrentUser();
        //thisStage.hide();
        if(a.getRole().equals("Doctor")) { thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../DoctorHomePage.fxml")));
        }else { thisStage.getScene().setRoot(FXMLLoader.load(getClass().getResource("../NurseHomePage.fxml"))); }        
	}
    
    @FXML
	//code for the send message button
    private void updateBtn(ActionEvent event) throws IOException {
        
    	if(cbPatient.getValue() != null) {
            // Pulls the information from the JavaFx Page
            String[] patient = cbPatient.getValue().split("\\s+");
            Patient a = Storage.searchPatient(patient[0], patient[1]);
        	
            // Update the Message Board with the New Msg
            if(a != null) {
            	ArrayList<String> msgs = new ArrayList<>();
                if(Storage.getCurrentUser().getRole().equals("Doctor")) {
                	msgs = a.docMsg;
                } 
                else if(Storage.getCurrentUser().getRole().equals("Nurse")){
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
    	}else {
        	System.out.println("No Patient Selected");
    	}
        
	}
}
