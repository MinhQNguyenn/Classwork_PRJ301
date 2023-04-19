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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Only start when the user has entered the info and submitted it
        SimpleDateFormat sdf = new SimpleDateFormat("dd--MM--yyyy");
        Date now = new Date();

        if (req.getParameter("create") != null) {
            //Check for any null input value
            if (req.getParameter("account") == null || req.getParameter("pass") == null || req.getParameter("repass") == null
                    || req.getParameter("gender") == null || req.getParameter("dob") == null || req.getParameter("address") == null
                    || req.getParameter("name") == null) {
                resp.sendRedirect("home.jsp");
            } else {
                //Check whether the re-entry password is the same as the original one
                boolean checkPass = checkPass(req.getParameter("pass"), req.getParameter("repass"));

                //Check whehter the birthdate is sooner than the current date
                boolean checkDate = true;
                try {
                    Date dob = sdf.parse(req.getParameter("dob"));
                    checkDate = checkDate(dob, now);
                } catch (ParseException ex) {
                    Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
                }

                String gender = "True";
                if (req.getParameter(gender) == "0") {
                    gender = "False";
                }

                //Check whether an account with the same account name has alredy existed or not
                String account = req.getParameter("account");
                User u = new User(account);
                boolean checkAccount = u.checkUserExist();

                //Total check and if success, send to the listUser page
                if (checkPass == true && checkDate == true && checkAccount == false) {
                    User a = new User(req.getParameter("account"), req.getParameter("pass"), req.getParameter("name"),
                            req.getParameter("dob"), gender, req.getParameter("address"));
                    a.addUser();
                    ArrayList<User> data = a.getListUser();
                    req.setAttribute("data", data);
                    req.getRequestDispatcher("listUser.jsp").forward(req, resp);
                }else{
                    resp.sendRedirect("home.jsp");
                }
            }
        }
    }

    protected static boolean checkPass(String a, String b) {
        return a.compareTo(b) == 0;
    }

    protected static boolean checkDate(Date a, Date b) {
        return a.compareTo(b) <= 0;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
