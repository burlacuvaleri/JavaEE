/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.listeneri;

import java.util.Enumeration;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Web application lifecycle listener.
 *
 * @author iucosoft7
 */
public class AppAtributeServletListener implements ServletContextAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent event) {
        event.getServletContext().log("Un atribut a fost adaugat in APP !");
        event.getServletContext().log("LISTA ATTRIBUTELOR DIN APP:  ");
        // lista atributelor puse in aplicatie
        Enumeration<String> attrNames = event.getServletContext().getAttributeNames();
        int i = 0;
        while (attrNames.hasMoreElements()) {
            i++;
            String oneAttrName = attrNames.nextElement();
            event.getServletContext().log(i + "\t" + oneAttrName);
        }
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent event) {
        event.getServletContext().log("Un atribut a fost sters din APP !");
        event.getServletContext().log("LISTA ATTRIBUTELOR DIN APP:  ");
        // lista atributelor puse in aplicatie
        Enumeration<String> attrNames = event.getServletContext().getAttributeNames();
        int i = 0;
        while (attrNames.hasMoreElements()) {
            i++;
            String oneAttrName = attrNames.nextElement();
            event.getServletContext().log(i + "\t" + oneAttrName);
        }
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent event) {
        event.getServletContext().log("Un atribut a fost MODIFICAT din APP !");
        Integer contorSesiuni = (Integer) event.getServletContext().getAttribute("contorSesiuni");
        if (contorSesiuni != null) {
            event.getServletContext().log("Atribut din APP contorSesiumi = " + contorSesiuni);
        }
    }
}
