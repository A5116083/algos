package com.google;

public class StringPermutation {

    public static void main(String[] args) {

        combinations("abc".toCharArray());
    }

    public static void combinations(char[] arr){

        int  n = arr.length;
        //for 2^n times
        for (int i =0; i < (1<<n); i++){

            for(int j=0; j< n; j++){

                if((i & (1<<j)) > 0){

                    System.out.print(arr[j] + " ");
                }

            }
            System.out.println("");
        }
    }
}
