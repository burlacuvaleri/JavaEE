<%--
    Document   : cmsdepartament
    Created on : Sep 13, 2018, 6:17:25 PM
    Author     : iucosoft7
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>CMS Departament EDITARE PAGE ! JSP Editare !</h1>

        <%--${dep} --%>

        <form action="cmseditdepartamentserv" method="POST">
            <p> ID <input type="text" name="ID_DEP" value="${dep.id}" size="4" /></p>
            <p> Denumire <input type="text" name="DENUM_DEP" value="${dep.denumire}" size="30" /></p>
            <p> Descriere <textarea name="DESC_DEP" rows="8" cols="30">${dep.descriere}</textarea></p>
            <p> <input type="submit" value="SAVE/UPDATE" /></p>
        </form>


    </body>
</html>
