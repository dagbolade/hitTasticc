/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.dao;

import com.assessment.hittasticc.model.Cart;
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
public class SongsDao {
    private Connection con;
    private String query;
    private PreparedStatement pst;
    private ResultSet rs;
    
    //creating a constructor

    public SongsDao(Connection con) {
        this.con = con;
    }
    public List<Song> getAllSongs(){
        List<Song> allsongs = new ArrayList<Song>();
        
        try {
            query = "select * from songs";
            pst = this.con.prepareStatement(query);
            rs = pst.executeQuery();
            //check if there is any values in the rs variable
            while(rs.next()){
                Song row = new Song();
                row.setId(rs.getInt("id"));
                row.setArtist(rs.getString("artist"));
                row.setAmount(rs.getDouble("amount"));
                row.setGenre(rs.getString("genre"));
                row.setTitle(rs.getString("title"));
                
                allsongs.add(row);
                
                
                
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return allsongs;
    }
    
    //Return cart items from list
    public List<Cart> getCartSongs(ArrayList<Cart> cartList){
        List<Cart> songs = new ArrayList<Cart>();
        
        try{
            if(cartList.size()>0){
                for(Cart item:cartList){
                    query = "select * from songs where id=?";
                    pst = this.con.prepareStatement(query);
                    pst.setInt(1, item.getId());
                    rs = pst.executeQuery();
                    while(rs.next()){
                        Cart row = new Cart();
                        row.setId(rs.getInt("id"));
                        row.setArtist(rs.getString("artist"));
                        row.setAmount(rs.getDouble("amount")*item.getQuantity());
                        row.setGenre(rs.getString("genre"));
                        row.setTitle(rs.getString("title"));
                        row.setQuantity(item.getQuantity());
                        
                        songs.add(row);
                        
                    }
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        
        return songs;
    }
    

}
