package com.github.alviannn.insorma.models;

import java.util.Date;

public class Transaction {

    /**
     * Tracker for the transaction ID,
     * it starts at {@code 1} and it will increment automatically as the object gets instantiated.
     */
    private static int GENERATED_ID = 0;

    private final int id;
    private final Product product;
    private final int quantity;
    private final Date transactionDate;

    public Transaction(Product product, int quantity, Date transactionDate) {
        this.id = ++GENERATED_ID;
        this.product = product;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

}
