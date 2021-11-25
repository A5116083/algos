package com.bloomberg;

public class FirstUniqueChar {

    static int firstUniqCharInStr(String s) {

        int[] chars= new int[26];

        for(int i=0;i < s.length();i++){
            int index = Math.abs('a'- s.charAt(i));
            if(chars[index]==0)
                chars[index]= i+1;
            else chars[index] =-2;
        }

        for(int j=0;j< s.length(); j++){
            int index = Math.abs('a'- s.charAt(j));
            if(chars[index] > 0)
                return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        String s1= "loveleetcode";
        String s3 = "aabb";
        System.out.println(firstUniqCharInStr(s));
        System.out.println(firstUniqCharInStr(s1));
        System.out.println(firstUniqCharInStr(s3));
    }
}
