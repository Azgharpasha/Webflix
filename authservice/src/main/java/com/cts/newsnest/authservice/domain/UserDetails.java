package com.cts.newsnest.authservice.domain;




public class UserDetails {


    private Long id;


    private String username;

    private String password;


    private String emailId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmailId(String emailId){ this.emailId = emailId;}

    public String getEmailId(){ return emailId; }




}
