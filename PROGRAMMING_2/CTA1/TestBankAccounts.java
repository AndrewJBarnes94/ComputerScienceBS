package PROGRAMMING_2.CTA1;

public class TestBankAccounts {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount("Andrew", "Barnes", 1);
        myAccount.deposit(2000);
        myAccount.withdrawal(1100);
        myAccount.accountSummary();

        System.out.println("");

        CheckingAccount checkingAccountExample = new CheckingAccount("John", "Doe", 2, 1.5);
        checkingAccountExample.deposit(5000);
        checkingAccountExample.withdrawal(5001);
        checkingAccountExample.displayAccount();

        System.out.println("");

        // Test bank account getters and setters
        myAccount.setFirstName("AJ");
        myAccount.setLastName("BARNES");
        myAccount.setAccountID(13);

        System.out.println("Bank Account");

        System.out.println("New First Name: " + myAccount.getFirstName());
        System.out.println("New Last Name: " + myAccount.getLastName());
        System.out.println("New Account ID: " + myAccount.getAccountID());

        System.out.println("");

        // Test checking account getters and setters   
        checkingAccountExample.setFirstName("Jon");
        checkingAccountExample.setLastName("Doer");
        checkingAccountExample.setAccountID(5);
        checkingAccountExample.setInterestRate(3.3);

        System.out.println("Checking Account");
        
        System.out.println("New First Name: " + checkingAccountExample.getFirstName());
        System.out.println("New Last Name: " + checkingAccountExample.getLastName());
        System.out.println("New Account ID: " + checkingAccountExample.getAccountID());
        System.out.println("New Interest Rate: " + checkingAccountExample.getInterestRate() + "%");

    }
}
