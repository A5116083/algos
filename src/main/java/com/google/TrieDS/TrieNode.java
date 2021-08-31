package com.google.TrieDS;

public class TrieNode {

    //Contains the following properties
    //children nodes of size 26
    TrieNode[] children;
    boolean isEndWord;
    Object val;
    public static final int ALPABHET_SIZE  = 26;
    public TrieNode() {
        //Initialize all child nodes with null pointer
        children = new TrieNode[ALPABHET_SIZE];
        isEndWord= false ; //init with default
    }

    public void markEndWord(){
        isEndWord= true;
    }

    public void unMarkEndWord(){
        isEndWord = false;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }
}
