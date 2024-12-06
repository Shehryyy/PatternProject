package org.example.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    public MainMenu() {
        setTitle("Product Management System");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel titleLabel = new JLabel("Welcome to Product Management System", SwingConstants.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(16f));
        add(titleLabel);

        JPanel buttonPanel = new JPanel();
        JButton managerButton = new JButton("Manager");
        JButton customerButton = new JButton("Customer");
        buttonPanel.add(managerButton);
        buttonPanel.add(customerButton);
        add(buttonPanel);

        managerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ManagerLoginDialog().setVisible(true);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CustomerLoginDialog(MainMenu.this).setVisible(true);
            }
        });

        setLocationRelativeTo(null);
    }
}
