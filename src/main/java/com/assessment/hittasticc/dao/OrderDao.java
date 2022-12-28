/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.dao;

import com.assessment.hittasticc.model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author dagbo
 */
public class OrderDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    
    public OrderDao(Connection con){
        this.con = con;
    }
    
    public boolean insertOrder(Order model){
        boolean result = false;
        query = "insert into orders(song_id,user_id,quantity) values(?,?,?)";
        try{
            
            
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQty());
            
            pst.executeUpdate();
            result = true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
}
