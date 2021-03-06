/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package asistensi;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import models.Buku;

/**
 * FXML Controller class
 *
 * @author devano
 */
public class InputViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    XStream xstream = new XStream(new StaxDriver());

    List<Buku> listBuku = new ArrayList<>();

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
    void handleButtonTambah(ActionEvent e) {

        //ini kita cek, udah ada file databuku.xml belum, kalau udah kita ambil data nya
        
        File f = new File("databuku.xml");
        if (f.exists() && !f.isDirectory()) {
            System.out.println("file nya adaaa");
            OpenXml();

        }

        //getting data from textfield
        String dataJudul = tfJudul.getText();
        String dataPengarang = tfPengarang.getText();
        int dataJumlahHalaman = Integer.parseInt(tfJumlahHalaman.getText());
        String dataPenerbit = tfPenerbit.getText();

        tfJudul.setText("");
        tfPengarang.setText("");
        tfJumlahHalaman.setText("");
        tfPenerbit.setText("");

        Buku dataBuku = new Buku(dataJudul, dataPengarang, dataJumlahHalaman, dataPenerbit);
        listBuku.add(dataBuku);

        SaveAndCreate();

    }

    void OpenXml() {
        FileInputStream inputDoc;

        try {
            inputDoc = new FileInputStream("dataBuku.xml");
            int content;
            char c;
            String s = "";
            while ((content = inputDoc.read()) != -1) {
                c = (char) content;
                s += c;
            }

            listBuku = (List<Buku>) xstream.fromXML(s);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void SaveAndCreate() {
        FileOutputStream outputDoc;
        String xml = xstream.toXML(listBuku);
        File f = new File("databuku.xml");
        try {
            byte[] data = xml.getBytes();
            outputDoc = new FileOutputStream("dataBuku.xml");
            outputDoc.write(data);
            outputDoc.close();
            System.out.println("add data success");
        } catch (Exception error) {
            System.err.println("An error occur: " + error.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

}
