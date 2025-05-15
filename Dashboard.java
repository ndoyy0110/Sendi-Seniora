package com.tutorial;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Dashboard extends JFrame {
    public Dashboard() {
        setTitle("dashboard");
        setSize(680, 480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // agar jendela bisa ditutup

        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        inputPanel.add(new JLabel("name"));
        JTextField nameField = new JTextField();
        inputPanel.add(nameField);

        inputPanel.add(new JLabel("NIM"));
        JTextField nimfield = new JTextField();
        inputPanel.add(nimfield);

        inputPanel.add(new JLabel("major"));
        JTextField majorField = new JTextField();
        inputPanel.add(majorField);

        // tambah button
        JButton addButton = new JButton("Add student");
        inputPanel.add(addButton);

        JButton deleteButton = new JButton("Delete Student");
        inputPanel.add(deleteButton);

        String[] column = {"Nama", "NIM", "Major"};
        DefaultTableModel tableModel = new DefaultTableModel(column, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);

        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // aksi tombol add
        addButton.addActionListener(e -> {
            String name = nameField.getText();
            String nim = nimfield.getText();
            String major = majorField.getText();

            tableModel.addRow(new Object[]{name, nim, major});
            nameField.setText("");
            nimfield.setText("");
            majorField.setText("");
        });

        // aksi tombol delete
        deleteButton.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            } else {
                JOptionPane.showMessageDialog(this, "Please select a row first");
            }
        });
    }
}
