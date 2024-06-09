package com.example.finance.service;

import com.example.finance.model.Transaction;

import java.util.List;

public class BalanceCalculator {
    public static double calculateTotalBalance(List<Transaction> transactions) {
        return transactions.stream().mapToDouble(Transaction::getAmount).sum();
    }
}
