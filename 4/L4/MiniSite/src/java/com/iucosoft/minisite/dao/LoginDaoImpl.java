/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.dao;

import com.iucosoft.minisite.entitati.MyUser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

/**
 *
 * @author iucosoft7
 */
public class LoginDaoImpl implements LoginDaoIntf {

    private DataSource ds;
    Connection connection;
    // SINGLETON
    private static LoginDaoIntf instance;

    public static LoginDaoIntf getInstance(DataSource ds) {
        if (instance == null) {
            instance = new LoginDaoImpl(ds);
        }
        return instance;
    }

    private LoginDaoImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public MyUser getUserByNameAndPassword(String username, String password) throws SQLException {

        String sql = "   SELECT * FROM users WHERE username =? AND password =?";
        connection = ds.getConnection();
        PreparedStatement psmt = connection.prepareStatement(sql);

        psmt.setString(1, username);
        psmt.setString(2, password);

        ResultSet rs = psmt.executeQuery();

        MyUser user = null;
        if (rs.next()) {

            int id = rs.getInt(1);
            boolean isActivated = rs.getBoolean(4);

            user = new MyUser(id, username, "", isActivated);

        }

        psmt.close();
        connection.close();

        return user;
    }

}
