/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.server;

import com.assessment.hittasticc.connection.dbconn;
import com.assessment.hittasticc.dao.adminDao;
import com.assessment.hittasticc.model.admlgn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dagbo
 */
@WebServlet(name = "adminLgnServlet", urlPatterns = {"/admin-login"})
public class adminLgnServlet extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.sendRedirect("admlogin.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try(PrintWriter out = response.getWriter()){
            //grab the data that is submitted
            String email = request.getParameter("login-email");
            String password = request.getParameter("login-password");
            
            try {
                //instatiate the userdao object
                adminDao udao = new adminDao(dbconn.getConnection());
                admlgn admin = udao.adminlogin(email, password);
                
                if(admin != null){
                   
                    request.getSession().setAttribute("auth", admin);
                    response.sendRedirect("adminIndex.jsp");
                }else{
                    out.print("Incorrect login details");
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(LoginUser.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
        
    }

}
