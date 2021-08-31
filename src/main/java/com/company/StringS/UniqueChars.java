package com.company.StringS;

import java.util.Scanner;

public class UniqueChars {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("input the string to eval: ");

        String inputText = input.next();
        String result = isUniqueChar(inputText)? "true":"false";
        System.out.printf("Is unique String %s , %s" , inputText,result );

    }

    public static boolean isUniqueChar(String inputStr){
        if(inputStr.length()< 0 || inputStr.length()> 128)
            return false;
        boolean[] char_set= new boolean[128];

        for(int counter=0;counter < inputStr.length(); counter++){

            int val= inputStr.charAt(counter);
            //char x= inputStr.charAt(counter);
            if(char_set[val])
                return false;
            char_set[val]= true;
        }
        return true;
    }
}
