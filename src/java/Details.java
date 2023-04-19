
import Model.DBContext;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author minh
 */
public class Details extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {

            Connection cnn; //ket noi
            Statement stm; //Thuc thi cac cau lenh sql
            ResultSet rs; //Luu tru va xu ly du lieu

            cnn = (new DBContext()).connection;

            String account = req.getParameter("acc");

            String strSelect = "select * from Users where account='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            String password = rs.getString(2);
            String name = rs.getString(3);
            String gender = "Female";
            if (rs.getBoolean(4)) {
                gender = "Male";
            }
            String address = rs.getString(5);

            String dob = "NULL";
            if (rs.getDate(6) != null) {
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                dob = f.format(rs.getDate(6));
            }
            User u = new User(account, password, name, dob, gender, address);

            req.setAttribute("user", u);
            req.getRequestDispatcher("DisplayProfile.jsp").forward(req, resp);

        } catch (SQLException ex) {
            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = resp.getWriter()) {
            String account = req.getParameter("acc");
            
            User u = new User(account, "");
            u.getUser();

            req.setAttribute("user", u);
            req.getRequestDispatcher("DisplayProfile.jsp").forward(req, resp);
            
        }
    }

}
