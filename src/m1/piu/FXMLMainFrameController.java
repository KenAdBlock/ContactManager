/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 *
 * @author Kenny
 */
public class FXMLMainFrameController implements Initializable {
    
    @FXML
    private Label label;
    private Label labelAllContacts;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setId("button_hello");
        label.setText("Hello World!");
        // String button_hello_id = label.getId();
        // button_hello_id.setText("Hello World!");
    }
    
        @FXML
    private void handleButtonLabelAllContacts() {
        System.out.println("You clicked on All contacts label");
        labelAllContacts.setStyle("-fx-background-color : #555;");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
