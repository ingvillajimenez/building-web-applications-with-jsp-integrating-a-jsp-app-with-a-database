<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import= "java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JSP and Databases</title>
    </head>
    <body>

        <%
            String url = "jdbc:mysql://localhost:3306/JSPDatabase";
            String username = "root";
            String password = "admin123";
            String sql = "select * from Customers";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
        %>
        <center>
            <h3> The customers in the database: </h3><br><br>
            <table border="2">
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Country</th>
                </tr>

            <% while(rs.next()) { %>

                <tr>
                    <td><%= rs.getInt("id") %></td>
                    <td><%= rs.getString("name") %></td>
                    <td><%= rs.getString("email") %></td>
                    <td><%= rs.getString("country") %></td>
                </tr>

            <% }

                rs.close();
            %>
            </table>
        </center>

    </body>
</html>