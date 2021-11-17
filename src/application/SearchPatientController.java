package application;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

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
		ArrayList<User> list = Storage.search("Patient", firstName, lastName);
		for(int i = 0; i < list.size(); i++) {
			lvSearches.getItems().add(list.get(i).getFirstName() + " " + list.get(i).getLastName() + " " + list.get(i).getBirth());
		}
	}
	
	@FXML
	private void handleMouseClick(MouseEvent event) throws IOException {
		event.consume();
		String patient = lvSearches.getSelectionModel().getSelectedItem().toString();
		Node node = (Node) event.getSource();
        Stage thisStage = (Stage) node.getScene().getWindow();
        AnchorPane loader = FXMLLoader.load(getClass().getResource("../PatientMedicalInfo.fxml"));
        thisStage.getScene().setRoot(loader);
        ObservableList<Node> list = loader.getChildren();
        for(int i = 0; i < list.size(); i++) {
        	if(list.get(i).getId() != null && list.get(i).getId().equals("tfPatientName")) {
        		System.out.println(patient);
        		TextField text = (TextField) list.get(i);
        		text.setText(patient);
        		return;
        	}
        }
	}
}
