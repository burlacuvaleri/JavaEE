/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.servlete;

import com.iucosoft.dao.DepartamentDaoIntf;
import com.iucosoft.entitati.Departament;
import com.iucosoft.mockservicii.DepartamentMockDaoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iucosoft7
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

        // 1 get parametri
        String idStr = request.getParameter("ID_DEP");
        String denumire = request.getParameter("DENUM_DEP");
        String descriere = request.getParameter("DESC_DEP");

        DepartamentDaoIntf depDao = DepartamentMockDaoImpl.getInstance();

        // 2 if not null if length > < daca are cifre ...
        int idDep = Integer.parseInt(idStr);

        Departament dep = new Departament();
        dep.setId(idDep);
        dep.setDenumire(denumire);
        dep.setDescriere(descriere);

        try {
            if (idDep == 0) { //save dao
                depDao.save(dep);
            } else {
                depDao.update(dep);
            }
        } catch (SQLException ex) {
            log(ex.toString());
        }

        // punem in memorie
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
