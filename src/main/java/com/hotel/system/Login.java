package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class Login extends JFrame {

    JTextField user;
    JPasswordField pass;

    public Login() {
        setTitle("Hotel Reservation Login");
        setSize(350,200);
        setLayout(null);

        JLabel u = new JLabel("Username:");
        u.setBounds(30,30,80,25);
        add(u);

        user = new JTextField();
        user.setBounds(120,30,150,25);
        add(user);

        JLabel p = new JLabel("Password:");
        p.setBounds(30,70,80,25);
        add(p);

        pass = new JPasswordField();
        pass.setBounds(120,70,150,25);
        add(pass);

        JButton login = new JButton("Login");
        login.setBounds(120,110,100,25);
        add(login);

        login.addActionListener(e -> checkLogin());

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    void checkLogin() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[0].equals(user.getText()) &&
                    data[1].equals(new String(pass.getPassword()))) {
                    JOptionPane.showMessageDialog(this, "Login Successful");
                    new Dashboard();
                    dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Invalid Login");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
