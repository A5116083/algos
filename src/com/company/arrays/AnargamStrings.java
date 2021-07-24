package com.company.arrays;

public class AnargamStrings {

    public static void main(String[] args) {

        String s1= "listen";
        String s2= "silent";

        boolean result= isAnargam(s1,s2);

        System.out.println("Is Anargam : "+ result);

    }

    private static boolean isAnargam(String s1, String s2){
        int[] charFreq= new int[128];
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (Character c : c1){
            charFreq[c]++;
        }

        for (char c : c2){
            charFreq[c]--;
            if(charFreq[c]<0)
                return false;
        }

        return true;
    }


}
