<%-- 
    Document   : DisplayProfile
    Created on : Feb 23, 2023, 1:22:51 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Details</title>
    </head>
    <body>
        <!-- 
        <%
            User user = new User();
            if(request.getAttribute("user")!= null)
               user = (User)request.getAttribute("user");
               
            String account = user.getAccount();
            String pass = user.getPassword();
            String name = user.getName();
            String dob = user.getDob();
            String gender = user.getGender();
            String address = user.getAddress();
        %>
        <form>
        <label>User: </label>
        <input type ="text" value ="<%=account%>"><br>
        <label>Password: </label>
        <input type ="text" value ="<%=pass%>"><br>
        <label>Name: </label>
        <input type ="text" value ="<%=name%>"><br>
        <label>Gender: </label>
        <input type ="text" value ="<%=gender%>"><br>
        <label>Address: </label>
        <input type ="text" value ="<%=address%>"><br>
        <label>DOB: </label>
        <input type ="text" value ="<%=dob%>"><br>
        </form>
        -->
        
        <br><b style="font-weight: bold">Information of User-using EL:</b>
        <br>Account: ${user.getAccount()}
        <br>Password: ${user.getPassword()}
        <br>Name: ${user.getName()}
        <br>Gender: ${user.getGender()}
        <br>Address: ${user.getAddress()}
        <br>DOB: ${user.getDob()}
    </body>
</html>
