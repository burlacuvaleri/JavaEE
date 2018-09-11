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
import scoala.model.dao.PersoanaDaoIntf;
import scoala.model.entitati.Persoana;

/**
 *
 * @author iucosoft9
 */
public class PersoanaDaoImpl implements PersoanaDaoIntf {

    private static final Logger LOG = Logger.getLogger(PersoanaDaoImpl.class.getName());

    private MyDataSource mds;

    {
        try {
            mds = MyDataSource.getInstance();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PersoanaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PersoanaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void create(Persoana p) throws SQLException {
        String sql = "INSERT INTO persoana VALUES (null, ?, ?, ?, ?, ?)";

        Connection conn = mds.getConnection();
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // trasnmitem parametri - argumentele
        pstmt.setInt(0, p.getIdPersoana());
        pstmt.setInt(1, p.getIdGrupa());
        pstmt.setString(2, p.getNume());
        pstmt.setString(3, p.getPrenume());
        pstmt.setString(4, p.getDdllaaaa());
        pstmt.setString(5, p.getNrTelefon());

        int nr = pstmt.executeUpdate();

        if (nr > 0) {
            LOG.info("PersoanaDaoImpl: save !");
        }
    }

    @Override
    public void update(Persoana p) throws SQLException {

        String sql = "UPDATE persoana SET idGrupa=?, nume=?, prenume=?, ddllaaaa=?, nrTelefon=? WHERE id=?";
        Connection conn = null;
        Savepoint sp = null;

    }

    @Override
    public void delete(Persoana p) throws SQLException {

    }

    @Override
    public Persoana findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Persoana> findAll() throws SQLException {
        return null;
    }

}
