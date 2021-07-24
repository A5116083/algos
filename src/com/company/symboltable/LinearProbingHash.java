package com.company.symboltable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinearProbingHash {

    public static void main(String[] args) {

        List<String> str= new ArrayList<>();
        str.add("A"); str.add("B"); str.add("C");
        Iterator<String> itr = str.iterator();


       /* while (itr.hasNext())
            System.out.println(itr.next());*/
/*
        for(String str1:str){
            System.out.println(str1);

        }*/
        str.forEach(System.out::println);

    }
}
