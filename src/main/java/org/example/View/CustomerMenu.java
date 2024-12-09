package org.example.View;

import org.example.Controller.PlaceOrder;
import org.example.Model.Product;
import org.example.Model.ProductDAO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CustomerMenu extends JFrame {
    private ProductDAO productDAO;

    private List<String> productList = new ArrayList<>();

    private List<String> getProductList() {
        for (Product product : productDAO.getAllProducts()) {
            productList.add(product.getDetails() + "\n");
        }
        return productList;
    }

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
                JOptionPane.showMessageDialog(CustomerMenu.this, getProductList().toString());
            }
        });

        searchProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String productId = JOptionPane.showInputDialog("Enter Product ID:");
                if (productId != null) {
                    JOptionPane.showMessageDialog(CustomerMenu.this, productDAO.getProductById(Integer.parseInt(productId)).getDetails());
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




