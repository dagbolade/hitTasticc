/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */
import java.sql.*;
import java.util.Scanner;

public class TestClientAddSong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter title: ");
        String title = scanner.nextLine();
        System.out.println("Enter artist: ");
        String artist = scanner.nextLine();
        System.out.println("Enter amount: ");
        String amount = scanner.nextLine();
        System.out.println("Enter genre: ");
        String genre = scanner.nextLine();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic","root","");
            Statement st = conn.createStatement();
            int i = st.executeUpdate("insert into songs(title, artist, amount, genre) values('"+title+"','"+artist+"','"+amount+"','"+genre+"')");
            System.out.println("Data is successfully inserted!");
        } catch (Exception e) {
            System.out.print(e);
            e.printStackTrace();
        }
    }
}
