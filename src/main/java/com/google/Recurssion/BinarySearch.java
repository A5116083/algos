package com.google.Recurssion;

public class BinarySearch {

    static int[] inputArray;

    public static void main(String[] args) {
        inputArray= new int[]{3,6,8,14,17,19,20,23,25,27,30};

        //System.out.println(binarySearch(0,inputArray.length, 17));

        System.out.println(computeMod(2,3,5));
    }
    private static int binarySearch(int low, int high, int key){ //T(n)

        if(low == high){ // 1  n ==1
            if(key==inputArray[low])
                return low ;
            else return -1;
        }else{
            int mid = (low + high)/2; // n> 1  1
            if(key== inputArray[mid]) return inputArray[mid]; // 1
            if(key< inputArray[mid])
               return binarySearch(low, mid-1, key); //n/2
            else
                return binarySearch(mid+1, high, key);
        }


    }

    private static  int computeMod(int x, int y, int p){

        return ((x%p) * (y % p)) % p;
    }
}

// T(n) = T(n/2) + C
