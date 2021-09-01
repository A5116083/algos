package com.company.dynamic;

import java.util.Arrays;

public class CoinChanging {

    public static int solveCoinChange(int[] arr, int amount){
        int[] solution = new int[amount +1];
        solution[0] =1;

        for(int den:arr){
            for (int i=den;i<solution.length;i++){
                solution[i] +=solution[i-den];
            }

        }
        return solution[amount];
    }

    public static void main(String[] args) {

        int[] denominations = new int[] {1, 3, 5};
        int amount = 7;
        int result = solveCoinChange(denominations, amount);
        System.out.print("SolveCoinChange(" + Arrays.toString(denominations) +  ", " + amount + ") = ");
        System.out.print(result);
    }
}
