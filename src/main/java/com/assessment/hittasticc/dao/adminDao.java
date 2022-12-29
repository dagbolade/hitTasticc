/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.dao;

import com.assessment.hittasticc.model.admlgn;
import com.assessment.hittasticc.model.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dagbo
 */
public class adminDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;

    public adminDao(Connection con) {
        this.con = con;
    }

    public admlgn adminlogin(String email, String password) {
        admlgn admin = null;
        // use try catch handling to handle any errors
        try {
            //check if user exists in db
            query = "select * from admin where email=? and password=?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, email);
            pst.setString(2, password);
            rs = pst.executeQuery();
            
            //checks if the rs has a next result in db user table
            if(rs.next()){
                admin = new admlgn();
                admin.setId(rs.getInt("id"));
                admin.setEmail(rs.getNString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        return admin;

    }
    
    //retrieve all orders from the database and return it as a list
    public List<user> viewUsers(){
        List<user> list = new ArrayList();
        
        try{
            query = "select * from user";
            pst = this.con.prepareStatement(query);
            
            rs = pst.executeQuery();
            
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
