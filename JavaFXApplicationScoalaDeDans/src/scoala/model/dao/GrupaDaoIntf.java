/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.model.dao;

import java.sql.SQLException;
import java.util.List;
import scoala.model.entitati.Grupa;

/**
 *
 * @author iucosoft9
 */
public interface GrupaDaoIntf {
    
    //CRUD
    void create(Grupa g) throws SQLException;
    void update(Grupa g) throws SQLException;
    void delete(Grupa g) throws SQLException;
    
    Grupa findById(int id) throws SQLException;
    List<Grupa> findAll() throws SQLException;
}
