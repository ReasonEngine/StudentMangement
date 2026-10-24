package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class Reports extends JFrame {

    JButton occupancy, revenue;

    public Reports() {
        setTitle("Reports");
        setSize(350,220);
        setLayout(null);

        occupancy = new JButton("Occupancy Report");
        occupancy.setBounds(80,40,180,30);
        add(occupancy);

        revenue = new JButton("Revenue Report");
        revenue.setBounds(80,90,180,30);
        add(revenue);

        occupancy.addActionListener(e -> showOccupancy());
        revenue.addActionListener(e -> showRevenue());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void showOccupancy() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/checkin.txt"))) {
            int count = 0;
            while (br.readLine() != null) count++;
            JOptionPane.showMessageDialog(this,
                "Current Occupied Rooms: " + count);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void showRevenue() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/billing.txt"))) {
            double total = 0;
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                total += Double.parseDouble(data[2]);
            }
            JOptionPane.showMessageDialog(this,
                "Total Revenue: " + total + " ETB");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}