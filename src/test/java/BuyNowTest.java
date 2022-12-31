
import com.assessment.hittasticc.dao.OrderDao;
import com.assessment.hittasticc.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.anyString;
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
public class BuyNowTest {
    @Test
void testInsertOrder() throws SQLException {
    // Create mock Connection
    Connection mockConnection = mock(Connection.class);

    // Create OrderDao instance
    OrderDao dao = new OrderDao(mockConnection);

    // Set up mock Connection
    PreparedStatement mockPreparedStatement = mock(PreparedStatement.class);
    when(mockConnection.prepareStatement(anyString())).thenReturn(mockPreparedStatement);

    // Set up mock PreparedStatement
    when(mockPreparedStatement.executeUpdate()).thenReturn(1);

    // Create sample Order object
    Order order = new Order();
    order.setId(1);
    order.setUid(2);
    order.setQty(3);
    order.setDate("2022-12-31");

    // Call insertOrder method
    boolean result = dao.insertOrder(order);

    // Assert that the correct value is returned
    assertTrue(result);

    // Verify that Connection's prepareStatement method was called
    verify(mockConnection).prepareStatement(anyString());

    // Verify that PreparedStatement's executeUpdate method was called
    verify(mockPreparedStatement).executeUpdate();
}

    
}
