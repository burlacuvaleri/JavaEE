<%--
    Document   : cmsdepartamente
    Created on : Sep 13, 2018, 7:08:44 PM
    Author     : iucosoftmain
--%>

<%@page import="java.util.List"%>
<%@page import="com.iucosoft.minisite.entitati.Departament"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CMA DEPARTAMENTE PAGE</h1>
        <p><a href="cmsshoweditdepartamentserv?id=0">ADD NEW DEP</a></p>
        <p>aici va fi lista departamentelor</p>


        <%

            List<Departament> lista = (List<Departament>) request.getAttribute("lista");

            if (lista != null) {
                int i = 0;
                for (Departament dep : lista) {
                    i++;
                    out.println("<p>" + i + " id= " + dep.getId()
                            + " " + dep.getDenumire()
                            + " | <a href=\"cmsshoweditdepartamentserv?id=" + dep.getId() + "\"> edit </a>  "
                            + " | <a href=\"cmsdeletedepartamentserv?id=" + dep.getId() + "\"> delete </a>  "
                            + "</p>");

                }
            }

        %>


    </body>
</html>
