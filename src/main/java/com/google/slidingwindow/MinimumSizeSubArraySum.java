package com.google.slidingwindow;

/*
        Given an array of positive numbers and a positive number ‘S,’
        find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
        Return 0 if no such subarray exists.
        Input: [2, 1, 5, 2, 3, 2], S=7
        Output: 2
        Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

        Time complexity :O(N + N ) = O(N)
*/
public class MinimumSizeSubArraySum {

    public static int findMinSizeSubArr(int S, int[] arr){

        int windowSum=0;
        int startPos=0;
        int minLength=Integer.MAX_VALUE;

        for(int endpos=0;endpos < arr.length;endpos++){

            windowSum+= arr[endpos];

            while (windowSum >= S){
                minLength = Math.min(minLength, endpos-startPos+1);
                windowSum-=arr[startPos];
                startPos++;
            }
        }
        return minLength==Integer.MAX_VALUE? 0: minLength;
    }

    public static void main(String[] args) {

        int result = findMinSizeSubArr(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Array of min length : " + result);
    }
}
