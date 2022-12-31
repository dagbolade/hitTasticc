
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
public class AdminLoginTest {

    @Test
    public void testUserlogin_validCredentials_returnsAdminObject() throws SQLException, ClassNotFoundException {
        // Arrange
        String email = "test@example.com";
        String password = "password";

        // Act
        adminDao result = new adminDao(dbconn.getConnection());
        result.adminlogin(email, password);

        // Assert
        assertNotNull(result);
    }
    
    


}
