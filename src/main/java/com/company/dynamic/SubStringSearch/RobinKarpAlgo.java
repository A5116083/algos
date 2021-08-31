package com.company.dynamic.SubStringSearch;

public class RobinKarpAlgo {


    public static void main(String[] args) {
        String SearchString= "ABABDABACDABABCABAB";
        String pattern ="ABABCABAB";

        findSubString(SearchString, pattern);

    }
    private static void findSubString(String searchStr, String pattern){

        int i=0;
        char[] arr= searchStr.toCharArray();
        //double hash= hashKeyNew(pattern);
        int hash= hashKey(pattern);
        int m= pattern.length();
        while (i< arr.length){

            if(arr.length-i< m)
                return;
            String subSeq= searchStr.substring(i,i+m);
           // Double subSeqHash = hashKeyNew(subSeq);
            int subSeqHash = hashKey(subSeq);
            //if(Double.compare(subSeqHash, hash)==0D){
            if(hash==subSeqHash){
                //means both has are equal , then compare the string in substring ;
                if(subSeq.equals(pattern))
                    System.out.println("Foud sequence at start index : "+ i);
            }
            i++;
        }
    }

    /*
    If hash function is weak then there will be issue of supurious hits , where hashcode matches and value doesn't match.
    So better to have strong hash function which avoids the hash collisions
     */
    private static int hashKey(String pattern){
        int hash=31;
        char[] arr= pattern.toCharArray();
        for (int i=0; i< arr.length; i++){
            hash += 31*hash + new Character(arr[i]).hashCode();
        }
        return hash & 0x7FFFFFFF;
    }

    private static double hashKeyNew(String pattern){
        double hash=1;
        char[] arr= pattern.toCharArray();
        int m= arr.length;
        //formula
        //SUM = acsi * Math.Power(27, m-1)
        for (int i=0; i< arr.length; i++){

            int asci= (int) arr[i];
            hash = asci * Math.pow(10, m-1) ;

        }
        return hash;
    }
}

