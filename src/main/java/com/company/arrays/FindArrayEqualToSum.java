package com.company.arrays;

import java.util.HashSet;

public class FindArrayEqualToSum {

    public static void main(String[] args) {
        int[] arr= {1, 21, 3, 14, 5, 60, 7, 6};
        int value=19;
        int[] resultantArray= findSum(arr, value);
        //int[] resultantArray= findSum2(arr, value);
        for(int count=0; count< resultantArray.length; count++) {
            System.out.print(resultantArray[count] + " ");
        }


    }
    //running time - O(N) , worst case O(2N)
    static int[] findSum(int[] arr, int n){

        HashSet<Integer> uniqueValues = new HashSet<>();
        for (int count=0; count< arr.length; count++){
            uniqueValues.add(arr[count]);
        }

        for(int count=0; count< arr.length; count++){
           int diff= n- arr[count];
           if(uniqueValues.contains(diff))
               return new int[]{arr[count], diff};
        }
        return null;
    }
    //running time - O(n)
    static int[] findSum2(int[] arr, int n){

        HashSet<Integer> uniqueValues = new HashSet<>();
        for(int count=0; count< arr.length; count++){
            int diff= n- arr[count];
            if(uniqueValues.contains(diff))
                return new int[]{arr[count], diff};
            else uniqueValues.add(arr[count]);
        }
        return new int[]{};
    }
}
