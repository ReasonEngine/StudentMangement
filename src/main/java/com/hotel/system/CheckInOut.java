package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class CheckInOut extends JFrame {

    JTextField guest, room;
    JButton checkIn, checkOut;

    public CheckInOut() {
        setTitle("Check-In / Check-Out");
        setSize(400,250);
        setLayout(null);

        JLabel g = new JLabel("Guest Name:");
        g.setBounds(30,30,100,25);
        add(g);

        guest = new JTextField();
        guest.setBounds(140,30,200,25);
        add(guest);

        JLabel r = new JLabel("Room No:");
        r.setBounds(30,70,100,25);
        add(r);

        room = new JTextField();
        room.setBounds(140,70,200,25);
        add(room);

        checkIn = new JButton("Check In");
        checkIn.setBounds(60,130,120,30);
        add(checkIn);

        checkOut = new JButton("Check Out");
        checkOut.setBounds(200,130,120,30);
        add(checkOut);

        checkIn.addActionListener(e -> doCheckIn());
        checkOut.addActionListener(e -> doCheckOut());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void doCheckIn() {
        try (FileWriter fw = new FileWriter("data/checkin.txt", true)) {
            fw.write(guest.getText() + "," + room.getText() + "\n");
            JOptionPane.showMessageDialog(this, "Guest Checked In");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void doCheckOut() {
        JOptionPane.showMessageDialog(this, "Guest Checked Out");
    }
}