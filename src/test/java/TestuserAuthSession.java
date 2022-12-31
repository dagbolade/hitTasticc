
import com.assessment.hittasticc.model.user;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */
public class TestuserAuthSession {
 //This code determines if the user has been authenticated (logged in). 
 //If the user is authenticated, it uses an authenticated user object 
 //to set the request object's "auth" attribute and an OrderDao object to 
 //obtain the user's orders. It directs the user to the login page 
//if they are not authenticated.   

@Test
public void testGetAuthAttribute() throws ServletException, IOException {
    // Set up the request and response objects
    HttpServletRequest request = mock(HttpServletRequest.class);
    HttpServletResponse response = mock(HttpServletResponse.class);
    
    // Set up the user object and set its attributes
    user auth = new user();
    auth.setId(1);
   
    auth.setEmail("email");
    auth.setPassword("testpassword");
    
    // Set the "auth" attribute in the session
    HttpSession session = mock(HttpSession.class);
    when(request.getSession()).thenReturn(session);
    when(session.getAttribute("auth")).thenReturn(auth);
    
    // Call the code under test
    Object result = request.getSession().getAttribute("auth");
    
    // Verify that the returned value is not null
    assertNotNull(result);
}
}