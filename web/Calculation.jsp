<%-- 
    Document   : Calculation
    Created on : Feb 7, 2023, 4:59:53 PM
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
            //Nhan ket qua tra ve tu Server
            String result = "";
            if(request.getAttribute("result")!= null)
               result = (String)request.getAttribute("result");
               
            String a="";
            if(request.getAttribute("a")!= null)
               a = (String)request.getAttribute("a");
            
           String b="";
            if(request.getAttribute("b")!= null)
               b = (String)request.getAttribute("b");
               
           String op="";
           if(request.getAttribute("op")!= null)
               op = (String)request.getAttribute("op");
        %>    
        
        CALCULATION;
        <form action='example2' method='post' id='frm'>
            Enter a:<input type='text' name ='a' value="<%=a%>">
            <br>Enter b:<input type='text' name='b' value="<%=b%>">
            <br>Operator:
            <select name="op" onchange="change()">
                <%
                    if(op.equals("1")){
                        out.print("<option value='0'>All</option>");
                        out.print("<option value='1' selected>+</option>");
                        out.print("<option value='2'>-</option>");
                    }
                    else if(op.equals("2")){
                        out.print("<option value='0'>All</option>");
                        out.print("<option value='1'>+</option>");
                        out.print("<option value='2' selected>-</option>");
                    }
                    else{
                        out.print("<option value='0' selected>All</option>");
                        out.print("<option value='1'>+</option>");
                        out.print("<option value='2'>-</option>");
                    }
                %>
<!--                <option value="0">All</option>
                    <option value="1">+</option>
                    <option value="2">-</option>-->
            </select>
            <br>Result:<input type="text" readonly value="<%=result%>">
            <br><input type='submit' name='ex' value='Execute'>
        </form>

        <script>
            function change() {
                document.getElementById("frm").submit();
            }

            function checkInteger(a) {
                if (!Number.isInteger(a)) {
                    alert(a.value + " is not an integer");
                }
            }
        </script>
    </body>
</html>
