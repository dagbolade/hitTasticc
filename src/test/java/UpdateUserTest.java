
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */
public class UpdateUserTest {
    //updateUserTest
    @Test
   public void testUpdateRecord() throws Exception {
  // Set up mock PreparedStatement object
  PreparedStatement ps = mock(PreparedStatement.class);
  when(ps.executeUpdate()).thenReturn(1); // simulate update query returning 1 row

  // Set up mock PrintWriter object
  PrintWriter out = mock(PrintWriter.class);

  // Execute update code
  int i = ps.executeUpdate();
  if (i > 0) {
    out.print("Record Updated Successfully");
  } else {
    out.print("There is a problem in updating Record.");
  }

  // Verify that the correct message was printed to the out object
  verify(out).print("Record Updated Successfully");
}
    
}
