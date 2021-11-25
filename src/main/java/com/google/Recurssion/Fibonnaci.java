package com.google.Recurssion;

public class Fibonnaci {

    public static int fibonnaciRec(int n){

        if (n<=1)
            return n;
        return fibonnaciRec(n-1) + fibonnaciRec(n-2);
    }

    public static void main(String[] args) {
        System.out.println(Fibonnaci.fibonnaciRec(7));
    }
}
