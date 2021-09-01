package com.company.dynamic;

import java.util.ArrayList;
import java.util.List;

public class PrintBalancedBraces {
//The runtime complexity of this solution is exponential, 2^n2
//​n
//​​ .

    private static ArrayList<ArrayList<Character>> printBraces(int num){

        ArrayList<ArrayList<Character>> result = new ArrayList<>();
        ArrayList<Character> output = new ArrayList<>();
        printBraceRecursive(num,0,0,output,result);
        return result;

    }

    private static void printBraceRecursive(int n, int leftCount, int rightCount, ArrayList<Character> output, ArrayList<ArrayList<Character>> result){

        if(leftCount >= n && rightCount >=n){
            result.add((ArrayList)output.clone());
        }

        if(leftCount< n){
            output.add('{');
            printBraceRecursive(n,leftCount+1,rightCount,output,result);
            output.remove(output.size()-1);
        }

        if(rightCount <leftCount ){
            output.add('}');
            printBraceRecursive(n,leftCount,rightCount+1,output,result);
            output.remove(output.size()-1);
        }

    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Character>> result =  printBraces(2);
        System.out.println("All possible combinations");
        System.out.println(result);
    }

}
