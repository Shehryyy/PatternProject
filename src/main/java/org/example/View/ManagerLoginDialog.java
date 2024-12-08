package org.example.View;

import org.example.Model.AuthenticationService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerLoginDialog extends JDialog {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private AuthenticationService authenticationService;

    public ManagerLoginDialog() {
        this.authenticationService = new AuthenticationService();

        setTitle("Manager Login");
        setSize(400, 200);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setModal(true);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username:"));
        usernameField = new JTextField(20);
        usernamePanel.add(usernameField);
        add(usernamePanel);

        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField(20);
        passwordPanel.add(passwordField);
        add(passwordPanel);

        JButton loginButton = new JButton("Log In");
        add(loginButton);

        statusLabel = new JLabel("Enter your credentials.", SwingConstants.CENTER);
        add(statusLabel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });

        setLocationRelativeTo(null); // Center the dialog
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        // Call login method which now returns boolean
        boolean success = AuthenticationService.managerLogin(username, password);

        if (success) {
            statusLabel.setText("Login successful!");
            dispose(); // Close the dialog
            new ManagerMenu().setVisible(true); // Redirect to manager menu
        } else {
            statusLabel.setText("Invalid username or password!");
        }
    }

}






