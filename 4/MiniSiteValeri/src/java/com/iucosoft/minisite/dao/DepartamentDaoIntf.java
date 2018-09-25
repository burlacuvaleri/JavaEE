
package com.iucosoft.minisite.dao;

import com.iucosoft.minisite.entitati.Departament;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author iucosoftmain
 */
public interface DepartamentDaoIntf {
    //CRUD
    
    void save(Departament dep) throws SQLException;
    void update(Departament dep) throws SQLException;
    void delete(Departament dep) throws SQLException;
    
    Departament findById(int id)throws SQLException;
    List<Departament> findAll()throws SQLException;
    
    //List<Departament> findAll(Departament dep)throws SQLException;
    
}
