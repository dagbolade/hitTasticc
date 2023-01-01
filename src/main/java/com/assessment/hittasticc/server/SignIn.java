/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.server;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author dagbo
 */
@WebServlet(name = "SignIn", urlPatterns = {"/SignIn"})
public class SignIn extends HttpServlet {

    
protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
 
        // get the username and password from the request
        String username = request.getParameter("username");
        String password = request.getParameter("password");
 
        // validate the login
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hittastic","root","");
            String query = "SELECT * FROM users_role WHERE username=? AND password=?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                // login successful
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                // redirect to the appropriate welcome page based on the user's role
                String role = rs.getString("role");
                if (role.equals("user")) {
                    response.sendRedirect("index.jsp");
                } else if (role.equals("admin")) {
                    response.sendRedirect("adminIndex.jsp");
                }
            } else {
                // login failed
                request.setAttribute("error", "Invalid username or password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
   

}
