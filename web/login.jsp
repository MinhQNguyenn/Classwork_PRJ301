<%-- 
    Document   : login
    Created on : Feb 14, 2023, 3:55:02 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="login" method="POST" style="margin:auto">
            <label>Account: </label>
            <input type="text" name = "account"><br>
            <label>Password</label>
            <input type="text" name ="password"><br>
            <input type="submit" value="LOGIN">
        </form>
        Do you have an account?<a href="Register.jsp">Register?</a>
    </body>
</html>
