package com.tutorial;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class LoginPage extends JFrame {
    public LoginPage() {
        setTitle("Sistem Informasi Akademis");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE); // agar bisa ditutup dengan tombol X

        // Panel utama
        JPanel panel = new JPanel(new BorderLayout());
        add(panel);

        // Label judul
        JLabel label = new JLabel("Please login", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 10));
        panel.add(label, BorderLayout.NORTH);

        // Panel input field
        JPanel fieldPanel = new JPanel(new GridLayout(2, 2));
        fieldPanel.add(new JLabel("Username"));
        JTextField usernameField = new JTextField();
        fieldPanel.add(usernameField);
        fieldPanel.add(new JLabel("Password"));
        JPasswordField passwordField = new JPasswordField();
        fieldPanel.add(passwordField);
        panel.add(fieldPanel, BorderLayout.CENTER);

        // Tombol login
        JButton button = new JButton("LOGIN");
        panel.add(button, BorderLayout.SOUTH);

        // Logika login
        button.addActionListener(e -> {
            String username = usernameField.getText();
            String password = String.valueOf(passwordField.getPassword());
            if (username.equals("Admin") && password.equals("12345")) {
                JOptionPane.showMessageDialog(this, "Login berhasil");
                dispose();
                new Dashboard().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Username atau password salah");
                usernameField.setText("");
                passwordField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginPage().setVisible(true));
    }
}
