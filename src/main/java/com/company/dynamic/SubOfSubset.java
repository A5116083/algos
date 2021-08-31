package com.company.dynamic;


public class SubOfSubset {

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
        for (int i = 0; i <= n; i++) {
            StringBuilder strBuilder = new StringBuilder();
            strBuilder.append("i: " + i+ " ");
            for (int j = 0; j <= sum; j++) {
                // System.out.println (subset[i][j]);
                strBuilder.append(subset[i][j]+ " ");
            }
            System.out.println(strBuilder.toString());
        }

        return subset[n][sum];
    }
}
