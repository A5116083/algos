package com.company.dynamic.SubStringSearch;



public class KMPAlgo {

    public static void main(String[] args) {
        String SearchString= "ABABDABACDABABCABAB";
        String pattern ="ABABCABAB";
        int[] lps= computeLPS(pattern, pattern.length());
       // System.out.print(lps);
        findSubString(SearchString, pattern, lps);


    }

    private static void findSubString(String searchString, String pattern, int[] lps) {

        int i = 0;
        int j = 0;

        char[] A = searchString.toCharArray();
        char[] B = pattern.toCharArray();
        int m = A.length;
        int n = B.length;
        while (i < m) {
            if (A[i] == B[j]) {
                i++;
                j++;
            }
            if (j == n) {
                System.out.println("Found patter at index : " + (i - j));
                j = lps[j - 1];
            } else if (A[i] != B[j]) {
                if (j != 0) { //since A[i]!=B[j] , keep i at the current position and move j back to lps[j-1]
                    j = lps[j - 1];
                } else
                    i++; //increment i only as J is already at 0

            }
        }
    }




    private static int[] computeLPS(String pattern, int M){

        int[] lps= new int[M];

        int i=1;
        int len=0;
        lps[0]=0;
        while(i< M){
            if(pattern.charAt(i)== pattern.charAt(len)){ //if current index is equal to lps[length], means pattern exist before
                len++;
                lps[i]= len;
                i++;

            }else {

                if(len!=0){ //if(length is not equal to Zero, don't increment i here. Go back until start of the pattern
                    len = lps[len-1];
                }else {
                    lps[i]= len;
                    i++;
                }

            }
        }
        return lps;
    }
}
