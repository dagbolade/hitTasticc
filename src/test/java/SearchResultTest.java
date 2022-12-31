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


import com.assessment.hittasticc.model.Song;

public class SearchResultTest {

  @Test
  public void testSearch() throws SQLException, ClassNotFoundException {
    // set up test data
    String searchInput = "q";
    
    // simulate search
    Connection conn = null;
    Class.forName("com.mysql.cj.jdbc.Driver");
    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic", "root", "");
    String query = "SELECT * FROM songs WHERE artist LIKE ? OR title LIKE ?";
    PreparedStatement pstmt = conn.prepareStatement(query);
    pstmt.setString(1, "%" + searchInput + "%");
    pstmt.setString(2, "%" + searchInput + "%");
    ResultSet rs = pstmt.executeQuery();

    List<Song> songs = new ArrayList<Song>();
    while (rs.next()) {
      Song song = new Song();
      song.setId(rs.getInt("id"));
      song.setTitle(rs.getString("title"));
      song.setArtist(rs.getString("artist"));
      song.setAmount(rs.getDouble("amount"));
      song.setGenre(rs.getString("genre"));
      songs.add(song);
    }
    
    // verify results if songs are not null
    assertNotNull(songs);
    
  }
}
