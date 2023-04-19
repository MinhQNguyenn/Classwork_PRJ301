
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * This class would be used to implement 1 servlet
 * @author minh
 */

public class Example extends HttpServlet{

    @Override
    /**
     * This method is called when form calls it for set method='post'
     */
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=resp.getWriter()){
            //receive the data from client
            int a, b;
            String result="";
            boolean check = true;
            
            //Validate for a
            if(req.getParameter("a").isEmpty()){
                result="a is empty";
                check=false;
            }
            else{
                try{
                    a=Integer.parseInt(req.getParameter("a"));
                }catch(Exception e){
                    result+="<br>a isn't an integer number";
                    check=false;
                }
            }if(!check){
                out.print(result);
                result ="";
            }
            
            
            //Validate for b
            if(req.getParameter("b").isEmpty()){
                result="b is empty";
                check=false;
            }
            else{
                try{
                    b=Integer.parseInt(req.getParameter("b"));
                }catch(Exception e){
                    result+="<br>b isn't an integer number";
                    check=false;
                }
            }if(!check){
                out.print("<br>" + result);
                result ="";
            }
            
            
            
            a=Integer.parseInt(req.getParameter("a"));
            b=Integer.parseInt(req.getParameter("b"));
            
            //processing the data
            
            
            //return the result to the user
            if(req.getParameter("op").equals("0")){
                result="May ngu a? Chon phep tinh da";
            }
            
            if(req.getParameter("op").equals("1")){
                result="Result="+(a+b);
            }
            
            if(req.getParameter("op").equals("2")){
                result="Result="+(a-b);
            }      
            
            if(req.getParameter("ex")!=null){ //The execute button is pressed
                result="Result="+(a*b);
            }
            out.print(result);
        }
    }

    
    /**
     * This method is used when:
     * 1, it directly runs servlet
     * 2, Form calls it to set method='get' or not set method
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out=resp.getWriter()){ //use to write data on the computer's screen
            out.print("<!DOCTYPE html>");
            out.print("<html>");
            out.print("<head>");
            out.print("</head>");
            out.print("<body>");
            out.print("CALCULATION");
            out.print("<form method='post'>");
            out.print("Enter a:<input type='text' name ='a'>");
            out.print("<br>Enter b:<input type='text' name='b'>");
            out.print("<br><input type='submit' name='ex' value='Execute'>");
            out.print("</form>");
            out.print("</body>");
            out.print("</html>");
        }
    }
    
}
