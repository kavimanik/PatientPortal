package application;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class PrescribeMedicationController {
	
	@FXML // fx:id="roleCombo"
	private ComboBox<String> roleCombo;
	
    @FXML
    public void setRoleItems(MouseEvent event) {
    	event.consume();
    	//ObservableList<String> roles = FXCollections.observableArrayList("Doctor", "Nurse", "Patient");
    	//this.roleCombo = new ComboBox<>(roles);
    	roleCombo.getItems().addAll("Doctor", "Nurse", "Patient");
    	roleCombo.setVisibleRowCount(3);
    }

}
