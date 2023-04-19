<%-- 
    Document   : Register
    Created on : Mar 7, 2023, 4:11:35 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form action="register" method="post">
            <table>
                <tr>
                    <td>Account: </td>
                    <td><input type ="text" name ="account"></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="text" name="pass"></td>
                </tr>
                <tr>
                    <td>Re-type password: </td>
                    <td><input type="text" name="repass"></td>
                </tr>
                <tr>
                    <td>Gender: </td>
                    <td><input type="radio" name="gender" value ='1'>Male
                    <input type="radio" name="gender" value = '0'>Female</td>
                </tr>
                <tr>
                    <td>Name: </td>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <td>Birthdate: </td>
                    <td><input type="date" name="dob"></td>
                </tr>
                <tr>
                    <td>Address: </td>
                    <td><input type="text" name="address"></td>
                </tr>
            </table>
            <br><input type='submit' name='create' value='Create'>
        </form>
    </body>
</html>
