/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.servlete.cms.departamente;

import com.iucosoft.minisite.dao.DepartamentDaoIntf;
import com.iucosoft.minisite.entitati.Departament;
import com.iucosoft.minisite.entitati.MyUser;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.iucosoft.minisite.mockservicii.DepartamentMockDaoImpl;
import com.iucosoft.minisite.servlete.constants.MyConstants;
import javax.servlet.http.HttpSession;

/**
 *
 * @author iucosoftmain
 */
public class cmsshoweditdepartamentserv extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Verificare de fiecare data la intrarea in fiecare serveket de tip CMS !!!
        // Ca sa fie mai comod facem 1 FILTRU
        // Care va fi configurat sa fie apelat automat la apelarea fiecarui servlet din CMS
        /*
        HttpSession session = request.getSession();
        if (session == null) {
            throw new IOException("Session is NULL !");
        }
        MyUser myUser = (MyUser) session.getAttribute(MyConstants.ACTIVATED_USER);
        if (session != null && myUser == null) {
            throw new IOException("User is NULL !");
        }
        if (session != null && myUser != null) {
            if (!myUser.isIsActivated()) {
                throw new IOException("User is disabled !");
            }
        }
         */
        // Tot bine este sesiune si este user activat
        String idStr = request.getParameter("id");

        int id = 0;

        if (idStr != null) {

            id = Integer.parseInt(idStr);
        }

        Departament dep = null;

        if (id == 0) {
            dep = new Departament("", "");
        } else {

            DepartamentDaoIntf depDao = DepartamentMockDaoImpl.getInstance();
            try {

                dep = depDao.findById(id);

            } catch (SQLException ex) {
                Logger.getLogger(cmsdepartamenteserv.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        request.setAttribute("dep", dep);

        request.getRequestDispatcher("/WEB-INF/cms/departamente/cmseditdepartament.jsp").forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
