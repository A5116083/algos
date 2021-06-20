package com.company.StringS;

import java.util.Arrays;
import java.util.Scanner;

public class CheckPermutation {

    public void methodB(){
        synchronized (this){

        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("input String 1: ");
        String string1 = scanner.next();
        System.out.println("input string 2: ");
        String string2 =scanner.next();
       // boolean result = sort(string1).equals(sort(string2));
        boolean result = permutation(string1,string2);

        System.out.println("Two strings are not equal: "+ result);


    }

    static String sort(String input) {
        {
            char[] charArr = input.toCharArray();
            Arrays.sort(charArr);
            return new String(charArr);
        }
    }

    private static boolean permutation(String s1, String s2){
        if(s1.length()!= s2.length())
            return false;

        int[] letters= new int[128];
        for(int i=0; i< s1.length();i++){
            letters[s1.charAt(i)]++;
        }

        for(int i =0; i <s2.length(); i++){
            int val= s2.charAt(i);
            letters[val]--;
            if(letters[val]<0)
                return false;

        }
        return true;
    }
}
