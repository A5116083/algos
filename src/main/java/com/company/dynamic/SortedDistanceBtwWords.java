package com.company.dynamic;

public class SortedDistanceBtwWords {

    public static void main(String[] args) {
        String sentence = "the quick the brown quick brown the frog";
        String w1 = "quick";
        String  w2 = "frog";
        int distance = findSortedDistance(sentence, w1, w2);
        System.out.println("Distance "+ distance);
    }


    public static int findSortedDistance(String sentence, String w1, String w2){

        if(w1.equals(w2))
            return 0;

        if(sentence==null || sentence.length()==0)
            return 0;

        String[] splittedStr= sentence.split(" ");
        int prev=0 ;
        int distance =0;
        for (int index=0; index<splittedStr.length; index++){

            if(splittedStr[index].equals(w1) || splittedStr[index].equals(w2)){
                prev= index;
                break;
            }

        }
        for(int index= prev+1; index < splittedStr.length; index++){
            if(splittedStr[index].equals(w1) || splittedStr[index].equals(w2)){
                if(splittedStr[index].equals(splittedStr[prev])) //means duplicate string
                {
                    prev = index;
                    continue;
                }

                distance = Math.abs(index- prev)-1;
                break;
            }
        }
        return distance;

    }


}
