package com.example.finance.test;

import com.example.finance.model.Transaction;
import com.example.finance.service.BalanceCalculator;
import com.example.finance.service.ExpenseAnalyzer;
import com.example.finance.service.ExpenseAnalyzerExtended;
import com.example.finance.service.TransactionCounter;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FinancialAnalyzerTest {
    @Test
    void testCalculateTotalBalance() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-01-01", "Food", 100),
                new Transaction("2023-01-02", "Utilities", 200)
        );
        double balance = BalanceCalculator.calculateTotalBalance(transactions);
        assertEquals(300, balance);
        System.out.println("testCalculateTotalBalance: expected=300, actual=" + balance);
    }

    @Test
    void testCountTransactionsByMonth() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-01-01", "Food", 100),
                new Transaction("2023-01-02", "Utilities", 200),
                new Transaction("2023-02-01", "Transport", 50)
        );
        long count = TransactionCounter.countTransactionsByMonth(transactions, 1, 2023);
        assertEquals(2, count);
        System.out.println("testCountTransactionsByMonth: expected=2, actual=" + count);
    }

    @Test
    void testGetTop10Expenses() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-01-01", "Food", 100),
                new Transaction("2023-01-02", "Utilities", 200),
                new Transaction("2023-01-03", "Entertainment", 300)
        );
        List<Transaction> topExpenses = ExpenseAnalyzer.getTop10Expenses(transactions);
        assertEquals(3, topExpenses.size());
        assertEquals(300, topExpenses.get(0).getAmount());
        System.out.println("testGetTop10Expenses: expectedSize=3, actualSize=" + topExpenses.size() + ", expectedTopAmount=300, actualTopAmount=" + topExpenses.get(0).getAmount());
    }

    @Test
    void testAnalyzeSpendingByCategory() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction("2023-01-01", "Food", 100),
                new Transaction("2023-01-02", "Food", 200),
                new Transaction("2023-01-03", "Utilities", 300)
        );
        Map<String, Double> spendingByCategory = ExpenseAnalyzerExtended.getTotalSpendingByCategory(transactions);
        assertEquals(2, spendingByCategory.size());
        assertEquals(300, spendingByCategory.get("Food"));
        System.out.println("testAnalyzeSpendingByCategory: expectedCategories=2, actualCategories=" + spendingByCategory.size() + ", expectedFoodAmount=300, actualFoodAmount=" + spendingByCategory.get("Food"));
    }
}
