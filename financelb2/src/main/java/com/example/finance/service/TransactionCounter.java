package com.example.finance.service;

import com.example.finance.model.Transaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionCounter {
    public static long countTransactionsByMonth(List<Transaction> transactions, int month, int year) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return transactions.stream()
                .filter(t -> {
                    LocalDate date = LocalDate.parse(t.getDate(), formatter);
                    return date.getMonthValue() == month && date.getYear() == year;
                })
                .count();
    }
}
