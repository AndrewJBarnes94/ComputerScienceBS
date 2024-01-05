package PROGRAMMING_2.Discussion3;

import javax.swing.*;
import java.awt.*;

public class LayoutManager {
    public static void main(String[] args) {
        JFrame frame = new JFrame("LayoutManager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);

        JPanel panel = new JPanel(new BorderLayout());

        panel.add(new JButton("Up"), BorderLayout.NORTH);
        panel.add(new JButton("Down"), BorderLayout.SOUTH);
        panel.add(new JButton("Right"), BorderLayout.EAST);
        panel.add(new JButton("Left"), BorderLayout.WEST);
        panel.add(new JTextArea("Center"), BorderLayout.CENTER);

        frame.add(panel);
        frame.setVisible(true);
    }
}


