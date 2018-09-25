<%--
    Document   : login
    Created on : Sep 25, 2018, 6:50:49 PM
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
        <h1>Login Page</h1>

        <div>

            <%
                String errorMsg = (String) request.getAttribute("error");

                if (errorMsg != null) {

            %>


            <p>style="color:red"> <%=errorMsg%> </p>

            <%

                }
            %>

            <form action="loginserv" method="POST">
                <p>USER NAME <input type="text" name="USERNAME" value="" size="12"></p>
                <p>PASSWORD <input type="password" name="PASSWORD" value="" size="12"></p>
                <p><input type="submit" value="LOG ME IN" ></p>
            </form>
        </div>

    </body>
</html>
