package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import JavaCode.*;

public class SearchPatientController {
	
	@FXML // fx:id="lvSearches"
	private ListView lvSearches;
	
	@FXML // fx:id="tfLastName"
	private TextField tfLastName;
	
	@FXML // fx:id="tfFirstName"
	private TextField tfFirstName;
	
	@FXML
	private void populateListView(ActionEvent event) throws IOException {
		event.consume();
		lvSearches.getItems().clear();
		String firstName = tfFirstName.getText();
		String lastName = tfLastName.getText();
	    
	    
	}
}
