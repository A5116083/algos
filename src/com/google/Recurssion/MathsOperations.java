package com.google.Recurssion;

public class MathsOperations {

    public static void main(String[] args) {
        /*System.out.println("Exponent test of 5 Cube" + exponent(5,3));
        System.out.println("Sum of natural number till 10: " + sumToN(4));
        System.out.println(modulus(14,4));*/
        //printFibonacci(8);

        System.out.println("GCD : " + gcd(48,180));
        System.out.println("lcm is : " + lcm(48,180));
    }

    public static int exponent(int num, int pow){
        if(pow==0){
            return 1;
        }else
            return num * exponent(num, pow-1);

    }
    public static int sumToN(int n){
        if(n==0)
            return 0;
        else
            return n + sumToN(n-1);
    }

    public static int modulus(int divident,int  divisor){

        if(divisor==0)
            return -1;


        if(divident< divisor)
            return divident;
        else
            return modulus(divident-divisor, divisor);
    }

    private static int fibonacci(int n){

        if(n<=1)
            return n;
        else return (fibonacci(n-1) + fibonacci(n-2));
    }

    private static void printFibonacci(int num){

        int i = 0;
        while (i < num) {
            System.out.print(fibonacci(i) + " ");
            i++;
        }

    }

    private static int gcd(int a, int b){

        if(b==a) //base case
            return a ; //
        else if(a > b)
            return gcd(a-b, b);
        else return gcd(a, b-a);

    }

    private static int efficinetGcd(int a, int b){

        if(b==0) //base case
            return a ; //
        else return gcd(b, a% b);

    }
/*

 */
    private static int lcm(int a, int b){

        return (a *b )/ efficinetGcd(a,b);
    }


}
