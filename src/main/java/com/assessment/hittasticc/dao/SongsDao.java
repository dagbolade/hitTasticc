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
import java.sql.SQLException;
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
     public List<Song> searchMusic(String search) {
         List<Song> songList = new ArrayList<>();
        try{
            String query = "SELECT * FROM songs WHERE title LIKE ? OR artist LIKE ?";
            pst = this.con.prepareStatement(query);
            pst.setString(1, search);
            pst.setString(2, search);
            rs = pst.executeQuery();
             
            
            while(rs.next()){
                Song find = new Song();
                find.setArtist(rs.getString("artist"));
                find.setGenre(rs.getString("genre"));
                find.setTitle(rs.getString("title"));
                find.setAmount(rs.getDouble("amount"));
                songList.add(find);
            }
             
        }catch(Exception e){
             e.printStackTrace();
        }
        return songList;
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
    
    public Song getSingleSong(int id){
        Song hit = null;
        
        try{
            query = "Select * from songs where id=?";
            pst = this.con.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            
            while(rs.next()){
                hit = new Song();
                hit.setId(rs.getInt("id"));
                hit.setArtist(rs.getString("artist"));
                hit.setGenre(rs.getString("genre"));
                hit.setAmount(rs.getDouble("amount"));
                hit.setTitle(rs.getString("title"));
            }
        
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return hit;
    }
    
    //Calculate Total Amount
    public double getTotalAmount(ArrayList<Cart> cartList){
        double total = 0;
        try{
            //check if cart list is not empty
            if(cartList.size()>0){
                // Iterate over the cartList
                for (Cart item : cartList) {
                    query = "select amount from songs where id=?";
                     // Create a Prepared Statement
                    pst = this.con.prepareStatement(query);
                     // Set the value for the id parameter
                    pst.setInt(1, item.getId());
                    // Execute the query
                    rs = pst.executeQuery();
                    
                     // Add the amount value to the total 
                     while(rs.next()){
                         total += rs.getDouble("amount")*item.getQuantity();
                     }

                }
            }
            
        
        }catch(Exception e){
            e.printStackTrace();
        }
        return total;
    }

}
