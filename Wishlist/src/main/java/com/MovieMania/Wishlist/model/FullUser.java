package com.MovieMania.Wishlist.model;

//import jakarta.persistence.*;
//import jakarta.validation.constraints.*;


public class FullUser {

    private int id;
   private String username;
    private String emailId;
    private String password;

    public FullUser(){
    }

    public FullUser(int id, String username, String emailId, String password) {
        this.id = id;
        this.username = username;
        this.emailId = emailId;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
