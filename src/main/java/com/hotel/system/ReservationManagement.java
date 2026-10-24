package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class ReservationManagement extends JFrame {

    JTextField guest, room, in, out;

    public ReservationManagement() {
        setTitle("Reservation");
        setSize(400,300);
        setLayout(null);

        guest = field("Guest Name", 30);
        room = field("Room No", 70);
        in = field("Check-in", 110);
        out = field("Check-out", 150);

        JButton save = new JButton("Reserve");
        save.setBounds(130,200,120,30);
        add(save);

        save.addActionListener(e -> reserve());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JTextField field(String t, int y) {
        JLabel l = new JLabel(t);
        l.setBounds(30,y,100,25);
        add(l);
        JTextField f = new JTextField();
        f.setBounds(130,y,200,25);
        add(f);
        return f;
    }

    void reserve() {
        try (FileWriter fw = new FileWriter("data/reservations.txt", true)) {
            fw.write(guest.getText()+","+room.getText()+","+in.getText()+","+out.getText()+"\n");
            JOptionPane.showMessageDialog(this, "Reservation Done");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}