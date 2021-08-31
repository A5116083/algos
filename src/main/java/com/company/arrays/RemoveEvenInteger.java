package com.company.arrays;

public class RemoveEvenInteger {


    public static void main(String[] args) {

        int[] inputArr= {1,2,4,5,10,6,3};
        int[] returnArray = removeEven(inputArr);

        for (int index=0; index< returnArray.length; index++){
            System.out.printf(returnArray[index]+  " ");
        }
    }

    static int [] removeEven(int[] arr){
        int evenNumberCounter=0;
        for (int index=0; index< arr.length; index++){
            if(arr[index] % 2==0){
                arr[index]= -1;
                evenNumberCounter++;
            }
        }
        int returnedArrLength= arr.length- evenNumberCounter;
        if(returnedArrLength==0)
            return new int[0];
        int[] returnArray = new int[returnedArrLength];
        int counter= 0;
        for (int index=0; index< arr.length; index++){
            if(arr[index]!= -1 ){
                returnArray[counter]= arr[index];
                counter++;
            }
        }
        return returnArray;

    }
}
