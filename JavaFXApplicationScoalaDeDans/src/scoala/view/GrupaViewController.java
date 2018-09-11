/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author iucosoft9
 */
public class GrupaViewController implements Initializable {

    @FXML
    TextField tfId;

    @FXML
    TextField tfDenumire;

    public void handldeFindButton() {
        System.out.println("Ai apasat Find buton din GRUPA");
    }

    public void handldeSaveButton() {
        System.out.println("Ai apasat Save buton din GRUPA");
    }

    public void handldeUpDateButton() {
        System.out.println("Ai apasat UpDate buton din GRUPA");
    }

    public void handldeDeleteButton() {
        System.out.println("Ai apasat Delete buton din GRUPA");
    }

    public void handldeClearButton() {
        System.out.println("Ai apasat Clear buton din GRUPA");
        tfId.setText("");
        tfDenumire.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
