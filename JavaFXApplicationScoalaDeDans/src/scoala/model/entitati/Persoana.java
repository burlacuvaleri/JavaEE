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
public class Persoana {

    private static final Logger LOG = Logger.getLogger(Persoana.class.getName());
    private int idPersoana;
    private int idGrupa;
    private String nume;
    private String prenume;
    private String ddllaaaa;
    private String nrTelefon;    

    public Persoana() {
    }

    public Persoana(int idPersoana, int idGrupa, String nume, String prenume, String ddllaaaa, String nrTelefon) {
        this.idPersoana = idPersoana;
        this.idGrupa = idGrupa;
        this.nume = nume;
        this.prenume = prenume;
        this.ddllaaaa = ddllaaaa;
        this.nrTelefon = nrTelefon;
    }

    public int getIdPersoana() {
        return idPersoana;
    }

    public int getIdGrupa() {
        return idGrupa;
    }

    public String getNume() {
        return nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public String getDdllaaaa() {
        return ddllaaaa;
    }

    public String getNrTelefon() {
        return nrTelefon;
    }

    public void setIdPersoana(int idPersoana) {
        this.idPersoana = idPersoana;
    }

    public void setIdGrupa(int idGrupa) {
        this.idGrupa = idGrupa;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public void setDdllaaaa(String ddllaaaa) {
        this.ddllaaaa = ddllaaaa;
    }

    public void setNrTelefon(String nrTelefon) {
        this.nrTelefon = nrTelefon;
    }

    @Override
    public String toString() {
        return "Persoana{" + "idPersoana=" + idPersoana + ", idGrupa=" + idGrupa + ", nume=" + nume + ", prenume=" + prenume + ", ddllaaaa=" + ddllaaaa + ", nrTelefon=" + nrTelefon + '}';
    }

}
