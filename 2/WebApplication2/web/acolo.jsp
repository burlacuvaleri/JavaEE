<%--
    Document   : acolo
    Created on : Sep 11, 2018, 7:32:00 PM
    Author     : iucosoft7
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Am ajuns acolo !</h1>

        <%!
            int x = 88;

            private String print() {
                String mesaj = "" + x * 5;
                return mesaj;
            }

        %>


        Salut ${username} <br>
        Parola ta secreta: ${password} <br>

        <%--scriplet--%>
        <%
            out.print("<p>Textul meu in JSP </p>");
            out.print("<p>" + x + " </p>");
        %>



        <%--jspexpression--%>
        <%="Textul meu 2"%>
        <br>
        <%=print()%>



        <%!- comentariu in zona HTML

            --%>
        <%-- comentariu in zona JAVA--%>



    </body>
</html>
