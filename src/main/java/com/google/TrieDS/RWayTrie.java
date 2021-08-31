package com.google.TrieDS;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class RWayTrie {
    private static final int R = 256;
    // R-way trie node
    private static class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    public Node root ;
    private int n=0;          // number of keys in trie

    public RWayTrie() {
        this.root = new Node();
    }

    public void put(String  key, Object val){
        if(key==null) throw new IllegalArgumentException();
        root = put(root,key, val, 0);
    }
    private Node put(Node x, String key, Object val, int d) {
        if (x == null) x = new Node();
        if (d == key.length()) {
            if (x.value == null) n++;
            x.value = val;
            return x;
        }
        char c = key.charAt(d);
        x.next[c] = put(x.next[c], key, val, d+1);
        return x;
    }

    public Object get(String key){
    if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node node = get(key, root,0 );
        if(node!=null)
            return node.value;
        else return null;
    }
    public boolean contains(String key){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        Node node = get(key, root,0 );
        return node!=null;
    }
    private Node get(String key, Node x, int d ){
        if(x==null) return null;
        if(d== key.length()) return x;
        char c = key.charAt(0);
        return get(key, x.next[c], d+1);
    }

    public Iterable<String> keys(){

        return getPrefix("");
    }

    public Iterable<String> getPrefix(String prefix){
        Queue<String> results = new LinkedBlockingDeque<>();
        Node x = get( prefix,root, 0);
        collect(x, new StringBuilder(prefix), results);
        return results;
    }
    private void collect(Node x, StringBuilder prefix, Queue<String> results) {
        if(x==null) return;
        if(x.value!=null) results.add(prefix.toString());
        for (char c=0; c< R; c++){
            prefix.append(c);
            collect(x.next[c], prefix,results);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }

    public int length(){
        return n;
    }

    /*public String longestPrefixOf(String query) {

    }*/

    // returns the length of the longest string key in the subtrie
    // rooted at x that is a prefix of the query string,
    // assuming the first d character match and we have already
    // found a prefix match of given length (-1 if no such match)
    private int longestPrefixOf(Node x, String query, int d, int length) {
        if(x==null) return length;
        if(x.value!=null)  length=d;
        if(d == query.length()) return d;
        char c = query.charAt(d);
        return  longestPrefixOf(x.next[c],query,d+1, length);
    }


    public static void main(String[] args) {
        RWayTrie trie = new RWayTrie();
        trie.put("she", 0);
        trie.put("shell", 1);
        trie.put("stud", 2);
        trie.put("student",3);
        trie.put("studious", 4);
        System.out.println("Total number of keys : " + trie.length());
        trie.keys().forEach(x-> System.out.println(x+ " "));
    }
}
