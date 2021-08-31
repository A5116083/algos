package com.company.symboltable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinearProbingHash {

    public static void main(String[] args) {

        List<String> str= new ArrayList<>();
        str.add("A"); str.add("B"); str.add("C");
        Iterator<String> itr = str.iterator();

        str.forEach(System.out::println);

    }
}
