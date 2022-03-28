package com.github.alviannn.insorma.models;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String email;
    private String username;
    private final String phone;
    private final String password;

    private final List<Transaction> transactions;

    public User(String email, String username, String phone, String password) {
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
        this.transactions = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

}
