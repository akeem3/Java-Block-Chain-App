package com.company;
import com.company.RCSAS;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.List;
import java.util.Scanner;

import static com.company.RCSAS.*;
import static com.company.Block.*;


public class InstitutionProtal extends JFrame implements ActionListener {

    private Button AddResult, Back, update;
    JTable table;
    String name, mail, pass;
    JPanel panel;
    JScrollPane scrollPane;




    // ArrayList to store the blocks


    public InstitutionProtal() {
        setSize(700, 400);
        setLocation(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());




        AddResult = new Button("Add Records");
        Back = new Button("Back");
        update = new Button("update");

        AddResult.addActionListener(this);
        Back.addActionListener(this);
        update.addActionListener(this);

        add(AddResult);
        add(Back);
        add(update);


//////////////////////////
        //String data[][]={ {"101","Amit","670000"},
        //        {"102","Jai","780000"},
          //      {"101","Sachin","700000"}};

        String column[]={"Name","Grade","Level"};
        DefaultTableModel md = new DefaultTableModel(column,0);
        table = new JTable(md);
        table.setBounds(30,40,200,300);
        scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
        add(scrollPane);


///////////////////////////////////


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            RCSAS.main_menu.setVisible(true);
        }
        else if (e.getSource() == AddResult) {

            mail = JOptionPane.showInputDialog(AddResult, "Name: ");

            name = JOptionPane.showInputDialog(AddResult, "Grade: ");

            pass = JOptionPane.showInputDialog(AddResult, "Level: ");


            String[] Ndata = {name, mail, pass};
            Block newBlock = new Block(name,mail,pass, RCSAS.firstblock().getHash());
            blockchain.add(newBlock);

            try {
                PrintWriter p = new PrintWriter("Blockchain.txt");
                for (int i = 0; i < blockchain.size(); i++) {
                    Block x = blockchain.get(i);
                    p.println(x.toString());
                    p.println();

                }
                p.close();
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }

        }else if (e.getSource() == update){
            DefaultTableModel md = (DefaultTableModel) table.getModel();
            md.setRowCount(0);
            //System.out.println(blockchain.stream().forEach(a->a.getMail()));
            blockchain.stream().forEach(a->md.addRow(new Object[] {a.getMail(),a.getName(),a.getPass()}));
            table.setModel(md);

        }
    }
}
