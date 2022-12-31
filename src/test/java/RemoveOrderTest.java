
import com.assessment.hittasticc.connection.dbconn;
import com.assessment.hittasticc.dao.OrderDao;
import com.assessment.hittasticc.dao.adminDao;
import com.assessment.hittasticc.server.RemoveOrder;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.doNothing;
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

//remove order from the list passed
public class RemoveOrderTest {
    @Test
public void testRemoveOrder() throws Exception {
   // Set up mock objects and data
        Connection con = mock(Connection.class);
        PreparedStatement pst = mock(PreparedStatement.class);
        OrderDao dao = new OrderDao(con);
        int id = 1;

        // Set up mock behavior
        when(con.prepareStatement(anyString())).thenReturn(pst);

        // Call the RemoveUser method
        dao.RemoveOrder(id);

        // Verify that the correct SQL statement is executed
        verify(pst).setInt(1, id);
        verify(pst).execute();
}
}
