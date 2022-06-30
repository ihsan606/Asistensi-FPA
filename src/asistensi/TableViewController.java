/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package asistensi;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Buku;

/**
 * FXML Controller class
 *
 * @author 62859
 */
public class TableViewController implements Initializable {

    ObservableList<Buku> observableListBuku = observableArrayList();
    List<Buku> listBuku = new ArrayList<Buku>();

    void OpenData() {
        XStream xStream = new XStream(new StaxDriver());
        FileInputStream berkasMasuk;

        try {
            berkasMasuk = new FileInputStream("dataBuku.xml");
            int isi;
            char c;
            String s = "";
            while ((isi = berkasMasuk.read()) != -1) {

                c = (char) isi;
                s = s + c;

            }

            listBuku = (List<Buku>) xStream.fromXML(s);
            berkasMasuk.close();
        } catch (Exception e) {
            System.out.println("terjadi kkesallahn");
        }
    }

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Buku> table;

    @FXML
    private TableColumn<Buku, String> colJudul;

    @FXML
    private TableColumn<Buku, String> colPengarang;

    @FXML
    private TableColumn<Buku, Integer> colHalaman;

    @FXML
    private TableColumn<Buku, String> colPenerbit;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        colJudul.setCellValueFactory(new PropertyValueFactory<>("judul"));
        colPengarang.setCellValueFactory(new PropertyValueFactory<>("pengarang"));
        colHalaman.setCellValueFactory(new PropertyValueFactory<>("jumlahHalaman"));
        colPenerbit.setCellValueFactory(new PropertyValueFactory<>("penerbit"));

        File f = new File("databuku.xml");
        if (f.exists() && !f.isDirectory()) {
            OpenData();
            for (int i = 0; i < listBuku.size(); i++) {
                observableListBuku.add(listBuku.get(i));
            }

        }

        table.setItems(observableListBuku);

    }

}
