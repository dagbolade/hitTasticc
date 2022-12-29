/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.server;

import com.assessment.hittasticc.connection.dbconn;
import com.assessment.hittasticc.dao.SongsDao;
import com.assessment.hittasticc.model.Song;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
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
@WebServlet(name = "SearchServlet", urlPatterns = {"/search"})
public class SearchServlet extends HttpServlet {
   
            
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()){
            
            
            SongsDao songDao = new SongsDao(dbconn.getConnection());
            String search = request.getParameter("search");
            
            System.out.println("Search string: " + search);
            
            List<Song> songList = songDao.searchMusic(search);
            request.setAttribute("songList", songList);
            
             System.out.println("Number of songs found in servlet: " + songList.size());

            
            response.sendRedirect("search-results.jsp");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         doGet(request, response);
    }


}
