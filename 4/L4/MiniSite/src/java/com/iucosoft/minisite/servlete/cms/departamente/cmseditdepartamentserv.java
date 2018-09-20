/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.servlete.cms.departamente;

import com.iucosoft.minisite.dao.DepartamentDaoImpl;
import com.iucosoft.minisite.dao.DepartamentDaoIntf;
import com.iucosoft.minisite.entitati.Departament;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author iucosoftmain
 */
public class cmseditdepartamentserv extends HttpServlet {

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

        //1 get parametri
        //validare
        //CRUD
        //pune imn mem???
        // alege unde mergi - forward sau redirect
        //1
        String idStr = request.getParameter("ID_DEP");
        String denumire = request.getParameter("DENUM_DEP");
        String descriere = request.getParameter("DESC_DEP");

        // 2 f not null if length > <  daca are cifree...
        int idDep = Integer.parseInt(idStr);

        Departament dep = new Departament();
        dep.setId(idDep);
        dep.setDenumire(denumire);
        dep.setDescriere(descriere);

        //DepartamentDaoIntf depDao = DepartamentMockDaoImpl.getInstance();
        DataSource ds = (DataSource) request.getServletContext().getAttribute("ds");
        DepartamentDaoIntf depDao = DepartamentDaoImpl.getInstance(ds);
        try {
            if (idDep == 0) {  // save dao
                depDao.save(dep);
            } else {  // update dao
                depDao.update(dep);
            }
        } catch (SQLException ex) {
            log(ex.toString());
        }
        request.getRequestDispatcher("cmsdepartamenteserv").forward(request, response);

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
