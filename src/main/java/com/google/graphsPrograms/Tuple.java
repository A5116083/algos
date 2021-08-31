package com.google.graphsPrograms;

import java.util.Comparator;

public class Tuple<T extends Comparable<T>,U> implements Comparable<Tuple> {
    T first;
    U second;

    public  Tuple(T first, U second){
        this.first = first;
        this.second = second;
    }

    public T getFirst(){return first;}
    public U getSecond(){return second;}

    @Override
    public int compareTo(Tuple o) {
        return  this.getFirst().compareTo((T) o.getFirst());
    }
}
