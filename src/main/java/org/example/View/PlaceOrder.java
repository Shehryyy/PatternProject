package org.example.View;

import Util.DataBaseUtil;
import org.example.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

import org.example.*;
import org.example.Model.Product;

public class PlaceOrder extends JFrame {
    private JTable productTable;
    private JButton orderButton;

    public PlaceOrder() {
        setTitle("Place Order");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        List<Product> products = DataBaseUtil.getAllProducts();


        String[] columnNames = {"ID", "Type", "Price", "Quantity"};
        Object[][] data = new Object[products.size()][4];


        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            data[i][0] = product.getProductID();
            data[i][1] = product.getClass().getSimpleName();
            data[i][2] = product.getPrice();
            data[i][3] = product.getQuantity();
        }


        productTable = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(productTable);


        orderButton = new JButton("Place Order");
        orderButton.addActionListener(e -> placeOrder());


        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(orderButton, BorderLayout.SOUTH);

        add(panel);
    }

    private void placeOrder() {
        int selectedRow = productTable.getSelectedRow();
        if (selectedRow != -1) {
            int productId = (int) productTable.getValueAt(selectedRow, 0);

            System.out.println("Order placed for product ID: " + productId);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to order.");
        }
    }
}
