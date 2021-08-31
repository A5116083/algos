package com.company.sorting;

public class MergeSort {

    static int[] A ;

    public static void main(String[] args) {
        A = new int[]{9,3,7,5,6,4,8,2,10};
        merge(1,A.length);
        for (int count=0; count<A.length; count++)
        {
            System.out.println(A[count]);
        }
    }

    private static void merge(int l, int h){

        if(l<h){ //means there are two items in the list
              int mid = (l+h)/2;
              merge(l,mid);;
              merge(mid+1, h);
              mergeList(l,mid,h);
        }
    }

    static void mergeList(int l, int mid, int h){

        int[] K = new int[h-l+1];
        int index=0;
        int m=0;
        int i=l, j=mid+1;
        while (i<=mid && j<=h){
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
        for(;j<=h; j++)
            K[index++]=A[j-1];
        for(int count=l; count<= h;count++){
            A[count-1]= K[m];
            m++;
        }


    }
}
