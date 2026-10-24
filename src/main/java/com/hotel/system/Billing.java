package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class Billing extends JFrame {

    JTextField guest, room, days, rate;
    JButton generate;

    public Billing() {
        setTitle("Billing & Invoice");
        setSize(400,320);
        setLayout(null);

        guest = field("Guest Name", 30);
        room = field("Room No", 70);
        days = field("Days Stayed", 110);
        rate = field("Rate per Day", 150);

        generate = new JButton("Generate Bill");
        generate.setBounds(130,220,140,30);
        add(generate);

        generate.addActionListener(e -> generateBill());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JTextField field(String t, int y) {
        JLabel l = new JLabel(t + ":");
        l.setBounds(30,y,120,25);
        add(l);
        JTextField f = new JTextField();
        f.setBounds(160,y,180,25);
        add(f);
        return f;
    }

    void generateBill() {
        try {
            int d = Integer.parseInt(days.getText());
            double r = Double.parseDouble(rate.getText());
            double total = d * r;

            FileWriter fw = new FileWriter("data/billing.txt", true);
            fw.write(guest.getText()+","+room.getText()+","+total+"\n");
            fw.close();

            JOptionPane.showMessageDialog(this,
                "Invoice Generated\nTotal Amount: " + total + " ETB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}