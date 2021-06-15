package com.company.arrays;

public class ArrayOfProducts {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4};
        int[] resultantArray= productArray(arr);
        for(int count=0; count< resultantArray.length; count++) {
            System.out.print(resultantArray[count] + " ");
        }

    }


    static int[] productArray(int[] arr){

        int[] productArray = new int[arr.length];
        for (int counter =0; counter< arr.length; counter++ ){
            int leftProduct=1;
            int rightProduct=1;
            for(int left=0; left< counter; left++){
                leftProduct*=arr[left];
            }
            for(int right=counter+1; right < arr.length; right ++){
                rightProduct *= arr[right];
            }
            productArray[counter] = leftProduct*rightProduct;
        }
        return productArray;
    }
}
