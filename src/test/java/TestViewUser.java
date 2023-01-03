/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dagbo
 */

import com.assessment.hittasticc.model.user;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestViewUser {
    public static void main(String[] args) {
        TestViewUser testClient = new TestViewUser();
        List<user> users = testClient.viewUsers();
        for (user user : users) {
            System.out.println(user.getId() + " " + user.getEmail() + " " + user.getName());
        }
    }

    public List<user> viewUsers(){
        List<user> list = new ArrayList();

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hittastic", "root", "");
            String query = "select * from user";
            PreparedStatement pst = con.prepareStatement(query);

            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                user history =new user();
                history.setId(rs.getInt("id"));
                history.setEmail(rs.getString("email"));
                history.setName(rs.getString("name"));

                //add the history to the list
                list.add(history);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
