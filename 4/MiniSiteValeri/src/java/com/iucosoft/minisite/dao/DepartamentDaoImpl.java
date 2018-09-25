/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.dao;

import com.iucosoft.minisite.entitati.Departament;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author iucosoftmain
 */
public class DepartamentDaoImpl implements DepartamentDaoIntf {

    private static final Logger LOG = Logger.getLogger(DepartamentDaoImpl.class.getName());

    public static DepartamentDaoIntf getInstance(DataSource ds) {

        if (instance == null) {
            instance = new DepartamentDaoImpl(ds);
        }
        return instance;
    }

    private DataSource ds;
    private static DepartamentDaoIntf instance;

    private DepartamentDaoImpl(DataSource ds) {

        this.ds = ds;
    }

    @Override
    public void save(Departament dep) throws SQLException {

        Connection conn = ds.getConnection();

        String insert = "INSERT INTO DEPARTAMENTE VALUES(null, ?, ?)";

        PreparedStatement ps = conn.prepareStatement(insert);

        ps.setString(1, dep.getDenumire());
        ps.setString(2, dep.getDescriere());

        ps.executeUpdate();

        ps.close();
        conn.close();

        LOG.info("save dep " + dep);
    }

    @Override
    public void update(Departament dep) throws SQLException {

        String sql = "UPDATE DEPARTAMENTE SET denumire=? , descriere=? where id=?";

        Connection conn = ds.getConnection();

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, dep.getDenumire());
        stmt.setString(2, dep.getDescriere());
        stmt.setInt(3, dep.getId());

        stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

    }

    @Override
    public void delete(Departament dep) throws SQLException {

        String sql = "DELETE FROM DEPARTAMENTE WHERE id=" + dep.getId();

        Connection conn = ds.getConnection();

        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);

        stmt.close();
        conn.close();

    }

    @Override
    public Departament findById(int id) throws SQLException {

        String sql = "SELECT * FROM DEPARTAMENTE where id=" + id;

        Connection conn = ds.getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        Departament dp = null;
        if (rs.next()) {

            dp = new Departament();
            dp.setId(rs.getInt(1));
            dp.setDenumire(rs.getString(2));
            dp.setDescriere(rs.getString(3));
        }

        stmt.close();
        conn.close();

        return dp;
    }

    @Override
    public List<Departament> findAll() throws SQLException {
        List<Departament> lista = new ArrayList<>();
        String sql = "SELECT * FROM DEPARTAMENTE";

        Connection conn = ds.getConnection();

        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        Departament dp = null;
        while (rs.next()) {

            dp = new Departament();
            dp.setId(rs.getInt(1));
            dp.setDenumire(rs.getString(2));
            dp.setDescriere(rs.getString(3));

            lista.add(dp);

        }

        stmt.close();
        conn.close();

        return lista;

    }

}
