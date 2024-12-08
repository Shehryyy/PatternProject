package org.example.View;

import Util.DataBaseUtil;
import org.example.Model.Order;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ViewOrders extends JFrame {

    public ViewOrders() {
        setTitle("View Orders");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        String[] columnNames = {"ID", "Status", "Date"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable ordersTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(ordersTable);

        add(scrollPane, BorderLayout.CENTER);


        List<Order> orders = DataBaseUtil.getAllOrders();
        for (Order order : orders) {
            Object[] rowData = {order.getOrderId(), order.getStatus(), order.getOrderDate()};
            tableModel.addRow(rowData);
        }

        setVisible(true);
    }
}
