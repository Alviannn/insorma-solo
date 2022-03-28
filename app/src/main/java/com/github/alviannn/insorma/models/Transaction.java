package com.github.alviannn.insorma.models;

import java.util.Date;

public class Transaction {

    private final Product product;

    private final int quantity;
    private final Date transactionDate;

    public Transaction(Product product, int quantity, Date transactionDate) {
        this.product = product;
        this.quantity = quantity;
        this.transactionDate = transactionDate;
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
