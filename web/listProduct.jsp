<%-- 
    Document   : listProduct
    Created on : Feb 28, 2023, 5:02:33 PM
    Author     : minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Model.Product"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Products</title>
    </head>
    <body>
        <table border = "1">
            <tr>
                <td>ProductID</td>
                <td>ProductName</td>
                <td>UnitPrice</td>
                <td>UnitInStock</td>
                <td>Discontinued</td>
            </tr>

            <c:forEach items="${requestScope.products}" var="item">
                <tr>
                    <td><a href="productDetail?id=${item.getP_id()}">${item.getP_id()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getPrice()}</td>
                    <td>${item.getInStock()}</td>
                    <td>${item.getDiscontinued()}</td>
                    <td><a href="product?mode=1&id=${item.getP_id()}">Delete</a></td>
                </tr>
            </c:forEach><br>
        </table>
        <a href="product?mode=2">Add new product</a><br>
        <input type ='submit' name ='update'>
        <input type ='reset' name ="RESET">
    </body>
</html>
