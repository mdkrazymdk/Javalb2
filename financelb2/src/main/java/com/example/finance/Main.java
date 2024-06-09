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
        String filePath = "src/main/resources/transactions.csv"; // Укажите путь к вашему CSV-файлу.
        CSVReader csvReader = new CSVReader();
        List<Transaction> transactions = csvReader.readTransactions(filePath); // Считываем транзакции из CSV-файла, возвращаем список объектов Transaction.

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); // Определяем формат даты для последующего анализа.

        double totalBalance = BalanceCalculator.calculateTotalBalance(transactions); // Рассчитываем общий баланс по всем транзакциям.
        System.out.println("Загальний баланс: " + totalBalance);

        int month = 7; // Пример: липень
        int year = 2023; // Пример: 2023 рік
        long transactionCount = TransactionCounter.countTransactionsByMonth(transactions, month, year); // Считаем количество транзакций за указанный месяц и год.
        System.out.println("Кількість транзакцій за " + month + "/" + year + ": " + transactionCount);

        List<Transaction> topExpenses = ExpenseAnalyzer.getTop10Expenses(transactions); // Получаем список транзакций с наибольшими расходами.
        System.out.println("Топ 10 витрат:");
        topExpenses.forEach(transaction -> System.out.println(transaction.getCategory() + ": " + transaction.getAmount()));

        Map<String, Double> spendingByCategory = ExpenseAnalyzerExtended.getTotalSpendingByCategory(transactions); // Анализируем расходы по категориям.
        System.out.println("Витрати за категоріями:");
        spendingByCategory.forEach((category, amount) -> System.out.println(category + ": " + amount));
    }
}
