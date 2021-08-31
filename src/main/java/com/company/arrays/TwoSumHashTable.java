package com.company.arrays;

import java.util.HashSet;

public class TwoSumHashTable {

    public static boolean isTwoSum(int[] inputArr, int requiredSum, int startIndex){
        HashSet<Integer> hashSet= new HashSet<>(inputArr.length);
        for (int i=startIndex; i < inputArr.length;i++){
            hashSet.add(inputArr[i]);
        }

        for (int i=startIndex; i< inputArr.length;i++){
            if(inputArr[i]< requiredSum) {
                int tofind = requiredSum - inputArr[i];
                if(hashSet.contains(tofind)) {
                    //System.out.println("a: " + inputArr[i] + " b: " + tofind);
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2,4,8,5,6,3,2,9};
        System.out.println("Is there a num who's sum is 15 : "  + isTwoSum(input, 15,0));
    }

}
