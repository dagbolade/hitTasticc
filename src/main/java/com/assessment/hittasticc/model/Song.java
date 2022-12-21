/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.assessment.hittasticc.model;

/**
 *
 * @author dagbo
 */
public class Song {
    private int id;
    private String title;
    private String artist;
    private Double amount;
    private String genre;
    
    public Song() {
	}

    public Song(int id, String title, String artist, Double amount, String genre) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.amount = amount;
        this.genre = genre;
        
    }
    

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString()
    {
        return "ID: " + id + " Title: " + title + " Artist: " + artist + " Genre: " + genre + " Amount: " + amount;
    }  


    
    
    
    
}
