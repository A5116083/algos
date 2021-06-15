package com.company.arrays;

import java.util.Stack;

public class NumToBinary {

    public static void main(String[] args) {

        String binary = toBinary(8);
        System.out.println("Binary representation is : "+ binary);
    }


    static  String toBinary(int num){

        Stack<Integer> binaryNum= new Stack<>();

        while (num>0){
            binaryNum.push(num%2);
            num= num/2;
        }
        StringBuilder stringBuilder = new StringBuilder(20);
        while (!binaryNum.isEmpty()){
            stringBuilder.append(binaryNum.pop().toString());
        }
        return stringBuilder.toString();

    }
}

