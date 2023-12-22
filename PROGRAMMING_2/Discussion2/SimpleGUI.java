package PROGRAMMING_2.Discussion2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SimpleGUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(250,250);

        JButton helloBtn = new JButton("Hello");
        JButton worldBtn  = new JButton("World");

        JPanel panel = new JPanel();
        panel.add(helloBtn);
        panel.add(worldBtn);

        helloBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Hello");
            }
        });

        worldBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "World");
            }
        });

        frame.add(panel);

        frame.setVisible(true);
    }
}
