/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asistensi;

import java.net.URL;
import javafx.scene.layout.Pane;

/**
 *
 * @author 62859
 */
public class OpenScene {
    private Pane halaman;
    
    public Pane getPane(String namaFile){
        try {
            URL fileHalaman = Asistensi.class.getResource("/asistensi/"+namaFile+".fxml");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
                    return halaman;

    }
}
