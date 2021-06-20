package com.company.sorting;

import java.util.Arrays;

public class WaveSort {


    public static void main(String[] args) {
        int[] inputArr= {10, 5, 6, 3, 2, 20, 100, 80};
        int[] res= waveSort(inputArr);
        for (int i=0; i< res.length; i++){
            System.out.print( res[i] + " ");
        }
    }
    private static int[] waveSort(int[] inputArray){

        Arrays.sort(inputArray);

        for (int i=1; i < inputArray.length; i=i+2){

            int temp = inputArray[i-1];
            inputArray[i-1]= inputArray[i];
            inputArray[i]= temp;
        }
        return inputArray;
    }
}
