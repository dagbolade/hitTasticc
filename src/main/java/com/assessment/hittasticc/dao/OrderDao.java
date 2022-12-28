/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.dao;

import com.assessment.hittasticc.model.Order;
import com.assessment.hittasticc.model.Song;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
        query = "insert into orders(song_id,user_id,quantity,Date) values(?,?,?,?)";
        try{
            
            
            pst = this.con.prepareStatement(query);
            pst.setInt(1, model.getId());
            pst.setInt(2, model.getUid());
            pst.setInt(3, model.getQty());
            pst.setString(4, model.getDate());
            pst.executeUpdate();
            result = true;
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return result;
    }
    
    //retrieve all orders from the database and return it as a list
    public List<Order> userOrders(int id){
        List<Order> list = new ArrayList();
        
        try{
            query = "select * from orders where user_id=? order by orders.order_id desc";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                Order history =new Order();
                SongsDao music = new SongsDao(this.con);
                int sId = rs.getInt("song_id");
                
                Song song = music.getSingleSong(sId);
                history.setOrderId(rs.getInt("order_id"));
                history.setId(sId);
                history.setArtist(song.getArtist());
                history.setGenre(song.getGenre());
                history.setTitle(song.getTitle());
                history.setAmount(song.getAmount() * rs.getInt("quantity"));
                history.setQty(rs.getInt("quantity"));
                history.setDate(rs.getString("Date"));
                
                //add the history to the list
                list.add(history);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return list;
    }
}
