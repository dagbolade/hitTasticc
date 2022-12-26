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
public class Order extends Song{
    private int orderId;
    private int uid;
    private int qty;
    private String date;
    
    
    public Order(){}

    public Order(int orderId, int uid, int qty, String date) {
        this.orderId = orderId;
        this.uid = uid;
        this.qty = qty;
        this.date = date;
    }
    public Order(int uid, int qty,String date) {
        this.uid = uid;
        this.qty = qty;
        this.date = date;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    

    @Override
    public String toString() {
        return "Order: orderId: " + orderId + " quantity: " + qty + "uid: " + uid + "Date: "+ date;
    }
    
    
    
}
