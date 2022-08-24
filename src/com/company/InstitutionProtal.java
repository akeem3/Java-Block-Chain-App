package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InstitutionProtal extends JFrame implements ActionListener {

    private Button AddResult, Back;

    public InstitutionProtal(){
        setSize(700, 400);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        AddResult = new Button("Add Result");
        Back = new Button("Back");

        AddResult.addActionListener(this);
        Back.addActionListener(this);

        add(AddResult);
        add(Back);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            RCSAS.main_menu.setVisible(true);
        }
        
    }
}
