package com.company.symboltable;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class SequentialSearchST<Key,Value> {

    private int n; //number of items
    private Node first;


    public SequentialSearchST() {

    }

    private class Node{
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public int size(){
        return n;
    }

    public boolean isEmpty(){
        return n==0;
    }

    public Value get(Key key){

        for(Node current= first; current!=null; current= current.next){
            if(current.key.equals(key))
                return current.val;
        }
        return null;
    }
    public void put(Key key,Value val){

        if(key==null){
            delete(key);
            return;
        }
        for(Node current= first; current!=null; current= current.next){
            if(current.key.equals(key)){
                current.val= val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;

    }

    public  void delete(Key key){

        first= delete(first, key);
    }
    private Node delete(Node node, Key key){
        if(node== null) return  null;
        if(node.key.equals(key)){
            n--;
            return  node.next;
        }
        node.next= delete(node.next, key);
        return node;
    }
    /**
     * Does this symbol table contain the given key?
     * @param key the key
     * @return {@code true} if this symbol table contains {@code key} and
     *     {@code false} otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }
    /**
     * Returns all keys in the symbol table as an {@code Iterable}.
     * To iterate over all of the keys in the symbol table named {@code st},
     * use the foreach notation: {@code for (Key key : st.keys())}.
     * @return all keys in the symbol table as an {@code Iterable}
     */
    public Iterable<Key> keys()  {
        Queue<Key> queue = new LinkedBlockingDeque<>();
        for (Node x = first; x != null; x = x.next)
            queue.add(x.key);
        return queue;
    }



}
