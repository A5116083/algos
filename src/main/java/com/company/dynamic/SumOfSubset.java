package com.company.dynamic;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SumOfSubset {

    /* Driver code*/
    public static void main(String args[]) {

        int set[] = {3, 4, 5, 2};
        int sum = 6;
        int n = set.length;
        if (isSumSubSet(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
        List<HashSet<Integer>> result=  subSetEqualsSum(set,sum);
        System.out.println(result);

    }

    // Returns true if there is a subset of
    // set[] with sun equal to given sum
    private static boolean isSumSubSet(int set[],
                             int n, int sum) {

        boolean[][] subset = new boolean[n + 1][sum + 1];

        //set all [i,0] as true -> bcz 0 can be formed with 0 items
        for (int i = 0; i < n; i++) {
            subset[i][0] = true;
        }


        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {

                subset[i][j] = subset[i - 1][j];// copy from upper cell;
                if (j >= set[i - 1]) {
                    subset[i][j] = subset[i - 1][j] || subset[i - 1][j - set[i - 1]];
                }
            }
        }


        // uncomment this code to print table
        /*for (int i = 0; i <= n; i++) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("i: " + i+ " ");
            for (int j = 0; j <= sum; j++) {
                // System.out.println (subset[i][j]);
                strBuilder.append(subset[i][j]+ " ");
            }
            System.out.println(strBuilder.toString());
        }*/

        return subset[n][sum];
    }
    static int getBit(int num, int bit) {
        int temp = (1<< bit);
        temp = temp & num;
        if (temp == 0) {
            return 0;
        }
        return 1;
    }
    private static List<HashSet<Integer>> subSetEqualsSum(int[] arr, int sum){
        List<HashSet<Integer>> result = new ArrayList<>();
        int size = arr.length;
        int numOfSubSets =(int) Math.pow(2,size);

        for(int i =0;i< numOfSubSets;i++){
            HashSet<Integer> set= new HashSet<>();
            int currentSum =0;
            for(int j=0;j< size;j++){
                if (getBit(i, j) == 1) {//mean that positional set is and all other bits are blocked by masking
                    currentSum += arr[j];
                    if(currentSum>sum)
                        break;
                    set.add(arr[j]);
                }
            }
            if(currentSum == sum) {
                result.add(set);

            }
        }
        return result;
    }
}
