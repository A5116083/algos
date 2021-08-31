package com.company.sorting;

public class QuickSortAlgo {

    public static void main(String[] args) {
        int[] a = {6,5,8,9,3,10,15,12,16};
        QuickSort qs = new QuickSort(a);
        qs.sort(0,a.length-1);

        for (int i=0; i< a.length; i++){
            System.out.print(a[i] + " ");
        }
    }

    public static class QuickSort{

        private int[] A ;

        public QuickSort(int[] a) {
            A = a;
        }

        public void sort(int l, int h){

            if(l< h){

                int p = parition(l,h);
                sort(l,p-1);
                sort(p+1,h);
            }
        }


        private int parition(int l, int h){

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

        private void swap(int i, int j){
            int temp = A[i];
            A[i] = A[j];
            A[j] = temp;
        }
    }
}
