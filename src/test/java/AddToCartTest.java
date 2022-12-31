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
import javax.servlet.ServletException;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AddToCartTest {
    
    private AddToCart servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;

    @Before
    public void setUp() throws Exception {
        servlet = new AddToCart();
        request = Mockito.mock(HttpServletRequest.class);
        response = Mockito.mock(HttpServletResponse.class);
        session = Mockito.mock(HttpSession.class);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // Set up test data
        int id = 123;
        int quantity = 1;
        ArrayList<Cart> cartList = new ArrayList<>();
        Cart item = new Cart();
        item.setId(id);
        item.setQuantity(quantity);
        cartList.add(item);

        // Set up mock objects
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        Mockito.when(response.getWriter()).thenReturn(printWriter);
        Mockito.when(request.getSession()).thenReturn(session);
        Mockito.when(session.getAttribute("cart-list")).thenReturn(cartList);

        // Call the doPost method
        servlet.doPost(request, response);

        // Verify that the servlet wrote the correct message to the response
        assertTrue(stringWriter.toString().contains("Song already exists in Cart. <a href = 'cart.jsp'>GO to cart</a>"));
    }}
