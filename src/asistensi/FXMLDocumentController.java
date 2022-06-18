/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package asistensi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;

/**
 *
 * @author 62859
 */
public class FXMLDocumentController implements Initializable {
    
    OpenScene openScene =new OpenScene();
    
    
    @FXML
    private Label label;
    
    @FXML
    private BorderPane borderPane;
    @FXML
    private Button btnToInputView;
    @FXML
    private Button btnToTableView;
   
    
    @FXML
    private void handleButtonToInputView(ActionEvent event) {
        System.out.println("btnInputView clicked");
        
        Pane pane = openScene.getPane("InputView");
        borderPane.setCenter(pane);
    }
    @FXML
    private void handleButtonToTableView(ActionEvent event){
        System.out.println("btnTableView clicked");
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
