package com.company.dynamic.LeastCommonSubSeq;

public class UsingRecursion {

    static char[] A;
    static char[] B;

    public static void main(String[] args) {

        /*String s1= "longest\0" ;
        String s2= "stone\0";*/
        String s1= "AGGTAB\0" ;
        String s2= "GXTXAYB\0";

        A= s1.toCharArray();
        B= s2.toCharArray();
        int m=A.length;
        int n=B.length;
          int result = lcs(m,n);
        int result1 = lcs1(0,0);
        System.out.println("LCS is :" + result);
        System.out.println("LCS is :" + result1);
    }

    //bottom up approach
    private static int lcs(int m, int n){

        if(m==0 || m==0)
            return 0;

        if(m-1<0 || n-1 <0)
            return 0;
         if(A[m-1]== B[n-1]){
            return 1+ lcs(m-1, n-1);
        }else
            return Math.max(lcs(m-1, n), lcs(m, n-1));

    }

    //bottom up approach
    private static int lcs1(int i, int j){

        if(A[i]=='\0' || B[j]=='\0')
            return 0;



        if(A[i]== B[j]){
            return 1+ lcs1(i+1, j+1); //If both i & j char are same then check the next one on both string recursively.

        }else
            return Math.max(lcs1(i+1, j), lcs1(i, j+1)); //If both i & j char are NOT same then
        // move one step in first string and move 1 in next string recursively and take maximum ;

    }


}
