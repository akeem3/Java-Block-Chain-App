package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static com.company.RCSAS.*;
import static com.company.Block.*;

public class StudentPortal extends JFrame implements ActionListener {

    private Button view_cert, Back, verify;

    public StudentPortal(){
        setSize(700, 400);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());


        view_cert = new Button("view_cert");
        Back = new Button("Back");

        view_cert.addActionListener(this);
        Back.addActionListener(this);

        add(view_cert);
        add(Back);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            RCSAS.main_menu.setVisible(true);
        }else if(e.getSource() == verify){
            if(isChainValid() == false){
                JOptionPane.showMessageDialog(verify, "Hashes not equal");
            }else{
                JOptionPane.showMessageDialog(verify, "Hashes are equal");
            }
        }
    }
}
