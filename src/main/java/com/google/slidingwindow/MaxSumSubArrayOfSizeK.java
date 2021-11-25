package com.google.slidingwindow;


/*
        Input: [2, 1, 5, 1, 3, 2], k=3
        Output: 9
        Explanation: Subarray with maximum sum is [5, 1, 3].
*/

public class MaxSumSubArrayOfSizeK {

    private static int findMaxSum(int[] arr, int k){

        int sum=0, windowsum=0,windowstart=0;
        for (int i=0; i< arr.length;i++){
            windowsum += arr[i];
            if(i >=k-1){
                sum= Math.max(windowsum,sum);
                windowsum-=arr[windowstart];
                windowstart++;
            }

        }

        return sum;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,1,3,2};
        int k=3;

        System.out.println(findMaxSum(arr,k));
    }
}
