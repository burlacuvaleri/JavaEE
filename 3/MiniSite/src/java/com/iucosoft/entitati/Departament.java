package com.iucosoft.entitati;

import java.util.Objects;

/**
 *
 * @author iucosoft7
 */
public class Departament {

    private int id;
    private String denumire;
    private String descriere;

    public Departament() {
        this.denumire = "";
        this.descriere = "";
    }

    public Departament(int id, String denumire, String descriere) {
        this.id = id;
        this.denumire = denumire;
        this.descriere = descriere;
    }

    public Departament(int id) {
        this.id = id;
    }

    public Departament(String denumire, String descriere) {
        this.denumire = denumire;
        this.descriere = descriere;
    }

    public int getId() {
        return id;
    }

    public String getDenumire() {
        return denumire;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
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

    @Override
    public String toString() {
        return "Departament{" + "id=" + id + ", denumire=" + denumire + ", descriere=" + descriere + '}';
    }

}
