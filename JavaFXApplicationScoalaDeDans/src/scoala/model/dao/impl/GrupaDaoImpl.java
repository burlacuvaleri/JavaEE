/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import scoala.model.MyDataSource;
import scoala.model.dao.GrupaDaoIntf;
import scoala.model.entitati.Grupa;

/**
 *
 * @author iucosoft9
 */
public class GrupaDaoImpl implements GrupaDaoIntf {

    private static final Logger LOG = Logger.getLogger(GrupaDaoImpl.class.getName());

    private MyDataSource mds;

    {
        try {
            mds = MyDataSource.getInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GrupaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(GrupaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Grupa g) throws SQLException {
        String sql = "INSERT INTO grupa VALUES (null,?)";

        Connection conn = mds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // transmitem parametri - argumentele
        pstmt.setInt(0, g.getIdGrupa());
        pstmt.setString(1, g.getNumeGrupa());

        int nr = pstmt.executeUpdate();

        if (nr > 0) {
            LOG.info("GrupaDaoImpl: save !");
        }

    }

    @Override
    public void update(Grupa g) throws SQLException {

        String sql = "UPDATE grupa SET idGrupa=?, idDenumire=? WHERE id=?";
        Connection conn = null;
        Savepoint sp = null;

    }

    @Override
    public void delete(Grupa g) throws SQLException {

    }

    @Override
    public Grupa findById(int id) throws SQLException {

        return null;
    }

    @Override
    public List<Grupa> findAll() throws SQLException {
        return null;
    }

}
