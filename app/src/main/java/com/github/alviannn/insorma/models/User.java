package com.github.alviannn.insorma.models;

public class User {

    private final String email;
    private String username;
    private final String phone;
    private final String password;

    public User(String email, String username, String phone, String password) {
        this.email = email;
        this.username = username;
        this.phone = phone;
        this.password = password;
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

}
