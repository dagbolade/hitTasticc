/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */

import com.assessment.hittasticc.model.Song;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TestClientSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search input: ");
        String searchInput = scanner.nextLine();
        ArrayList<Song> songs = new ArrayList<Song>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic", "root", "");
            String query = "SELECT * FROM songs WHERE artist LIKE ? OR title LIKE ?";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, "%" + searchInput + "%");
            pstmt.setString(2, "%" + searchInput + "%");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Song song = new Song();
                song.setId(rs.getInt("id"));
                song.setTitle(rs.getString("title"));
                song.setArtist(rs.getString("artist"));
                song.setAmount(rs.getDouble("amount"));
                song.setGenre(rs.getString("genre"));
                songs.add(song);
            }
            System.out.println("Expected music: " + songs);
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
