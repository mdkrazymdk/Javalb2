package com.example.finance;

import com.example.finance.csv.CSVReader;
import com.example.finance.model.Transaction;
import com.example.finance.service.BalanceCalculator;
import com.example.finance.service.ExpenseAnalyzer;
import com.example.finance.service.ExpenseAnalyzerExtended;
import com.example.finance.service.TransactionCounter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/resources/transactions.csv"; // путь к  CSV-файлу.
        CSVReader csvReader = new CSVReader();
        List<Transaction> transactions = csvReader.readTransactions(filePath); // Считываем транзакции из CSV-файла, возвращаем список Transaction.

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Определяем дату.

        double totalBalance = BalanceCalculator.calculateTotalBalance(transactions); // Общий баланс 
        System.out.println("Загальний баланс: " + totalBalance);

        int month = 7; 
        int year = 2023; 
        long transactionCount = TransactionCounter.countTransactionsByMonth(transactions, month, year); // Количество транзакций за указанный месяц и год.
        System.out.println("Кількість транзакцій за " + month + "/" + year + ": " + transactionCount);

        List<Transaction> topExpenses = ExpenseAnalyzer.getTop10Expenses(transactions); //Наибольшими расходами.
        System.out.println("Топ 10 витрат:");
        topExpenses.forEach(transaction -> System.out.println(transaction.getCategory() + ": " + transaction.getAmount()));

        Map<String, Double> spendingByCategory = ExpenseAnalyzerExtended.getTotalSpendingByCategory(transactions); // Расходы по категориям.
        System.out.println("Витрати за категоріями:");
        spendingByCategory.forEach((category, amount) -> System.out.println(category + ": " + amount));
    }
}
