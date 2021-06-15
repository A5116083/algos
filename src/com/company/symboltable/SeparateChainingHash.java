package com.company.symboltable;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class SeparateChainingHash<Key, Value> {

    private static final int INIT_CAPACITY = 4;

    private int n;                                // number of key-value pairs
    private int size;                                // hash table size
    private SequentialSearchST<Key, Value>[] st;  // array of linked-list symbol tables

    public SeparateChainingHash() {
        this(INIT_CAPACITY);
    }


    public SeparateChainingHash(int size) {
        this.size = size;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[size];
        for(int count=0; count < this.size; count++){
            st[count] = new SequentialSearchST<>();
        }
    }

    public void put(Key key, Value val){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        if (val == null) {
            delete(key);
            return;
        }
        int hash= this.hash(key);
        if (!st[hash].contains(key)) n++;
        st[hash].put(key, val);

    }

    public Value get(Key key){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int hash = this.hash(key);
        return st[hash].get(key);

    }

    public void delete(Key key){
        if (key == null) throw new IllegalArgumentException("argument to get() is null");
        int hash = this.hash(key);
        if (st[hash].contains(key)) n--;
        st[hash].delete(key);
    }
    public int size(){
        return n;
    }
    public boolean isEmpty(){
        return n > 0;
    }
    public int hash(Key key){
        return  (key.hashCode() & 0x7fffffff) % size; //Modular hashing (Take the hashcode and do a bitwise and with 31 bit unsigned int)
    }
    public boolean contains(Key key) {
        if (key == null) throw new IllegalArgumentException("argument to contains() is null");
        return this.get(key) != null;
    }
    // return keys in symbol table as an Iterable
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedBlockingDeque<Key>();
        for (int i = 0; i < size; i++) {
            for (Key key : st[i].keys())
                queue.add(key);
        }
        System.out.println("Queue size " + queue.size());
        return queue;
    }
    public static void main(String[] args) {
        SequentialSearchST<String, Integer> st = new SequentialSearchST<String, Integer>();
        SeparateChainingHash<String, Integer> sth= new SeparateChainingHash(11);
        System.out.println("input keys for hash");

        Scanner scanner = new Scanner(System.in);
        int index=0;
        while(scanner.hasNext()){

            String nextkey = scanner.next();
            if(nextkey.equals("c1"))
                break;
            //st.put(nextkey, index++);
            sth.put(nextkey, index++);
        }


        for (String hashKey: sth.keys()){

            System.out.print(hashKey + ":" + sth.get(hashKey) + " ");

        }


    }
}
