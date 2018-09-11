/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.model.dao;

import java.sql.SQLException;
import java.util.List;
import scoala.model.entitati.Persoana;

/**
 *
 * @author iucosoft9
 */
public interface PersoanaDaoIntf {
    //CRUD
    void create(Persoana p)throws SQLException;    
    void update(Persoana p)throws SQLException;
    void delete(Persoana p)throws SQLException;
    
    Persoana findById(int id) throws SQLException;
    List<Persoana> findAll() throws SQLException;
}
