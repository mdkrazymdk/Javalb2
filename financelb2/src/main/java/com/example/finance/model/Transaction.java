package com.example.finance.model;

public class Transaction {
    private String date;
    private String category;
    private double amount;

    public Transaction(String date, String category, double amount) {
        this.date = date;
        this.category = category;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
