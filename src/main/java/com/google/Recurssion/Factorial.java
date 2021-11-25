package com.google.Recurssion;

public class Factorial {

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println("Square of 4: " + square(4));
        System.out.println("number of digits : " + countDigits(12345789 ));

        System.out.println("Fibonacci sequence till 10") ;
        Factorial.fibonacciSeq(10,0);
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

    public static void fibonacciSeq(int num, int count){

        if(count>= num)
            return;
        if(count==0)
        {  System.out.println("0"); count++; }
        if(count ==1)
            {System.out.println("1");count++;}
        if(num> 2) {
            System.out.println(num - 1 + num - 2);
            fibonacciSeq(num++, count++);
        }

    }
}
