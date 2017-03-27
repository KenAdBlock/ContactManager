/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author Kenny
 */
public class FXMLMainFrameController implements Initializable {
    
    @FXML
    private Label label;
    private Label labelAllContacts;
    
    @FXML
    private AnchorPane identityPane;
    
    @FXML
    private AnchorPane phonePane;
    
    @FXML
    private AnchorPane addressPane;
    
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
    
    
    @FXML
    private void btnAddContactClick() {
       
        Parent root;
        
        try {
            // Creating a new window
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource("FXMLContactFrame.fxml"));
            Stage stage = new Stage();
            stage.setTitle("New contact");
            Scene sceneNewContact = new Scene(root);
            
            stage.setScene(sceneNewContact);

            // Setting the FXML to the different pane
            loadPane(sceneNewContact,"#identityPane","FXMLContactIdentity.fxml");               
            loadPane(sceneNewContact,"#phonePane","FXMLContactPhone.fxml");
            loadPane(sceneNewContact,"#addressPane","FXMLContactAddress.fxml");
                       
            
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    
    
    @FXML
    private void btnAddPhoneClick() {
       
        Parent root;
        
        try {
            // Creating a new window
            FXMLLoader loader = new FXMLLoader();
            root = loader.load(getClass().getResource("FXMLContactPhoneFrame.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Add Phone number");
            Scene sceneNewContact = new Scene(root);
            
            stage.setScene(sceneNewContact);
            
            // Setting the FXML to the different pane
            //loadPane(sceneNewContact,"#identityPane","FXMLContactPhone.fxml");               
           
                       
            
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    
    
    public AnchorPane getPane(String name) {

        AnchorPane pane = null;

        try {
            // Load pages overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(name + ".fxml"));
            pane = (AnchorPane) loader.load();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return pane;
    }
    
    private void loadPane(Scene scene, String paneToSet, String fxmlToLoad) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader();
            AnchorPane anchorPaneToSet = (AnchorPane) scene.lookup(paneToSet);
            loader.setLocation(getClass().getResource(fxmlToLoad));
            AnchorPane ap = (AnchorPane) loader.load();
            anchorPaneToSet.getChildren().setAll(ap);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }
    
}
