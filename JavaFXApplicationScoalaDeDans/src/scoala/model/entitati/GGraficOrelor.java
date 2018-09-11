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
public class GGraficOrelor {
    
    private static final Logger LOG = Logger.getLogger(GGraficOrelor.class.getName());

    public static Logger getLOG() {
        return LOG;
    }
    private int idGGraficOrelor;
    private int idGrupa;
    private int data;

    public GGraficOrelor() {
    }

    public GGraficOrelor(int idGGraficOrelor, int idGrupa, int data) {
        this.idGGraficOrelor = idGGraficOrelor;
        this.idGrupa = idGrupa;
        this.data = data;
    }

    public int getIdGGraficOrelor() {
        return idGGraficOrelor;
    }

    public int getIdGrupa() {
        return idGrupa;
    }

    public int getData() {
        return data;
    }

    public void setIdGGraficOrelor(int idGGraficOrelor) {
        this.idGGraficOrelor = idGGraficOrelor;
    }

    public void setIdGrupa(int idGrupa) {
        this.idGrupa = idGrupa;
    }

    public void setData(int data) {
        this.data = data;
    }
   
    
    
    
}
