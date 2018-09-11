/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.view;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import scoala.model.dao.PersoanaDaoIntf;
import scoala.model.dao.impl.PersoanaDaoImpl;
import scoala.model.entitati.Persoana;

/**
 * FXML Controller class
 *
 * @author iucosoft9
 */
public class PersoanaViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    PersoanaDaoIntf persoanaDao;

    @FXML
    TextField tfNume;
    @FXML
    TextField tfPrenume;
    @FXML
    TextField tfddllaaaa;
    @FXML
    TextField tfNrTelefon;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        persoanaDao = new PersoanaDaoImpl();
    }

    @FXML
    public void handleSaveAction() {
        System.out.println("Ai apasat Save buton din PERSOANA");
        //Perosna p= readForm();// -> perosna
        // dao.save(p);
        //clearForm();
        //refreshTabele();
        Persoana p = readForm();
        try {
            persoanaDao.create(p);
        } catch (SQLException ex) {
            Logger.getLogger(PersoanaViewController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void handReadAction() {
        System.out.println("Ai apasat Read buton din PERSOANA");
    }

    @FXML
    public void handUpDateAction() {
        System.out.println("Ai apasat UpDate buton din PERSOANA");
    }

    @FXML
    public void handDeleteAction() {
        System.out.println("Ai apasat Delete buton din PERSOANA");
    }

    @FXML
    public void handFindAction() {
        System.out.println("Ai apasat Find buton din PERSOANA");

    }

    private Persoana readForm() {

        Persoana p = new Persoana();
        p.setIdGrupa(1);
        p.setNume(tfNume.getText());
        p.setPrenume(tfPrenume.getText());
        p.setDdllaaaa(tfddllaaaa.getText());
        p.setNrTelefon(tfNrTelefon.getText());

        return p;
    }

}
