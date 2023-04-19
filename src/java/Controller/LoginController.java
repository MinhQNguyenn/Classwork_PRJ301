/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class LoginController extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Nhan thong tin
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        
        //Xu ly thong tin
        User u = new User(account, password);
        boolean check = u.checkUser();
       
        //Ket qua tra ve
        if(check){
            //Luu thong tin login vao Session
            HttpSession session = req.getSession();
            session.setAttribute("account", u);
            
            
            String name = u.getNameByAccount();
            req.setAttribute("name", name);
            ArrayList<User> data =u.getListUser();
            req.setAttribute("data", data);
            req.getRequestDispatcher("listUser.jsp").forward(req, resp);
        }else{
            req.getRequestDispatcher("home.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("home.jsp");
    }

    
}
