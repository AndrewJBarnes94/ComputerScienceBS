package PROGRAMMING_2.CTA2;

public class BankAccount {
    private double balance;

    public BankAccount(double startBalance) {
        balance = startBalance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}
