/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 *
 * @author Kenny
 */
public class ContactManagerFX extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;

    
    public void initRootLayout() {

        try {

            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLMainFrame.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);

            // Set person overview into the center of root layout.
            //rootLayout.setCenter(leftPanel);
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void showLeftPanel() {
        try {
            // Load pages overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLMainPanel.fxml"));
            AnchorPane leftPanel = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setLeft(leftPanel);

        } catch (IOException e) {
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

    public void showCenterPanel() {

        // create vertical splitpane for contact
        SplitPane contactPanel = new SplitPane();
        contactPanel.setOrientation(Orientation.VERTICAL);
        
        // get contact panes
        AnchorPane contactList = getPane("FXMLContactList");
        AnchorPane contactDetails = getPane("FXMLContactDetails");
        
        // insert contact panes into vertical splitpane
        contactPanel.getItems().addAll(contactList, contactDetails);
        

        // get left main panel
        AnchorPane leftPanel = getPane("FXMLMainPanel");
        
        // create center split pane horizontal
        SplitPane centerPane = new SplitPane();
        
        // insert left panel and contact pane into center pane
        centerPane.getItems().addAll(leftPanel, contactPanel);

        // add final pane into the center of root layout.
        rootLayout.setCenter(centerPane);

    }

    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        this.primaryStage.setTitle("Contact Manager");
        //this.primaryStage.setResizable(false);

        initRootLayout();

        //showLeftPanel();
        showCenterPanel();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
