/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

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
public class User {

    private String account, password, name, dob, gender, address;

    public User() {
        connect();
    }

    public User(String account, String password, String name, String dob, String gender, String address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.address = address;
        connect();
    }

    public User(String account, String password) {
        this.account = account;
        this.password = password;
        connect();
    }

    public User(String account) {
        this.account = account;
        connect();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean checkUser() {
//        if("admin".equals(account) && "123".equals(password)){
//            return true;
//        }return false;
//        try {
//            String strSelect = "select * from Users where account='" + account + "' and Password='" + password + "'";
//            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
//            rs = stm.executeQuery(strSelect);
//            while (rs.next()) {
//                return true;
//            }
//        } catch (Exception e) {
//            System.out.println("checkUser: " + e.getMessage());
//        }
//        return false;

        try {
            String strSelect = "select * from Users where account=? " + "and Password=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            pstm.setString(2, password);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return false;
    }

    //Khai bao cac thanh phan xu ly database
    Connection cnn; //ket noi
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

    public String getNameByAccount() {
        try {
            String strSelect = "select * from Users";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String name = rs.getString(3);
                return name;
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return "";
    }

    public ArrayList<User> getListUser() {
        ArrayList<User> data = new ArrayList<User>();
        try {
            String strSelect = "select * from Users";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                String account = rs.getString(1);
                String password = rs.getString(2);
                String name = rs.getString(3);
                String gender = "Female";
                if (rs.getBoolean(4)) {
                    gender = "Male";
                }
                String address = rs.getString(5);

                String dob = "";
                if (rs.getDate(6) != null) {
                    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                    dob = f.format(rs.getDate(6));
                }

                data.add(new User(account, password, name, dob, gender, address));
            }
        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
        return data;
    }

    public void getUser() {
        try {
            String strSelect = "Select * from Users where account='" + account + "'";
            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);

            while (rs.next()) {
                account = rs.getString(1);
                password = rs.getString(2);
                name = rs.getString(3);
                gender = "Female";
                if (rs.getBoolean(4)) {
                    gender = "Male";
                }
                address = rs.getString(5);

                dob = "";
                if (rs.getDate(6) != null) {
                    SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                    dob = f.format(rs.getDate(6));
                }
            }

        } catch (Exception e) {
            System.out.println("checkUser: " + e.getMessage());
        }
    }

    public boolean checkUserExist() {
        boolean check = false;
        try {
            String strSelect = "Select * from Users where account=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, account);
            rs = pstm.executeQuery();

            if (rs.getString(1) != null) {
                check = true;
            }

        } catch (Exception e) {
            System.out.println("checkUserExist: " + e.getMessage());
        }
        return check;
    }

    public void addUser() {
        connect();
        try {
            String strAdd = "INSERT into Users "
                    + "VALUES (?, ?, ?, ?, ?, ?);";
            pstm = cnn.prepareStatement(strAdd);
            pstm.setString(1, account);
            pstm.setString(2, password);
            pstm.setString(3, name);
            pstm.setString(4, dob);
            pstm.setString(5, gender);
            pstm.setString(6, address);
            pstm.execute();

        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
