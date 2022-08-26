package com.company;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class RCSAS {
    public static Main_menu main_menu = new Main_menu();
    public static InstitutionProtal lecturerPortal = new InstitutionProtal();
    public static StudentPortal studentPortal = new StudentPortal();
    public static ArrayList<Block> blockchain = new ArrayList<Block>();


    public static Boolean isChainValid()
    {
        Block currentBlock;
        Block previousBlock;

        // Iterating through
        // all the blocks
        for (int i = 1;
             i < blockchain.size();
             i++) {

            // Storing the current block
            // and the previous block
            currentBlock = blockchain.get(i);
            previousBlock = blockchain.get(i - 1);

            // Checking if the current hash
            // is equal to the
            // calculated hash or not
            if (!currentBlock.hash
                    .equals(
                            currentBlock
                                    .calculateHash())) {
                return false;

            }

            // Checking of the previous hash
            // is equal to the calculated
            // previous hash or not
            if (!previousBlock
                    .hash
                    .equals(
                            currentBlock
                                    .previousHash)) {

                return false;
            }
        }

        // If all the hashes are equal
        // to the calculated hashes,
        // then the blockchain is valid
        return true;
    }




    public static Block firstblock(){
        String hash = "0";
        String name = null, pass = null, mail = null;
        Block block1 = new Block(name, pass, mail, hash);
        return block1;
    }


    public static void main(String[] args) {

        try {
            //TextFile
            File myObj = new File("Blockchain.txt");
            PrintWriter p = new PrintWriter(myObj);
            Scanner s = new Scanner(myObj);
            while (s.hasNext()){
                for (int i = 0; i < RCSAS.blockchain.size(); i++) {
                    Block x =RCSAS.blockchain.get(i);
                    p.println(x.toString());
                    p.println();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }


}
