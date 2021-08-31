package com.company.arrays;

import java.util.Arrays;

public class ThreeSum {

    public static boolean isThreeSumExist(int[] inputArr, int requiredSum){
        for (int i =0;i< inputArr.length-2;i++){
            int remainingSum = requiredSum- inputArr[i];
           if(TwoSumHashTable.isTwoSum(inputArr,remainingSum,i+1))
               return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 2, 8, 4, 5};

        System.out.println("Original Array: " + Arrays.toString(arr));
        System.out.println("Sum 20 exists: " + isThreeSumExist(arr, 20));
        System.out.println("Sum 10 exists: " + isThreeSumExist(arr, 10));
        System.out.println("Sum 21 exists: " + isThreeSumExist(arr, 21));
    }
}
