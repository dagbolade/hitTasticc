/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.assessment.hittasticc.dao.*;

import org.junit.*;
import org.junit.*;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.anyString;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RemoveUserTest {

    @Mock
    private Connection con;

    @Mock
    private PreparedStatement pst;

    @Mock
    private ResultSet rs;

    private adminDao admin;

    @Before
    public void setUp() {
        admin = new adminDao(con);
    }
    //Remove user from database test works
    @Test
    public void testRemoveUser_existingUser_removesUser() throws SQLException {
        // Set up mock objects and data
    Connection con = mock(Connection.class);
    PreparedStatement pst = mock(PreparedStatement.class);
    adminDao dao = new adminDao(con);
    int id = 1;

    // Set up mock behavior
    when(con.prepareStatement(anyString())).thenReturn(pst);

    // Call the RemoveUser method
    dao.RemoveUser(id);

    // Verify that the correct SQL statement is executed
    verify(pst).setInt(1, id);
    verify(pst).execute();
}
}

