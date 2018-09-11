<%--
    Document   : test1
    Created on : Sep 11, 2018, 6:42:57 PM
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
        <h1>Login page </h1>

        <form action = "loginservlet" method="GET" >

            <p>Username  <input type="text" name="USERNAME" value="" size="20" /> </p>
            <p>Password   <input type="password" name="PASSWORD" value="" size="20" /> </p>
            <input type="submit" value="APASA !" >

        </form>
    </body>
</html>
