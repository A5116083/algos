package com.google.Sorting;

import java.util.ArrayList;
import java.util.List;

public class TwoWayMerge {

    public static void main(String[] args) {
        int[] ar1 = new int[]{2,4,6,8,10};
        int[] ar2 = new int[]{1,3,5,7,9,11,13};
        int[] ar3 = new int[]{12,14,16,18,20};
        int[] ar4 = new int[]{15,17,19,21,23};
        int[][] mArray = new int[][]{ar1,ar2,ar3,ar4};
        /*int[] merged=  merge(ar1, ar2);
        for (int count=0; count< merged.length; count++)
            System.out.print(merged[count] + " ");*/

        int[] merged=  mWayMerge(mArray,0);
        for (int count=0; count< merged.length; count++)
            System.out.print(merged[count] + " ");
    }


    public static int[] merge(int[] A, int[] B){

        int m = A.length;
        int n= B.length;

        int[] C = new int[m+n];
        int i=0,j=0,k=0;
        while (i < m && j < m){
            if(A[i] < B[j]){
                C[k++]= A[i++];
            }else
                C[k++]= B[j++];
        }

        for(;i< m;i++ )
            C[k++]= A[i];

        for(;j<n;j++)
            C[k++]= B[j];

        return C;
    }

    public static int[] mWayMerge(int[][] mArray, int current){

        if(( mArray.length-current) ==2){
            return merge(mArray[current], mArray[current+1]);
        }else {
            current++;
            return mWayMerge(mArray, current );
        }

    }

}
