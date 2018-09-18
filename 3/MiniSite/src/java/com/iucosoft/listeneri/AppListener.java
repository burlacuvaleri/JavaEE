/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.listeneri;

import java.util.logging.Logger;
import javax.activation.DataSource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author iucosoft7
 */
public class AppListener implements ServletContextListener {

    private static final Logger LOG = Logger.getLogger(AppListener.class.getName());

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup(name);
        de scris cod LOG
        .info("A FOST FACUT DEPLOY");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        LOG.info("A FOST FACUT DELETE A SITULUI DE PE SERVER");
    }

}
