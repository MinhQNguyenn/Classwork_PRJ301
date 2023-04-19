<%-- 
    Document   : DisplayProduct
    Created on : Mar 2, 2023, 1:14:47 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details</title>
    </head>
    <body>
        <form action="product" method = "post" id="frm1">
            ProductID: <input type= "text" name = "p_id" value="${product.getP_id()}">
            <br>Product Name: <input type="text" name="name" value ="${product.getName()}">
            <br>Price: <input type="text" name="price" value="${product.getPrice()}">
            <br>Stock: <input type="text" name="stock" value="${product.getInStock()}">
        </form>
        <input type="submit" name="update" value="update">
    </body>
</html>
