package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class GuestManagement extends JFrame {

    JTextField name, phone, email;
    JButton add;

    public GuestManagement() {
        setTitle("Guest Management");
        setSize(400,250);
        setLayout(null);

        JLabel l1 = new JLabel("Full Name:");
        l1.setBounds(30,30,100,25);
        add(l1);

        name = new JTextField();
        name.setBounds(130,30,180,25);
        add(name);

        JLabel l2 = new JLabel("Phone:");
        l2.setBounds(30,70,100,25);
        add(l2);

        phone = new JTextField();
        phone.setBounds(130,70,180,25);
        add(phone);

        JLabel l3 = new JLabel("Email:");
        l3.setBounds(30,110,100,25);
        add(l3);

        email = new JTextField();
        email.setBounds(130,110,180,25);
        add(email);

        add = new JButton("Add Guest");
        add.setBounds(130,150,120,30);
        add(add);

        // Action listener
        add.addActionListener(e -> addGuest());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void addGuest() {
        try {
            // Make sure guests.txt exists
            File file = new File("data/guests.txt");
            if (!file.exists()) file.createNewFile();

            // Append guest data
            FileWriter fw = new FileWriter(file, true);
            fw.write(name.getText() + "," + phone.getText() + "," + email.getText() + "\n");
            fw.close();

            JOptionPane.showMessageDialog(this, "Guest Added Successfully");

            // Clear fields
            name.setText("");
            phone.setText("");
            email.setText("");

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error occurred: " + ex.getMessage());
        }
    }
}