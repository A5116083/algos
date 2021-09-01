package com.google.TrieDS;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie {
    private TrieNode root; //Root Node
    private static int keyCount = 0;

    //Constructor
    Trie() {
        root = new TrieNode();
    }

    //Function to get the index of a character 't'
    public int getIndex(char t) {
        //char value of 'a' in 97 , so for any character we will subtract the 97 to get the reference char index
        return t - 'a';
    }


    //Function to insert a key,value pair in the Trie
    public void insert(String key, int value) throws Exception {
        TrieNode node = insert(root, value, key.toLowerCase(), 0);
        if (node == null) throw new InvalidParameterException("invalid text to insert");
    }

    public TrieNode insert(TrieNode node, int value, String key, int current) throws Exception {

        if (node == null) node = new TrieNode();
        if (current == key.length()) { //reached at the end of the
            if (node.val == null) keyCount++;
            node.val = value;
            node.isEndWord = true;
            return node;
        }
        int pos = getIndex(key.charAt(current));
        if (pos > 25) throw new Exception("invalid text ");
        node.children[pos] = insert(node.children[pos], value, key, current + 1);
        return node;
    }


    //Function to search given key in Trie
    public boolean search(String key) {
        if (key == null) return false;
        TrieNode node = this.root;
        key = key.toLowerCase();

        for (int i = 0; i < key.length(); i++) {
            int pos = getIndex(key.charAt(i));
            if (node.children[pos] != null) {
                node = node.children[pos];
            } else return false;
        }
        return node.isEndWord;
    }
    //Helper Function to return true if currentNode does not have any children
    private boolean hasNoChildren(TrieNode currentNode){
        for (int i = 0; i < currentNode.children.length; i++){
            if ((currentNode.children[i]) != null)
                return false;
        }
        return true;
    }
    //Function to delete given key from Trie
    public boolean delete(String key) {
        return false;
    }

    public List<String> printAllWords(){
        List<String> words = new ArrayList<>();
        char[] chars = new char[20]; //assuming max length of word is 20
        findWords(this.root, words,0,chars);
        return words;
    }

    private void findWords(TrieNode node, List<String> words, int level, char[] characters ){
        if(node.isEndWord){
            String temp = "";
            for (int i=0; i< level;i++){
                temp+= characters[i];
            }
            words.add(temp);
        }
        for (int i=0 ; i < 26;i++){
            if(node.children[i]!=null){
                characters[level] = (char)(i+'a');
                findWords(node.children[i], words,level+1, characters);
            }
        }

    }

    public int totalWord(TrieNode node, int wordCount){
        if(node.isEndWord) return  1;
        for (int i=0 ; i < 26;i++){
            if(node.children[i]!=null){
                wordCount += totalWord(node.children[i], wordCount);

            }
        }
        return wordCount;
    }

    public static int totalWords(TrieNode root){
        int result = 0;
        // Leaf denotes end of a word
        if (root.isEndWord)
            result++;

        for (int i = 0; i < 26; i++)
            if (root.children[i] != null)
                result += totalWords(root.children[i]);
        return result;
    }
    public static boolean isFormationPossible(String[] dict,String word) {
        if(dict.length<2 || word.length() <2)
            return false;

        Trie t = new Trie();
        for (int i=0; i< dict.length;i++){
            try {
                t.insert(dict[i],i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i=0; i < word.length(); i++){
            String first= word.substring(0,i);
            String second = word.substring(i);
            if(t.search(first) && t.search(second))
                return true;
        }
        return false;
    }


    public static void main(String[] args) {

        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();
        System.out.println("Keys: " + Arrays.toString(keys));
        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++) {
            try {
                t.insert(keys[i], i);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Total word count : " + t.totalWords(t.root));
        List<String> allWords= t.printAllWords();
        System.out.println(allWords);
        // Search for different keys and delete if found
        if (t.search("the") == true) {
            System.out.println("the --- " + output[1]);
            t.delete("the");
            System.out.println("Deleted key \"the\"");
        } else System.out.println("the --- " + output[0]);

        /*if (t.search("these") == true) {
            System.out.println("these --- " + output[1]);
            t.delete("these");
            System.out.println("Deleted key \"these\"");
        } else System.out.println("these --- " + output[0]);

        if (t.search("abc") == true) {
            System.out.println("abc --- " + output[1]);
            t.delete("abc");
            System.out.println("Deleted key \"abc\"");
        } else System.out.println("abc --- " + output[0]);

        // check if the string has deleted correctly or still present
        if (t.search("abc") == true)
            System.out.println("abc --- " + output[1]);
        else System.out.println("abc --- " + output[0]);*/
        String word = "anydragons";
        String dict[] = {"the", "hello", "there", "answer","any", "dragon", "world", "their",  "inc"};
        boolean result = isFormationPossible(dict,word);
        System.out.println(result? word + " :can be formed from dict": word + " :cannot be formed from dict");


    }
}

