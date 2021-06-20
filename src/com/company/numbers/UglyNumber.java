package com.company.numbers;

//Ugly numbers are numbers whose only prime factors are 2, 3 or 5.
// The sequence 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15,
// … shows the first 11 ugly numbers. By convention, 1 is included. Write a program to find Nth Ugly Number.
public class UglyNumber {
    public static void main(String[] args) {
        int nth = 150;
        int no = getNthUglyNo(nth);

        // Function call
        System.out.println(nth + " th ugly "
                + "no. is " + no);
    }

    public static int maxDivide(int a , int b){

        while(a%b==0)
            a= a/b;
        return a;
    }

    public static int isUgly(int num){

        num= maxDivide(num, 2);
        num= maxDivide(num, 3);
        num= maxDivide(num,5);

        return  (num== 1) ? 1:0;

    }

    public static int getNthUglyNo(int n){
        int i=1;
        int count=1;

        while(n > count){

            i++;
            if(isUgly(i)==1)
                count++;
        }
        return i;

    }
}
