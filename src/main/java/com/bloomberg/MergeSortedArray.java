package com.bloomberg;

public class MergeSortedArray {

    static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0;
        int j=0;
        int k=0;
        int[] numcopy= new int[m+n];
        while(i <m && j < n ){

            if(nums1[i] < nums2[j] ){
                numcopy[k++]= nums1[i++];
            }else {
                numcopy[k++]= nums2[j++];
            }
        }

        while(i<m){
            numcopy[k++]= nums1[i++];
        }
        while(j<n){
            numcopy[k++]= nums2[j++];
        }

        for(int a=0;a< numcopy.length;a++){
            nums1[a]= numcopy[a];
        }
    }

    public static void main(String[] args) {
        int[] a  = new int[]{1,2,3,0,0,0};
        int[] b = new int[] {2,5,6};
        merge(a,3,b,3);

        for (int i=0;i< a.length;i++){
            System.out.print(a[i]+ " ");
        }
    }
}
