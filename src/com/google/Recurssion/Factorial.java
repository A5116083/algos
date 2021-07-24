package com.google.Recurssion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println("Square of 4: " + square(4));
        System.out.println("number of digits : " + countDigits(12345789 ));
    }

    public static int factorial(int n){

        if(n==1)
            return 1;
        else return n* factorial(n-1);
    }

    public static int square(int n){

        if(n==0)
            return 0;

        else return square(n-1) + (2*n)-1;
    }

    public static int countDigits(int n){

        if(n <= 1)
            return 1;
        else return  1 + countDigits(n/10);
    }
}
