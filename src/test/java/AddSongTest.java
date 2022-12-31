/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */

import com.assessment.hittasticc.connection.dbconn;
import com.assessment.hittasticc.dao.UserDao;
import com.assessment.hittasticc.dao.adminDao;
import com.assessment.hittasticc.model.Cart;
import com.assessment.hittasticc.model.user;
import com.assessment.hittasticc.server.AddToCart;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import com.assessment.hittasticc.dao.*;
import com.assessment.hittasticc.model.admlgn;
import java.sql.DriverManager;

import org.junit.*;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;


import com.assessment.hittasticc.model.Song;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.Statement;
import javax.servlet.ServletException;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AddSongTest {

    private HttpServletRequest request;
    private Connection conn;
    private Statement st;

    @BeforeEach
    void setUp() throws Exception {
        // Set up test data
        request = mock(HttpServletRequest.class);
        when(request.getParameter("title")).thenReturn("title");
        when(request.getParameter("artist")).thenReturn("artist");
        when(request.getParameter("amount")).thenReturn("amount");
        when(request.getParameter("genre")).thenReturn("genre");

        // Establish a connection to the database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic", "root", "");
        st = conn.createStatement();
    }

    @Test
    void testDoPost() throws SQLException {
        // Execute the code being tested
        int result = st.executeUpdate("insert into songs(title,artist,amount,genre)values('title','artist','amount','genre')");

        // verify that the result of the executeUpdate method is not null 
        //and that it equals 1 (indicating that a row was inserted into the database).
        assertNotNull(result);
        assertEquals(1, result);
    }
}