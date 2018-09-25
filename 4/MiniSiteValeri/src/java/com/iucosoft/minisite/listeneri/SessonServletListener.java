/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.listeneri;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author iucosoft7
 */
public class SessonServletListener implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        Integer contorSesiuni = (Integer) se.getSession().getServletContext().getAttribute("contorSesiuni");

        if (contorSesiuni != null) {
            contorSesiuni++; // AICI e diferenta
            se.getSession().getServletContext().setAttribute("contorSesiuni", contorSesiuni);
        }

    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {

        Integer contorSesiuni = (Integer) se.getSession().getServletContext().getAttribute("contorSesiuni");

        if (contorSesiuni != null) {
            contorSesiuni--; // AICI e diferenta
            se.getSession().getServletContext().setAttribute("contorSesiuni", contorSesiuni);
        }

    }
}
