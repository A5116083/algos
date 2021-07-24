package com.google.Recurssion.Strings;

import javax.sound.midi.Soundbank;

public class StringRecursiveOperations {

    public static void main(String[] args) {
        String reversed = reverseString( "hello world");
        System.out.println(reversed);
        String noDuplicates = removeDuplicated( "thiss iss a tesstt");
        System.out.println(noDuplicates);
        String str1 = "cnt";
        String str2= "ace";
        String mergedStr = alphabeticMerge(str1, str2);
        System.out.println("merged string: "+ mergedStr);

        System.out.println("Total vowel count in HeLLO world: " + totalVowels("HeLLO world","HeLLO world".length(),0));
        permutation("abcd".toCharArray(), 3);
    }
    public static String reverseString(String str){

        if(str.isEmpty())
            return str;
        else return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static String removeDuplicated(String str){

        if(str.length()==1)
            return str;
        else if(str.substring(0,1).equals(str.substring(1,2)))
                return removeDuplicated(str.substring(1));
        else
            return str.substring(0,1) + removeDuplicated(str.substring(1));

    }

    public static String alphabeticMerge(String one, String two){

        if(one==null || one.equals(""))
            return two==null? one:two;
        else if(two==null || two.equals(""))
            return one;
        else if(one.charAt(0) < two.charAt(0))
            return one.charAt(0) + alphabeticMerge(one.substring(1), two);
        else return two.charAt(0) + alphabeticMerge(one, two.substring(1));
    }

    public static int totalVowels(String text, int len, int index) {
        if(index == len)
            return 0;
        else if(String.valueOf(text.charAt(0)).toLowerCase().equals("a") ||
                String.valueOf(text.charAt(0)).toLowerCase().equals("e") ||
                String.valueOf(text.charAt(0)).toLowerCase().equals("i") ||
                String.valueOf(text.charAt(0)).toLowerCase().equals("o") ||
                String.valueOf(text.charAt(0)).toLowerCase().equals("u") ){
            return 1+ totalVowels(text.substring(1),text.length()-1, 0 );
        }
        else
           return totalVowels(text.substring(1),text.length()-1, 0 );

    }

    /*
    Generate permutation of String using maximum characters at time , order is not important
     */
    public static void permutation(char[] chars, int length){

        if(length==1){
            System.out.println(chars);
            return;
        }else{
            for (int i=0; i< chars.length;i++){

                swap(chars,i, chars.length-1);
                permutation(chars, length-1);
                swap(chars,i, chars.length-1);
            }
        }

    }

    private static void swap(char[] array, int i, int j){

        char c;
        c = array[i];
        array[i] = array[j];
        array[j] = c;
    }


    public static boolean isPalindrome(String text) {
        if (text.length() == 0) {
            return false;
        }
        else if (text.length() == 1) {
            return true;
        }
        else {
            if (text.charAt(0) == text.charAt(text.length()-1)) {
                return isPalindrome(text.substring(1, text.length()-1));
            }
        }
        return false;
    }



}
