/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DBContext;
import Model.Product;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author minh
 */
public class ProductController extends HttpServlet {

    Connection cnn; //ket noi
    Statement stm; //Thuc thi cac cau lenh sql
    ResultSet rs; //Luu tru va xu ly du lieu
    PreparedStatement pstm;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       HttpSession sess = req.getSession();
        if (sess.getAttribute("account") == null) {
            resp.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login!");
                return;
            }
        }
        
        if (req.getParameter("Add") != null) {
            try {
                Product p = new Product();
                cnn = p.cnn;
                String name = req.getParameter("name");
                double price = Double.parseDouble(req.getParameter("price"));
                int stock = Integer.parseInt(req.getParameter("stock"));
                String discontinued = req.getParameter("discontinued");

                String strAdd = "INSERT into Products(ProductName, UnitPrice, UnitsInStock, Discontinued) "
                        + "VALUES (? , ?, ?, ?)";
                pstm = cnn.prepareStatement(strAdd);
                pstm.setString(1, name);
                pstm.setDouble(2, price);
                pstm.setInt(3, stock);
                pstm.setString(4, discontinued);
                pstm.execute();

                ArrayList<Product> products = p.getListProduct();
                req.setAttribute("products", products);
                req.getRequestDispatcher("listProduct.jsp").forward(req, resp);

            } catch (SQLException ex) {
                System.out.println("Add: " + ex.getMessage());
            }
        } else {
            String P_id = req.getParameter("P_id");
            String name = req.getParameter("name");
            double price = Double.parseDouble(req.getParameter("price"));
            int stock = Integer.parseInt(req.getParameter("stock"));
            String discontinued = req.getParameter("discontinued");

            Product p = new Product(P_id, name, stock, price);
            p.getProduct();
            ArrayList<Product> products = p.getListProduct();
            req.setAttribute("products", products);
            req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Check xem da login chua
        HttpSession sess = req.getSession();
        if (sess.getAttribute("account") == null) {
            resp.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = resp.getWriter()) {
                out.print("May chua login!");
                return;
            }
        }

            Product p = new Product();
            ArrayList<Product> products = p.getListProduct();

            if (req.getParameter("mode") != null) {
                int mode = Integer.parseInt(req.getParameter("mode"));
                String id = req.getParameter("id");
                if (mode == 1) {
                    try {
                        Product pr = new Product();
                        pr.deleteProduct(id);
                        products = pr.getListProduct();     
                    } catch (Exception E) {
                        System.out.println("Delete: " + E.getMessage());
                    }
                } else {
                    req.getRequestDispatcher("addProduct.jsp").forward(req, resp);
                    return;
                }
            }
            req.setAttribute("products", products);
            req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
        }

    }
