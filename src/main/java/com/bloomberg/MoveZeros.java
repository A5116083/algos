package com.bloomberg;

public class MoveZeros {

    static void moveZeroesToEnd(int[] nums) {

        int nonZeroPos=0;

        for(int i=0; i< nums.length;i++){
            if(nums[i]!=0){
                nums[nonZeroPos++]= nums[i];
            }
        }

        for(;nonZeroPos<nums.length;nonZeroPos++){
            nums[nonZeroPos]=0;
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{0,1,0,3,12};

        moveZeroesToEnd(arr);
        for (int i=0;i< arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}
