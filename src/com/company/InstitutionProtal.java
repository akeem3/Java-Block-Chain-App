package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Arrays;


public class InstitutionProtal extends JFrame implements ActionListener {

    private Button AddResult, Back;
    private JTable table;


    // ArrayList to store the blocks
    public static ArrayList<Block> blockchain = new ArrayList<Block>();

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


//////////////////////////
        setLayout(new FlowLayout());
        String [] columnNames = {"Student Name", "Student Email", "Password"};
        Object [][] tData = {{ "Bill", "George", "Male"},
                {"Marry", "Anna", "Female"}, {"Rick",
                "Bernard", "Male"}};
        table = new JTable(tData, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(650, 75) );
        table.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);


///////////////////////////////////



    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Back) {
            setVisible(false);
            RCSAS.main_menu.setVisible(true);
        }else if (e.getSource() == AddResult){

            String hash = "0";
            String[] data = {};
            Block block1 = new Block(data,hash);
            blockchain.add(block1);

            String name = JOptionPane.showInputDialog(AddResult,"Name: ");
            String mail = JOptionPane.showInputDialog(AddResult,"Email: ");
            String pass = JOptionPane.showInputDialog(AddResult,"Password: ");
            String[] Ndata = {name, mail, pass};
            Block newBlock = new Block(Ndata,block1.getHash());
            blockchain.add(newBlock);
            JOptionPane.showMessageDialog(AddResult,newBlock);




        }
        
    }
}
