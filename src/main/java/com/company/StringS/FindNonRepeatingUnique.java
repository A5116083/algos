package com.company.StringS;

import java.util.LinkedHashMap;
import java.util.Map;

public class FindNonRepeatingUnique {

    public static void main(String[] args) {
        int[] arr = { 2,6,2,8, 3, 2, 6, 6,9};
        int minValue= findFirstUnique(arr);
        System.out.println("first non repeating value in array is "+ minValue);
    }

     static int findFirstUnique(int[] arr)
    {

        // write your code here
        Map<Integer,Integer> mapCounter= new LinkedHashMap();
        for (int counter=0; counter< arr.length; counter++){
            if(!mapCounter.containsKey(arr[counter]))
                mapCounter.put(arr[counter], 1);
            else
                mapCounter.put(arr[counter],mapCounter.get(arr[counter]) +1 );
        }
        int result= mapCounter.entrySet().stream().filter(kvp-> kvp.getValue()==1).findFirst().get().getKey();
        return result;
    }
}
