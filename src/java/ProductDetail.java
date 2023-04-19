
import Model.Product;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author minh
 */
public class ProductDetail extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("p_id");
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        int stock = Integer.parseInt(req.getParameter("stock"));
        String discontinued = req.getParameter("discontinued");
        
        Product p = new Product(id, name, price, stock, discontinued);
        p.update();
        
        ArrayList<Product> products = p.getListProduct();
        req.setAttribute("products", products);
        req.getRequestDispatcher("listProduct.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String id = req.getParameter("id");
            
            Product p = new Product(id);
            p.getProduct();
            
            req.setAttribute("product", p);
            req.getRequestDispatcher("DisplayProduct.jsp").forward(req, resp);
    }   
    
}
