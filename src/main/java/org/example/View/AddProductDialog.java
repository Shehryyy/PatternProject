package org.example.View;

import Util.DataBaseUtil;
import org.example.Model.Product;
import org.example.Model.ProductDAO;
import org.example.Model.ProductFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProductDialog extends JDialog {
    private JTextField productIdField;
    private JTextField productPriceField;
    private JTextField productQuantityField;
    private JTextField productStr1Field; // First additional field (e.g., name, size, company)
    private JTextField productStr2Field; // Second additional field (e.g., platform, color, storage)
    private JTextField productStr3Field; // Third additional field (e.g., genre, style, model)
    private JComboBox<String> productTypeComboBox;

    public AddProductDialog(JFrame parent) {
        super(parent, "Add New Product", true);

        setLayout(new GridLayout(7, 2));

        add(new JLabel("Product ID:"));
        productIdField = new JTextField();
        add(productIdField);

        add(new JLabel("Product Price:"));
        productPriceField = new JTextField();
        add(productPriceField);

        add(new JLabel("Product Quantity:"));
        productQuantityField = new JTextField();
        add(productQuantityField);

        add(new JLabel("Additional Info (Str1):"));
        productStr1Field = new JTextField();
        add(productStr1Field);

        add(new JLabel("Additional Info (Str2):"));
        productStr2Field = new JTextField();
        add(productStr2Field);

        add(new JLabel("Additional Info (Str3):"));
        productStr3Field = new JTextField();
        add(productStr3Field);

        add(new JLabel("Product Type:"));
        productTypeComboBox = new JComboBox<>(new String[]{"VideoGame", "Clothing", "Electronics"});
        add(productTypeComboBox);

        JButton addButton = new JButton("Add Product");
        add(addButton);

        JButton closeButton = new JButton("Close");
        add(closeButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int productId = Integer.parseInt(productIdField.getText());
                    double price = Double.parseDouble(productPriceField.getText());
                    int quantity = Integer.parseInt(productQuantityField.getText());
                    String type = (String) productTypeComboBox.getSelectedItem();
                    String str1 = productStr1Field.getText();
                    String str2 = productStr2Field.getText();
                    String str3 = productStr3Field.getText();


                    Product newProduct = ProductFactory.createProduct(productId, price, quantity, type, str1, str2, str3);

                    switch (type) {
                        case "VideoGame":
                            DataBaseUtil.insertToVideoGame(productId, str1, str2, str3);
                            break;
                        case "Clothing":
                            DataBaseUtil.insertToClothing(productId, str1, str2, str3);
                            break;
                        case "Electronics":
                            DataBaseUtil.insertToElectronics(productId, str1, str2, str3);
                            break;
                        default:
                            System.out.println("Unknown product type: " + type);
                            break;
                    }

                    JOptionPane.showMessageDialog(AddProductDialog.this, "Product added successfully.");
                    dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(AddProductDialog.this, "Invalid input. Please check the entered values.", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(AddProductDialog.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        setSize(400, 350);
        setLocationRelativeTo(parent);
    }
}
