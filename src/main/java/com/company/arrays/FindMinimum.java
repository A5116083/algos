package com.company.arrays;

public class FindMinimum {

    public static void main(String[] args) {
        int[] arr = {6,7,6,8,5,7,2,3,4};
        int minValue= findMinimum(arr);
        System.out.println("lowest value is "+ minValue);
    }


    static int findMinimum(int[] arr){

        int minValue= arr[0];
        for (int counter=0; counter< arr.length; counter++){
            if(arr[counter]<= minValue)
                minValue= arr[counter];
        }
        return minValue;
    }
}
