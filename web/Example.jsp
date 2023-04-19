<%-- 
    Document   : Example
    Created on : Feb 7, 2023, 3:38:46 PM
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
        <%
            //Scriptlet - Noi viet code giong servlet
            String message = "500 anh em hieu khong?";
            out.print(message + " ");
            out.print(this.message);
            
            //1. Khai bao va khoi tao 2 bien so nguyen a va b
            //hien thi tong, hieu, tich, thuong, so du cua a va b
            //Vi du: a+b=
            int a=5, b=36;
//            out.println("<br>a+b= " + (a+b));
//            out.println("<br>a-b= " + (a-b));
//            out.println("<br>a*b= " + (a*b));
//            out.println("<br>a/b= " + ((double) a/b));
//            out.println("<br>So du: " + (a%b));
            
            //2. Viet 1 ham kiem tra so chinh phuong
            //Ap dung ham trn de in so chinh phuong tu a den b
            //out.println("<br>Cac so chinh phuong tu a den b: ");
            String temp =" ";
            for (int i = a; i <= b; i++){
              if(checkChinhPhuong(i)) //out.print(i + " ");
                temp += i +" ";
            }
        %>

        <%!
            //La noi viet cac khai bao global
            String message = "OK anh em!";
            
            static boolean checkChinhPhuong(int a){
                for (int i = 1; i<= a/2; i ++){
                    if(i*i == a){
                        return true;
                    }
                }
                return false;
            }
        %>
        
        <br>a=<%=a%>
        <br>b=<%=b%>
        <br>a+b=<%=a+b%>
        <br>a-b=<%=a-b%>
        <br>a*b=<%=a*b%>
        <br>a/b=<%=(double)a/b%>;
        <br>a%b=<%=a%b%>
        
        <br>Cac so chinh phuong tu <%=a%> den <%=b%>: <%=temp%>
    </body>
</html>
