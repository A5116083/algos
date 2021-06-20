package com.company.sorting;

public class TwoWayMergeSort {

     public static class TwoWayMerge {


         public int[] merge(int[] A, int[] B){

             int m= A.length;
             int n= B.length;
             int[] K = new int[m+n];
             int index=0;

             int i=0, j=0;
             while (i<m && j<n){
                 if(A[i]<B[j])
                     K[index++]= A[i++];
                 else
                     K[index++]= B[j++];
             }
             for(;i<m; i++)
                 K[index++]=A[i];
             for(;j<n; j++)
                 K[index++]=A[j];
             return K;

         }
     }

    public static void main(String[] args) {
        TwoWayMerge ms = new TwoWayMerge();
        int[] A =new int[] {2,4,6,8,10};
        int[] B =new int[] {1,3,5,7,9};
        int[] result= ms.merge(A,B);

        for (int i=0; i< result.length; i++){
            System.out.println(result[i]);
        }

    }
}
