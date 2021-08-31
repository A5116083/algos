package com.company.arrays;

import java.util.Arrays;

public class TwoSumSortedArrayInput {


    public static boolean isThereSum(int[] inputArr, int value){
        Arrays.sort(inputArr);
        int i = 0;
        int j = inputArr.length-1;
        while (i< j){
            int sum = inputArr[i] + inputArr[j];
            if(sum== value) {
                System.out.println("a: "  + inputArr[i] + " b: " + inputArr[j] );
                return true;
            }
            if(sum< value){
                i++;
            }else j--;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] input = new int[]{2,4,8,5,6,3,2,9};
        System.out.println("Is there a num who's sum is 15 : "  + isThereSum(input, 15));
    }

}
