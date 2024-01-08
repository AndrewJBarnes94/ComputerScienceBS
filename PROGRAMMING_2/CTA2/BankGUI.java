package PROGRAMMING_2.CTA2;

import javax.swing.*;
import java.awt.event.*;

public class BankGUI extends JFrame{
    // Create private data fields for account functionality
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton, withdrawButton;
    
    public BankGUI() { s
        account = new BankAccount(0);
        JPanel panel = new JPanel();
        
        // Swing components that will live in the JPanel
        balanceLabel = new JLabel("Balance: $0.0");
        amountField = new JTextField(10);
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");

        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.deposit(amount);
                updateBalance();
            }
        });
        
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                account.withdraw(amount);
                updateBalance();
            }
        });

        // Add all GUI components to the panel
        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);

        // Add the panel to frame
        this.add(panel);

        // Configure the frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Bank GUI");
        this.setSize(500, 200);
        this.setVisible(true);
    }

    private void updateBalance() {
        balanceLabel.setText("Balance: $" + account.getBalance());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new BankGUI();
            }
        });
    }
}
