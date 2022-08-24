package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Main_menu extends JFrame implements ActionListener {
    private Button StudentPortal, LecturerPortal, Exit;

    public Main_menu() {
        setSize(700, 400);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        StudentPortal = new Button("Student Portal");
        LecturerPortal = new Button("Institution Portal");
        Exit = new Button("Exit");


        StudentPortal.addActionListener(this);
        LecturerPortal.addActionListener(this);
        Exit.addActionListener(this);

        add(StudentPortal);
        add(LecturerPortal);
        add(Exit);

        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e){
        //Student Portal Entry
        if (e.getSource()== StudentPortal){
            setVisible(false);
            RCSAS.studentPortal.setVisible(true);

        }else if (e.getSource()== LecturerPortal){
            setVisible(false);
            RCSAS.lecturerPortal.setVisible(true);
        }else if(e.getSource() == Exit){
            System.exit(0);
        }
    }

}
