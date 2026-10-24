package com.hotel.system;

import javax.swing.*;

public class Dashboard extends JFrame {

    public Dashboard() {
        setTitle("Hotel Reservation Dashboard");
        setSize(400,350);
        setLayout(null);

        JButton rooms = btn("Room Management", 30);
        JButton reservations = btn("Reservations", 80);
        JButton check = btn("Check In / Out", 130);
        JButton billing = btn("Billing", 180);
        JButton reports = btn("Reports", 230);

        rooms.addActionListener(e -> new RoomManagement());
        reservations.addActionListener(e -> new ReservationManagement());
        check.addActionListener(e -> new CheckInOut());
        billing.addActionListener(e -> new Billing());
        reports.addActionListener(e -> new Reports());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JButton btn(String text, int y) {
        JButton b = new JButton(text);
        b.setBounds(100,y,200,30);
        add(b);
        return b;
    }
}