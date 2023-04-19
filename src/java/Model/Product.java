/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class Product {

    String P_id, name, C_id, discontinued;
    int inStock;
    double price;

    public Product() {
        connect();
    }

    public Product(String P_id) {
        this.P_id = P_id;
        connect();
    }

    public Product(String P_id, String name, int inStock, double price) {
        this.P_id = P_id;
        this.name = name;
        this.inStock = inStock;
        this.price = price;
        connect();
    }

    public Product(String P_id, String name, double price, int inStock, String discontinued) {
        this.P_id = P_id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
        this.discontinued = discontinued;
        connect();
    }

    public String getP_id() {
        return P_id;
    }

    public void setP_id(String P_id) {
        this.P_id = P_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_id() {
        return C_id;
    }

    public void setC_id(String C_id) {
        this.C_id = C_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getInStock() {
        return inStock;
    }

    public void setInStock(int inStock) {
        this.inStock = inStock;
    }

    public String getDiscontinued() {
        return discontinued;
    }

    public void setDiscontinued(String discontinued) {
        this.discontinued = discontinued;
    }

    public Connection cnn; //ket noi
    Statement stm; //Thuc thi cac cau lenh sql
    ResultSet rs; //Luu tru va xu ly du lieu
    PreparedStatement pstm;

    private void connect() {
        try {
            cnn = (new DBContext()).connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect fail!");
            }
        } catch (Exception e) {
        }
    }

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> products = new ArrayList<Product>();
        try {
            String strSelect = "select * from Products";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String P_id = rs.getString(1);
                String name = rs.getString(2);
                double price = Double.parseDouble(rs.getString(3));
                int stock = Integer.parseInt(rs.getString(4));
                String discontinued = rs.getString(7);

                products.add(new Product(P_id, name, price, stock, discontinued));
            }

        } catch (Exception e) {
            System.out.println("checkProduct: " + e.getMessage());
        }
        return products;
    }

    public void getProduct() {
        try {
            String strSelect = "Select * from Products where ProductID=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, P_id);
            rs = pstm.executeQuery();

            while (rs.next()) {
                name = rs.getString(2);
                price = Double.parseDouble(rs.getString(3));
                inStock = Integer.parseInt(rs.getString(4));
                C_id = rs.getString(6);
            }

        } catch (Exception e) {
            System.out.println("checkProduct: " + e.getMessage());
        }
    }

    public void update() {
        try {
            String strUpdate = "update Products set ProductName =?, UnitPrice =?, "
                    + "UnitsInStock=?, CategoryID=?, "
                    + "Discontinued=? where ProductID = ?";
            pstm = cnn.prepareStatement(strUpdate);
            pstm.setString(1, name);
            pstm.setDouble(2, price);
            pstm.setInt(3, inStock);
            pstm.setString(6, C_id);
            pstm.execute();

        } catch (Exception E) {
            System.out.println("Update: " + E.getMessage());
        }
    }

    public void deleteProduct(String id) {
        try {
            String strDelete = "delete from Products where ProductID = '" + id + "' ";
            pstm = cnn.prepareStatement(strDelete);
            pstm.execute();
        } catch (Exception E) {
            System.out.println("Delete: " + E.getMessage());
        }
    }
    
    
    
}
