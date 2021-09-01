package com.company.dynamic.LeastCommonSubSeq;

public class UsingMemozation {




    public static void main(String[] args) {

        String s1= "abdca";
        String s2= "cbda";
        char[] A= s1.toCharArray();
        char[] B= s2.toCharArray();
        int m= A.length;
        int n= B.length;

        int[][] result = lcs(A,B, m,n);
        System.out.println("LCS of String: "+ result[m][n]);
        printSubSeq(result, A, B, m, n);

    }

    private static int[][] lcs(char[] A, char[] B, int m, int n) {

        int[][] L = new int[m + 1][n + 1];

            for (int i = 0; i <= m; i++)
                for (int j = 0; j <= n; j++) {

                    if (i == 0 || j == 0)
                        L[i][j] = 0;
                    else if (A[i-1] == B[j-1])
                        L[i][j] =  L[i -1][j -1]+1;
                    else L[i][j] = Math.max(L[i -1][j], L[i][j - 1]);

                }

        return L;
    }

    static void printSubSeq(int[][] LCS, char[] A, char[] B,  int m, int n){

        int index = LCS[m][n];
        int temp= index;
        char[] subSeq= new char[index+1];
        subSeq[index]='\0';

        int i = m;
        int j = n;
        while(i>0 && j> 0){

            if(A[i-1]==B[j-1]){
                subSeq[index-1]=A[i-1];
                index--;
                i--;
                j--;

            }else if(LCS[i-1][j] > LCS[i][j-1]){
                i--;

            }else{
                j--;
            }
        }

        System.out.println("LCS is : "+ new String(subSeq));

    }

}
