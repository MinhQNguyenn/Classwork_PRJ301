<%-- 
    Document   : listUser
    Created on : Feb 14, 2023, 4:17:01 PM
    Author     : minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.User"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List User</title>
    </head>
    <body>
        <%
            String name = "";
            if(request.getAttribute("name")!= null)
               name = (String)request.getAttribute("name");
               
            ArrayList<User> data = new ArrayList<User>();
            if(request.getAttribute("data")!= null)
               data = (ArrayList<User>)request.getAttribute("data");
        %>
        <h1>LOGIN SUCESSFULLY!!!</h1>
        Hello <b><%=name%></b>

        <table border = "1">
            <tr>
                <td>Account</td>
                <td>Password</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Address</td>
                <td>DOB</td>
            </tr>
            <%
                for(User u:data){
                    out.print("<tr>");
                    out.print("<td><a href='detail?acc="+u.getAccount()+"'>" + u.getAccount() + "</a></td>");
                    out.print("<td>" + u.getPassword() + "</td>");
                    out.print("<td>" + u.getName() + "</td>");
                    out.print("<td>" + u.getGender() + "</td>");
                    out.print("<td>" + u.getAddress() + "</td>");
                    out.print("<td>" + u.getDob() + "</td>");
                    out.print("</tr>");
                }
            %> 
        </table>



        <br>List User - using JSTL & EL
        <table border = "1">
            <tr>
                <td>Account</td>
                <td>Password</td>
                <td>Name</td>
                <td>Gender</td>
                <td>Address</td>
                <td>DOB</td>
            </tr>
            <c:forEach items="${requestScope.data}" var="item">
                <tr>
                    <td><a href="detail?acc=${item.getAccount()}">${item.getAccount()}</td>
                    <td>${item.getPassword()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getAddress()}</td>
                    <td>${item.getDob()}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
