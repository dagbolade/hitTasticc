/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import static org.mockito.Mockito.*;
/**
 *
 * @author dagbo
 */
public class ViewUserTest {
    @Test
    //viewUsers test passed
    public void testViewUsers_returnsListOfUsers() throws Exception {
        // Set up mock objects
        Connection con = mock(Connection.class);
        PreparedStatement pst = mock(PreparedStatement.class);
        ResultSet rs = mock(ResultSet.class);
        
        // Set up mock behavior
        when(con.prepareStatement(anyString())).thenReturn(pst);
        when(pst.executeQuery()).thenReturn(rs);
        when(rs.next()).thenReturn(true, true, false);
        when(rs.getInt("id")).thenReturn(1, 2);
        when(rs.getString("email")).thenReturn("user1@example.com", "user2@example.com");
        when(rs.getString("name")).thenReturn("User 1", "User 2");
        
        // Create UserDao object and call viewUsers method
        adminDao dao = new adminDao(con);
        List<user> users = dao.viewUsers();
        
        // Verify that the correct number of users are returned
        assertEquals(2, users.size());
        
        // Verify that the first user is correctly set up
        user user1 = users.get(0);
        assertEquals(1, user1.getId());
        assertEquals("user1@example.com", user1.getEmail());
        assertEquals("User 1", user1.getName());
        // Verify that the second user is correctly set up
        user user2 = users.get(1);
        assertEquals(2, user2.getId());
        assertEquals("user2@example.com", user2.getEmail());
        assertEquals("User 2", user2.getName());
    }
    
}
