/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package asistensi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author devano
 */
public class InputViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    //textfield --start
    @FXML
    TextField tfJudul;
    @FXML
    TextField tfPengarang;
    @FXML
    TextField tfJumlahHalaman;
    @FXML
    TextField tfPenerbit;
    
    //textfiel --end
    
    //button --start
    @FXML
    Button btnTambahBuku;
    //button --end
    
    @FXML
    void handleButtonTambah(ActionEvent e){
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
