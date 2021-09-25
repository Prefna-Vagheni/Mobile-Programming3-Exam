package com.example.payzug;

public class Product {
    private int id;
    private String name;
    private String username;
    private String password;
    private String date;

    public Product(int id, String name, String username, String password, String date) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDate() {
        return date;
    }

}
