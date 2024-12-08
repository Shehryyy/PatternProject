package org.example.View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerMenu extends JFrame {
    public ManagerMenu() {
        setTitle("Manager Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton salesReportButton = new JButton("Check Sales Report");
        JButton viewOrdersButton = new JButton("View Orders");
        JButton addProductButton = new JButton("Add New Products");

        add(salesReportButton);
        add(viewOrdersButton);
        add(addProductButton);

        salesReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(ManagerMenu.this, "Sales report functionality coming soon!");
                //TODO : add what does saleReportButton does

            }
        });

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





