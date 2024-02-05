package com.cts.newsnest.authservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "AuthDetails")
public class User {

    @Id
    @Column(name = "email", length = 50)
    private String emailId;

    @Column(name = "password")
    private String password;

    public User() {
        super();
    }

    public User(String emailId, String password) {
        super();
        this.emailId = emailId;
        this.password = password;
    }


    public String getEmailId() {
        return emailId;
    }

    public void setId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
