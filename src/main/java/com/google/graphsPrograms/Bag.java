package com.google.graphsPrograms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Bag<T> implements Iterable {

    private List<T> items ;
    public Bag(){
        items = new ArrayList<>();
    }

    @Override
    public Iterator iterator() {
        return items.iterator();
    }

    public void add(T value){
        items.add(0,value);
    }
    public boolean isEmpty(){
        return items.isEmpty();
    }
    public int size(){
        return items.size();
    }

}
