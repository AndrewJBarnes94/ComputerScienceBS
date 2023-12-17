package PROGRAMMING_2.CTA1;

public class CheckingAccount extends BankAccount{
    private double interestRate;

    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    @Override
    public double withdrawal(double amount) {
        if (getBalance() >= amount) {
            super.withdrawal(amount);
        } else {
            super.withdrawal(amount + 30); // Overdraft fee of $30
            processWithdrawal();
        }
        
        return getBalance();
    }

    public void processWithdrawal() {
        System.out.println("Your balance is below 0. A $30 processing fee has been charged.");
    }

    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}
