/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.dao;

import com.iucosoft.entitati.Departament;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author iucosoft7
 */
public interface DepartamentDaoIntf {

    // CRUD
    void save(Departament dep) throws SQLException;

    void update(Departament dep) throws SQLException;

    void delete(Departament dep) throws SQLException;

    Departament findById(int id) throws SQLException;

    List<Departament> findAll() throws SQLException;

}
