package com.company;

// Java implementation for creating
// a block in a Blockchain

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;

public class Block {

    // Every block contains
    // a hash, previous hash and
    // data of the transaction made
    public String hash;
    public String previousHash;
    private String[] data;
    private LocalDateTime timeStamp;

    // Constructor for the block
    public Block(String[] data, String previousHash)
    {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = LocalDateTime.now() ;
        this.hash = calculateHash();
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

    public String[] getData() {
        return data;
    }

    public void setData(String[] data) {
        this.data = data;
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
        String calculatedhash = Hasher.sha256(previousHash + timeStamp + data);

        return calculatedhash;
    }

    @Override
    public String toString() {
        return "Block{" + "hash='" + hash + '\'' + ", previousHash='" + previousHash + '\'' + ", data=" +
                Arrays.toString(data) + ", timeStamp=" + timeStamp + '}';
    }
}