
import com.assessment.hittasticc.dao.OrderDao;
import com.assessment.hittasticc.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
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
public class ViewOrderTest {

    @Test
    public void testUserOrders() throws SQLException {
        // Create mock Connection
        Connection mockConnection = mock(Connection.class);

        // Create OrderDao instance
        OrderDao dao = new OrderDao(mockConnection);

        // Set up mock Connection
        PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
        when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

        // Set up mock PreparedStatement
        ResultSet mockResultSet = mock(ResultSet.class);
        when(mockPreparedStatement.executeQuery()).thenReturn(mockResultSet);

        // Set up mock ResultSet
        when(mockResultSet.next()).thenReturn(true).thenReturn(false); // return true for the first call to next() and false for the second

         
        
        // Call userOrders method
        List<Order> orders = dao.userOrders(1);

        
        // Assert that the correct List of Order objects is returned
        assertTrue(orders.isEmpty());
        
        
    }
}
