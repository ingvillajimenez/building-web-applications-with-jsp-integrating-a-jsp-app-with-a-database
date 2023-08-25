package com.skillsoft;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.skillsoft.model.User;

public class UserDAO {

    public static Connection getConnection() {
        Connection con = null;
        try {

            String url = "jdbc:mysql://localhost:3306/JSPDatabase";
            String username = "root";
            String password = "admin123";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    public static List<User> getAllRecords() {

        List<User> userList = new ArrayList<User>();

        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Customers");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("name"));
                u.setEmail(rs.getString("email"));
                u.setGender(rs.getString("gender"));
                u.setCountry(rs.getString("country"));
                userList.add(u);
            }
            con.close();

        }
        catch (Exception e){
            System.out.println(e);
        }

        return userList;
    }

    public static User getRecordById(int id) {

        User user = null;
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Customers where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setCountry(rs.getString("country"));
            }

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        return user;
    }
}

// For older Tomcat users
// https://mvnrepository.com/artifact/javax.servlet.jsp.jstl/jstl-api/1.2