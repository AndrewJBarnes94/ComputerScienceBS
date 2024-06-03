package PROGRAMMING_3.Discussion7;

import java.util.List;
import java.util.ArrayList;

class Transaction {
    private String type; // "deposit" or "withdrawal"
    private double amount;

    public Transaction(String type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}

class BankingApp {
    public static void main(String[] args) {
        // Creating a list of transactions
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("deposit", 100.0));
        transactions.add(new Transaction("withdrawal", 50.0));
        transactions.add(new Transaction("deposit", 200.0));
        transactions.add(new Transaction("withdrawal", 30.0));

        // Using scope minimization and encapsulating logic within methods
        System.out.println("Total Deposits: " + calculateTotal(transactions, "deposit"));
        System.out.println("Total Withdrawals: " + calculateTotal(transactions, "withdrawal"));
    }

    private static double calculateTotal(List<Transaction> transactions, String type) {
        double total = 0.0;
        for (Transaction transaction : transactions) {
            if (transaction.getType().equals(type)) {
                total += transaction.getAmount();
            }
        }
        return total;
    }
}
