/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.mockservicii;

import com.iucosoft.minisite.dao.DepartamentDaoIntf;
import com.iucosoft.minisite.entitati.Departament;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iucosoftmain
 */
public class DepartamentMockDaoImpl implements DepartamentDaoIntf{

    Map<Integer, Departament> tabela;
    
    private static int iddb;

    public static DepartamentDaoIntf instance;

    public static DepartamentDaoIntf getInstance() {
        
        if(instance == null){
            instance = new DepartamentMockDaoImpl();
        }
        
        return instance;
    }
    
    
    
    
    
    
    private DepartamentMockDaoImpl() {
        
        tabela = new LinkedHashMap<>();
        
        init();
    }

    private void init(){
        try {
            save(new Departament("UNU DEP", "UNU BUN"));
            save(new Departament("DOI DEP", "DOI DESCR"));
        } catch (SQLException ex) {
            Logger.getLogger(DepartamentMockDaoImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
    
    public DepartamentMockDaoImpl(Map<Integer, Departament> tabela) {
        this.tabela = tabela;
    }
    
    
    @Override
    public void save(Departament dep) throws SQLException {
        int id=++iddb;
        dep.setId(id);
        tabela.put(id, dep);
    }
    @Override
    public void update(Departament dep) throws SQLException {
        tabela.put( dep.getId(), dep);
    }
    @Override
    public void delete(Departament dep) throws SQLException {
        if(!tabela.containsKey(dep.getId())){
           throw new SQLException("Nu este dep cu id="+dep.getId());
        }
        tabela.remove(dep.getId());
    }
    @Override
    public Departament findById(int id) throws SQLException {
         if(tabela.containsKey(id)){
             return tabela.get(id);
        }else{
               throw new SQLException("Nu este dep cu id="+id);
         }
    }
    @Override
    public List<Departament> findAll() throws SQLException {
         return new ArrayList<Departament>(tabela.values());
    }
}//end clasas
