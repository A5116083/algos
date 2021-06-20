package com.company.numbers;

public class PrimeNumbers {

    public static void main(String[] args) {
        int n = 37;
         //

        boolean result= isPrime(n);
        System.out.println(result? "number is prime": "number is not prime");

        findPrime(n);
    }

    private static void findPrime(int n){

        boolean[] prime= new boolean[n];
        for (int i =0; i <n; i++){
            prime[i]= true;
        }

        for(int p=2; p*p <=n; p++){

            if(prime[p]){
                for(int i=p*p; i< n; i+=p){
                    prime[i]= false;
                }
            }
        }
         for (int i =2; i < n; i++){
            if(prime[i])
                System.out.println(i);
         }

    }

    private static boolean isPrime(int num){

        if(num<=1)
            return false;

        if(num==2)
            return true;

        if(num%2==0)
            return false;

        for(int i=3; i< Math.sqrt(num);i+=2){
            if(num%i==0)
                return false;
        }
        return true;



    }
}
