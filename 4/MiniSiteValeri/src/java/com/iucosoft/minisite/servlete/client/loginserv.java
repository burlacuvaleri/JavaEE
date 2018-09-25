/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iucosoft.minisite.servlete.client;

import com.iucosoft.minisite.dao.LoginDaoImpl;
import com.iucosoft.minisite.dao.LoginDaoIntf;
import com.iucosoft.minisite.entitati.MyUser;
import com.iucosoft.minisite.servlete.constants.MyConstants;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.tomcat.jdbc.pool.DataSource;

/**
 *
 * @author iucosoft7
 */
public class loginserv extends HttpServlet {

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

        try {
            // 1. parametrii
            // 2. validarea pe partea de server
            // 3. autentificarea - este UserName si el are asa parola
            // 4. crearea sesiunii de tip HTTP
            // 5. punem in sesiunea creata UserName + alte atribute necesare !
            // 6. trecem la zona CMS - administrare
            // nu tine de login
            // 7. de fiecare data cind intram intr un link din CMS - se v a verifica sesiunea
            String username = request.getParameter("USERNAME");
            String password = request.getParameter("PASSWORD");

            // VALIDARE
            // AUTENTFICARE
            DataSource ds = (DataSource) request.getServletContext().getAttribute("ds");

            LoginDaoIntf loginDao = LoginDaoImpl.getInstance(ds);

            MyUser user = loginDao.getUserByNameAndPassword(username, password);
            if (user != null && user.isIsActivated() == true) {

                HttpSession session = request.getSession(true);
                session.setAttribute(MyConstants.ACTIVATED_USER, user);

                // contor de sesiuni autentificare +++ in context
                // logerul ++
            } else {

                throw new IOException("Login failed ...");
            }
        } catch (Exception ex) {
            request.setAttribute("error", "MIMO !");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

        request.getRequestDispatcher("cms/cmshomeserv").forward(request, response);

//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet loginserv</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet loginserv at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
