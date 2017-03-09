/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m1.piu;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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
    
    
        public void showCenterPanel() {
        try {
            // Load pages overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("FXMLContactsList.fxml"));
            AnchorPane centerPanel = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(centerPanel);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void start(Stage stage) throws Exception {

        this.primaryStage = stage;
        this.primaryStage.setTitle("Contact Manager");
        this.primaryStage.setResizable(false);

        initRootLayout();
        
        showLeftPanel();
        
        showCenterPanel();
        

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
