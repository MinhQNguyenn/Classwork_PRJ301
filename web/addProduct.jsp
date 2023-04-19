<%-- 
    Document   : addProduct
    Created on : Mar 2, 2023, 2:46:58 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new product</title>
    </head>
    <body>
        <h1>Please enter the data for the new product:</h1>
        <form action="product" method="post" id ="frm2">
            <label>Product Name: </label>
            <input type ="text" name="name"><br>
            <label>Unit Price: </label>
            <input type="text" name ="price"><br>
            <label>Unit InStock: </label>
            <input type ="text" name="stock"><br>
            <label>Discontinued: </label>
            <input type ="text" name="discontinued"><br>
            <input type ="submit" name="Add" value="Add">
        </form>
    </body>
</html>
