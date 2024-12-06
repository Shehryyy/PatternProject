package org.example.View;

import org.example.Model.AuthenticationService;
import org.example.Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerLoginDialog extends JDialog {
    public CustomerLoginDialog(JFrame parent) {
        super(parent, "Customer Login", true);

        setLayout(new GridLayout(4, 2, 10, 10));

        JLabel usernameLabel = new JLabel("Username:");
        JTextField usernameField = new JTextField();

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton registerButton = new JButton("Register");

        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(registerButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Call login method which now returns boolean
                boolean success = AuthenticationService.login(username, password);

                if (success) {
                    JOptionPane.showMessageDialog(CustomerLoginDialog.this, "Login Successful!");
                    dispose();
                    new CustomerMenu(); // Open the Customer Menu
                } else {
                    JOptionPane.showMessageDialog(CustomerLoginDialog.this, "Invalid Username or Password");
                }
            }
        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean success = AuthenticationService.register();
                if (success) {
                    JOptionPane.showMessageDialog(CustomerLoginDialog.this, "Registration Successful!");
                } else {
                    JOptionPane.showMessageDialog(CustomerLoginDialog.this, "Registration Failed. Username Already Exists.");
                }
            }
        });

        setSize(400, 200);
        setLocationRelativeTo(parent);
        setVisible(true);
    }
}



