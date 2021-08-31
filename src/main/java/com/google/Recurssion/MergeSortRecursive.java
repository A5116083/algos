package com.google.Recurssion;

import java.util.Arrays;

public class MergeSortRecursive {

    static int[] A;

    public static void main(String[] args) {
        A = new int[]{9,3,7,5,6,4,8,2};

        mergeSort(1, A.length);

        Arrays.stream(A).forEach(System.out::print);
    }



    public static void mergeSort(int low, int high ){
        //Divide and conquer strategy , divide until there is only one element and the merge from the bottom
        //running time of the Algorithm is O(nlog(n)) i.e 2 Power n elements are merged at n log2(n) times.
        if(low< high){

           int mid = (low+ high)/2;
           mergeSort(low, mid);;
           mergeSort(mid+1, high);
           mergeList(low, mid, high);
        }
    }

    private static void mergeList(int low, int mid, int high){

        //consider merging as two-way merge of two sorted lists,
        //one list will be from low to mid and another from mid to high

        int[] K = new int[(high-low)+1];
        int index=0;
        int m=0;
        int i=low, j=mid+1;
        while (i<=mid && j<=high){
            if(A[i-1]<A[j-1]) {
                K[index++] = A[i-1];
                i++;
            }
            else {
                K[index++] = A[j-1];
                j++;
            }
        }
        for(;i<=mid; i++)
            K[index++]=A[i-1];
        for(;j<=high; j++)
            K[index++]=A[j-1];
        for(int count=low; count<= high;count++){
            A[count-1]= K[m++];

        }

    }
}
