package com.github.alviannn.insorma.models;

import java.sql.Date;

public class Transaction {

    private final Product product;

    private final int quantity;
    private final long totalCost;
    private final Date transactionDate;

    public Transaction(Product product, int quantity, long totalCost, Date transactionDate) {
        this.product = product;
        this.quantity = quantity;
        this.totalCost = totalCost;
        this.transactionDate = transactionDate;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public long getTotalCost() {
        return totalCost;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

}
