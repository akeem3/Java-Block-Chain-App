package com.company;

// Java implementation for creating
// a block in a Blockchain

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Block {

    // Every block contains
    // a hash, previous hash and
    // data of the transaction made
    public String hash;
    public String previousHash;
    private String mail;
    private String name;
    private String pass;
    private LocalDateTime timeStamp;
    private ArrayList<Block> blockchain;

    // Constructor for the block
    public Block(String name, String mail, String pass, String previousHash)
    {
        this.mail = mail;
        this.pass = pass;
        this.name = name;
        this.previousHash = previousHash;
        this.timeStamp = LocalDateTime.now() ;
        this.hash = calculateHash();
    }

    /*public blockChain(String name, String mail, String hash){
        this.name = getName();
        this.mail = getMail();
        this.hash = getHash();

    }*/

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(String previousHash) {
        this.previousHash = previousHash;
    }



    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    // Function to calculate the hash
    public String calculateHash()
    {
        // Calling the "crypt" class
        // to calculate the hash
        // by using the previous hash,
        // timestamp and the data
        String calculatedhash = Hasher.sha256(previousHash + timeStamp + name + pass + mail);

        return calculatedhash;
    }

    @Override
    public String toString() {
        return "Block{" + "hash='" + hash + '\n' + "previousHash='" + previousHash + '\n' + "Name=" +
                name.toString() + "\n" + " password= "+ pass.toString() + "Email" + mail.toString() + "timeStamp=" + timeStamp + '}';
    }


}