package com.company.dynamic;

public class KanpSackProblem {

    public static int solveKnapSack(int[] pf, int[] wt, int capacity ){
        int row=pf.length;
        int col = capacity+1;
        int[][] k = new int[row][col];
        for (int i=0; i<= pf.length-1;i++){
            for(int w= 0; w<=capacity;w++){
                //base case
                if(i==0|| w==0)
                    k[i][w]=0;
                else if(wt[i] <= w) { //second case when weight at index i is less than selected weight w
                    k[i][w]= Math.max((pf[i] + k[i-1][w-wt[i]]),k[i-1][w]);

                }else k[i][w]= k[i-1][w]; //copy the the previous row same column
            }
        }
        int i = row-1; int j = capacity;

        while (i>0 && j > 0){
            if(k[i][j] == k[i-1][j]) {
                System.out.println(i + "- " + "0" + "  weight: " + wt[i] );
                i--;
            }
            else {
                System.out.println(i + "- "+ "1" + "  weight: " + wt[i]);

                j= j-wt[i];
                i--;
            }
        }

        return k[row-1][capacity];
    }

    public static void main(String[] args) {
        int[] pf = new int[]{0,1,2,5,6};
        int[] wt = new int[]{0,2,3,4,5};
        int capacity =8;
        System.out.println(solveKnapSack(pf,wt,capacity));
    }
}
