/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.listeneri;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author iucosoftmain
 */
public class AppListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(AppListener.class.getName());
    private static Integer contorSesiuni = 0;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        sce.getServletContext().setAttribute("contorSesiuni", contorSesiuni);

        try {
            Context initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            DataSource ds = (DataSource) envContext.lookup("jdbc/webminisite");
            Connection conn = ds.getConnection();
            if (conn != null) {
                LOG.info("CONEXIUNEA LA BD CREATA CU SUCCES!!!!");
                LOG.info(conn.toString());
                sce.getServletContext().setAttribute("ds", ds);

                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            }
            LOG.info("A FOSTY FACUT DEPLOY!!!!!!!!!!!!");
        } catch (NamingException ex) {
            Logger.getLogger(AppListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AppListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DataSource ds = (DataSource) sce.getServletContext().getAttribute("ds");
        if (ds != null) {
            try {
                Connection conn = ds.getConnection();
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AppListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            sce.getServletContext().removeAttribute("ds");
        }
        LOG.info("A FOSTY FACUT DELETE A SITULUI DE PE SERVER!!!!!!!!!!!!");
    }

}
