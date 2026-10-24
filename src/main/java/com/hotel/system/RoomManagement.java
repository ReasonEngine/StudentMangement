package com.hotel.system;

import javax.swing.*;
import java.io.*;

public class RoomManagement extends JFrame {

    JTextField no, type, price, status;

    public RoomManagement() {
        setTitle("Room Management");
        setSize(400,300);
        setLayout(null);

        no = field("Room No", 30);
        type = field("Type", 70);
        price = field("Price", 110);
        status = field("Status", 150);

        JButton add = new JButton("Add Room");
        add.setBounds(250,70,120,30);
        add(add);

        JButton view = new JButton("View Rooms");
        view.setBounds(250,120,120,30);
        add(view);

        add.addActionListener(e -> saveRoom());
        view.addActionListener(e -> viewRooms());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    JTextField field(String label, int y) {
        JLabel l = new JLabel(label + ":");
        l.setBounds(30,y,80,25);
        add(l);
        JTextField f = new JTextField();
        f.setBounds(120,y,100,25);
        add(f);
        return f;
    }

    void saveRoom() {
        try (FileWriter fw = new FileWriter("data/rooms.txt", true)) {
            fw.write(no.getText()+","+type.getText()+","+price.getText()+","+status.getText()+"\n");
            JOptionPane.showMessageDialog(this, "Room Saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    void viewRooms() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/rooms.txt"))) {
            JTextArea area = new JTextArea();
            String line;
            while ((line = br.readLine()) != null) {
                area.append(line + "\n");
            }
            JOptionPane.showMessageDialog(this, new JScrollPane(area));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}