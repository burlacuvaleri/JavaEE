/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author iucosoft7
 */
public class HomeServelet extends HttpServlet {

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

        String nume = request.getParameter("NUME");
        String virsta = request.getParameter("VIRSTA");
        String mesaj = "Salut " + nume + " ai virsta de " + virsta + " ani si nu poti merge la cinematograf !";

        if (nume == null) {
            nume = "";
        }
        if (virsta == null) {
            virsta = "";
        }

        if (Integer.parseInt(virsta) >= 18) {
            mesaj = "Salut " + nume + " ai virsta de " + virsta + " ani si poti merge la cinematograf !";
        }

        if (nume.equals("") || virsta.equals("")) {
            mesaj = "Introduceti NUME si VIRSTA obligatorie";
        }

//        request.setAttribute("attNume", nume);
//        request.setAttribute("attVirsta", virsta);
        request.setAttribute("attMesaj", mesaj);

        request.getRequestDispatcher("/home.jsp").forward(request, response);

//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet HomeServelet</title>");
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet HomeServelet at " + request.getContextPath() + "</h1>");
//
//            for (int i = 1; i <= 6; i++) {
//                out.println("<h" + i + "> Acesta este textul meu scris in H " + i + "</h" + i + ">");
//            }
//
//            out.println("<br> Text obisnuit");
//            out.println("</body>");
//            out.println("</html>");
//    }
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
