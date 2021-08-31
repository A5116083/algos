package com.company.StringS;


import java.util.*;
import java.util.stream.Collectors;

public class FirstNonRepeating {

    public static void main(String[] args) {
        String sequence ="GeeksforGeeks";
        System.out.println("First non reprating string : " + findFirstNonRepeatingString(sequence));
    }

    private static String findFirstNonRepeatingString(String seq){


        Map<String,Integer> freq=  seq.chars()
                .mapToObj(c->(char) c)
                .collect(Collectors.toMap(k-> k.toString(), v-> 1, (x,y)-> x+1 ));


        for (int i=0; i < seq.length(); i++){
            if(freq.containsKey(String.valueOf(seq.charAt(i)))){
                if(freq.get(String.valueOf(seq.charAt(i)))== 1)
                    return String.valueOf(seq.charAt(i));
            }
        }
        return "";

    }
}
