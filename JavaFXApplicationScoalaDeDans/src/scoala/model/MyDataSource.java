/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scoala.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iucosoft9
 */
public class MyDataSource {

    private static final Logger LOG = Logger.getLogger(MyDataSource.class.getName());

    private static MyDataSource instance;

    public static MyDataSource getInstance() throws ClassNotFoundException, SQLException {
        if (instance == null) {
            instance = new MyDataSource();
        }

        return instance;
    }

    String driverdb = "com.mysql.jdbc.Driver";
    String userdb = "userdans";
    String passworddb = "free";
    String urldb = "jdbc:mysql://localhost:3306/scoaladedans";
    private Connection connection;

    private MyDataSource() throws ClassNotFoundException, SQLException {

        loadProperties();
        loadDriver();
        testConnection();

    }

    private void loadProperties() {
        LOG.info("Au fost citite proprietatile din fisier.");
    }

    private void loadDriver() throws ClassNotFoundException {

        Class.forName(driverdb);
        LOG.info("Driver incarcat cu succes!");
    }

    private void testConnection() throws SQLException {
        connection = DriverManager.getConnection(urldb, userdb, passworddb);
        LOG.info("Conexiunea a avut loc cu succes!");
    }

    public Connection getConnection() throws SQLException {

        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(urldb, userdb, passworddb);
        }
        return connection;
    }

}
