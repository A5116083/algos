package com.google.TrieDS;

import java.security.InvalidParameterException;

public class Trie {
    private TrieNode root; //Root Node
    private static int keyCount=0;

    //Constructor
    Trie(){
        root = new TrieNode();
    }
    //Function to get the index of a character 't'
    public int getIndex(char t){
        //char value of 'a' in 97 , so for any character we will subtract the 97 to get the reference char index
        return t - 'a';
    }


    //Function to insert a key,value pair in the Trie
    public void insert(String key,int value) throws Exception {
        char[] keyChars = key.toCharArray();
        TrieNode node = insert(root, value,key,0);
        if(node==null) throw new InvalidParameterException("invalid text to insert");
    }

    public TrieNode insert(TrieNode node, int value, String key, int current) throws Exception {

        if(node==null) node = new TrieNode();
        if(current== key.length()){ //reached at the end of the
            if(node.val ==null) keyCount++;
            node.val= value;
            node.isEndWord= true;
            return node;
        }
        int pos =getIndex(key.charAt(current));
        if(pos> 25) throw  new Exception("inavlid text ");
        node.children[pos] = insert(node.children[pos], value, key, current+1);
        return node;
    }


    //Function to search given key in Trie
    public boolean search(String key){ return false;}

    //Function to delete given key from Trie
    public boolean delete(String key){ return false;}
}
