package application;

import JavaCode.*;

import java.util.ArrayList;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PrescribeMedicationController {
	
	@FXML // fx:id="cbDosageAmount"
	private ComboBox<String> cbDosageAmount;
	
	@FXML // fx:id="cbPatients"
	private ComboBox<String> cbPatients;
    
    @FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	Doctor a = Storage.searchDoc(Storage.getCurrentUser().getFirstName(), Storage.getCurrentUser().getLastName());
    	ArrayList<Patient> b = a.getAllPatients();
    	for(int i = 0; i < b.size(); i++) { cbPatients.getItems().add(b.get(i).getFirstName() + " " + b.get(i).getLastName()); }
    	cbPatients.setVisibleRowCount(b.size());
    	
    	cbDosageAmount.getItems().addAll("1", "2", "3", "4", "5");
    	cbDosageAmount.setVisibleRowCount(5);
    }

}
