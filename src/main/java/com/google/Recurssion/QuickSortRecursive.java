package com.google.Recurssion;

import java.util.Arrays;

public class QuickSortRecursive {

    static int[] A;

    public static void main(String[] args) {

        A = new int[]{2,5,3,4,8,7,9,6,1,0};
        mergeSort(0,A.length-1);

        Arrays.stream(A).forEach(System.out::print);
    }

    private static void mergeSort(int low, int high){

        if(low< high){

            int partition = partition(low, high);
            mergeSort(low, partition-1);
            mergeSort(partition+1, high);
        }
    }
    private static int partition(int l, int h){

        int pivot = A[l];
        int i =l; int j= h;
        while(i < j){

            do{
                i++;
            } while (A[i]<= pivot);

            do{
                j--;
            } while (A[j] > pivot);
            if(i<j)
                swap(i,j);
        }
        swap(l,j);

        return j;


    }

    private static void swap(int i, int j){
        int temp = A[i];
        A[i]= A[j];
        A[j]= temp;
    }
}
