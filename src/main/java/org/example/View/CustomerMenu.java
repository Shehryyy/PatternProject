package org.example.View;

import org.example.Model.ProductDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenu extends JFrame {
    private ProductDAO productDAO;

    public CustomerMenu() {
        this.productDAO = new ProductDAO();

        setTitle("Customer Menu");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JButton viewProductsButton = new JButton("View Products");
        JButton searchProductButton = new JButton("Search Product");
        JButton placeOrderButton = new JButton("Place an Order");

        add(viewProductsButton);
        add(searchProductButton);
        add(placeOrderButton);

        setVisible(true);

        viewProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(CustomerMenu.this, productDAO.getAllProducts());
            }
        });

        searchProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = JOptionPane.showInputDialog("Enter Product ID:");
                if (productId != null) {
                    JOptionPane.showMessageDialog(CustomerMenu.this, productDAO.getProductById(Integer.parseInt(productId)));
                }
            }
        });

        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(CustomerMenu.this, "Place order functionality coming soon!");
                new PlaceOrder();
            }
        });

        setLocationRelativeTo(null); // Center the frame
    }
}




