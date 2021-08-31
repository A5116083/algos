package com.company.dynamic;

public class Fibonacci {
//The runtime complexity of this solution is exponential, O(2^n)O(2
//​n
//​​ ).
    static int getFibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    }

    static  int getFibonacciIterative(int n){
        if(n==0 || n==1)
            return n;
        int num1 =0;
        int num2 =1;
        int res=0;
        for (int i =2;i< n;i++){
            res = num1+ num2;
            num2=i;
            num1=res;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] inputs = {1, 5, 7, 10};

        for (int i = 0; i < inputs.length; i++){
            System.out.println("getFibonacci(" + inputs[i] + ") = " + getFibonacci(inputs[i]));
        }

        for (int i = 0; i < inputs.length; i++){
            System.out.println("getFibonacciIterative(" + inputs[i] + ") = " + getFibonacci(inputs[i]));
        }
    }

}
