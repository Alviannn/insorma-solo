package com.github.alviannn.insorma.models;

public class Product {

    private final int imageId;
    private final String name;
    private final int price;
    private final double rating;

    public Product(int imageId, String name, int price, double rating) {
        this.imageId = imageId;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getImageId() {
        return imageId;
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
