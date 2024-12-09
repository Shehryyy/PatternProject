package org.example.View;

import org.example.Controller.AddProductDialog;
import org.example.Controller.ViewOrders;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMenu extends JFrame {
    public ManagerMenu() {
        setTitle("Manager Menu");
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton viewOrdersButton = new JButton("View Orders");
        JButton addProductButton = new JButton("Add New Products");

        add(viewOrdersButton);
        add(addProductButton);


        viewOrdersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(ManagerMenu.this, "View orders functionality coming soon!")
                new ViewOrders();
            }
        });

        addProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddProductDialog(ManagerMenu.this).setVisible(true);
            }
        });

        setLocationRelativeTo(null); // Center the frame
    }
}





