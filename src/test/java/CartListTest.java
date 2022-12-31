
import com.assessment.hittasticc.model.Cart;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
//This code retrieves the attribute called "cart-list" from the current session. 
//"cart-list" is expected to be an ArrayList of Cart objects. If it exists, it is stored in the variable "cart_list" 
//and set as an attribute of the request object.
public class CartListTest {
     @Test
    public void testCartList() {
        // create a mock HttpSession object
        HttpSession session = mock(HttpSession.class);
        
        // create a mock ArrayList of Cart objects
        ArrayList<Cart> mockCartList = mock(ArrayList.class);
        
        // set the mock ArrayList as the value of the "cart-list" attribute in the mock HttpSession object
        when(session.getAttribute("cart-list")).thenReturn(mockCartList);
        
        // create a mock HttpServletRequest object
        HttpServletRequest request = mock(HttpServletRequest.class);
        
        // set the mock HttpSession object as the value of the "session" attribute in the mock HttpServletRequest object
        when(request.getSession()).thenReturn(session);
        
        // test the code snippet
        ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
        if(cart_list != null){
            request.setAttribute("cart_list", cart_list);
        }
        
        // verify that the "cart_list" attribute was set in the mock HttpServletRequest object
        verify(request).setAttribute("cart_list", mockCartList);
    }
}
