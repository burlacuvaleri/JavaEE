/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.model.entitati;

import java.util.logging.Logger;

/**
 *
 * @author iucosoft9
 */
public class Grupa {

    private static final Logger LOG = Logger.getLogger(Grupa.class.getName());
    private int idGrupa;
    private String numeGrupa;

    public Grupa() {
    }

    public Grupa(int idGrupa, String numeGrupa) {
        this.idGrupa = idGrupa;
        this.numeGrupa = numeGrupa;
    }

    public String getNumeGrupa() {
        return numeGrupa;
    }

    public void setNumeGrupa(String numeGrupa) {
        this.numeGrupa = numeGrupa;
    }

    public int getIdGrupa() {
        return idGrupa;
    }

    public void setIdGrupa(int idGrupa) {
        this.idGrupa = idGrupa;
    }

    @Override
    public String toString() {
        return "Grupa{" + "idGrupa=" + idGrupa + ", numeGrupa=" + numeGrupa + '}';
    }

    
    
}
