package com.iucosoft.entitati;

import java.util.Objects;

/**
 *
 * @author iucosoft7
 */
public class Departament {

    int id;
    String denumire;
    String descrere;

    public Departament() {
        this.denumire = "";
        this.descrere = "";
    }

    public Departament(int id, String denumire, String descrere) {
        this.id = id;
        this.denumire = denumire;
        this.descrere = descrere;
    }

    public Departament(int id) {
        this.id = id;
    }

    public Departament(String denumire, String descrere) {
        this.denumire = denumire;
        this.descrere = descrere;
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getDescrere() {
        return descrere;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setDescrere(String descrere) {
        this.descrere = descrere;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.denumire);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departament other = (Departament) obj;
        if (!Objects.equals(this.denumire, other.denumire)) {
            return false;
        }
        return true;
    }

}
