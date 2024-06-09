package com.example.finance.service;

import com.example.finance.model.Transaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ExpenseAnalyzerExtended {
    public static Map<String, Double> getTotalSpendingByCategory(List<Transaction> transactions) {
        return transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCategory, Collectors.summingDouble(Transaction::getAmount)));
    }
}
