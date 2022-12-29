/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.server;

import com.assessment.hittasticc.dao.adminDao;
import com.assessment.hittasticc.model.Song;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "addSong", urlPatterns = {"/add-song"})
public class addSong extends HttpServlet {

    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  // Get the request parameters
  int id = 0;
  String idString = request.getParameter("id");
  if (idString != null && !idString.isEmpty()) {
    id = Integer.parseInt(idString);
  }

  String title = request.getParameter("title");
  String artist = request.getParameter("artist");
  String genre = request.getParameter("genre");
  
  double amount = 0.0;
  String amountString = request.getParameter("amount");
  if (amountString != null && !amountString.isEmpty()) {
    amount = Double.parseDouble(amountString);
  }

  // Create a new song object
  Song song = new Song(id, title, artist, amount, genre);

  // Create an instance of the DAO
  adminDao dao = new adminDao();

  // Add the song to the database
  dao.insert(song);

  // Set a confirmation message as a session attribute
  request.getSession().setAttribute("message", "Song added successfully");

  // Redirect to the song list page
  response.sendRedirect("adminIndex.jsp");
}
}
        
  