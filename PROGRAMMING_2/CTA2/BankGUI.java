package PROGRAMMING_2.CTA2;

import javax.swing.*;
import java.awt.event.*;

public class BankGUI extends JFrame{
    private BankAccount account;
    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton depositButton, withdrawButton;
    
    public BankGUI() {
        account = new BankAccount(0);
        JPanel panel = new JPanel();
        
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

        panel.add(balanceLabel);
        panel.add(amountField);
        panel.add(depositButton);
        panel.add(withdrawButton);

        this.add(panel);

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
