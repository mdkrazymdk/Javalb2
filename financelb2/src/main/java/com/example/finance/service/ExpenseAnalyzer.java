package com.example.finance.service;

import com.example.finance.model.Transaction;
import java.util.List;
import java.util.stream.Collectors;

public class ExpenseAnalyzer {
    public static List<Transaction> getTop10Expenses(List<Transaction> transactions) {
        return transactions.stream()
                .sorted((t1, t2) -> Double.compare(t2.getAmount(), t1.getAmount()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
