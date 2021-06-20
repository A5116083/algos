package com.company.sorting;

import java.util.Arrays;
import java.util.Comparator;

//Given the array find the largest number which can be formed
public class LargestNumFromArr {


    public static void main(String[] args) {

        String[] arr = {"54", "546", "548", "60"};
        String[] res = findLargestNumber(arr);

        for (int i =0; i < res.length;i++){
            System.out.print(res[i]);
        }


    }
    private static String[] findLargestNumber(String[] arr){

        Arrays.sort(arr, (X, Y) -> {

            String XY = X+Y;
            String YX = Y+X;

            return  XY.compareTo(YX) > 0 ? -1:0;

        });

        return arr;

    }
}
