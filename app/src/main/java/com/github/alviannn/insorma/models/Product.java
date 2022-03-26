package com.github.alviannn.insorma.models;

public class Product {

    private final String name;
    private final int price;
    private final double rating;

    public Product(String name, int price, double rating) {
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

}
