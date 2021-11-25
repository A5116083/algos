package com.bloomberg;

import java.util.HashMap;

/*
   Given a string s, find the length of the longest substring without repeating characters.

       Example 1:

       Input: s = "abcabcbb"
       Output: 3
       Explanation: The answer is "abc", with the length of 3.
       Example 2:

       Input: s = "bbbbb"
       Output: 1
       Explanation: The answer is "b", with the length of 1.
       Example 3:

       Input: s = "pwwkew"
       Output: 3
       Explanation: The answer is "wke", with the length of 3.
       Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
       Example 4:

       Input: s = ""
       Output: 0


       Constraints:

       0 <= s.length <= 5 * 104
       s consists of English letters, digits, symbols and spaces.
    */
public class LongestSubString {

    public static int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int ans=0;
         Integer[] chars = new Integer[128];
        while (right < s.length()){
            char r = s.charAt(right);
            Integer index = chars[r];
            if(index != null &&  index >= left && index <right){
                left = index+1;
            }
            ans = Math.max(ans,right-left+1);
            chars[r]= right;
            right++;
        }
        return ans;
    }

    public static int lengthOfLongestSubstring2(String s) {
        int ans=0;
        HashMap<Character,Integer> charMap=  new HashMap<>();
        for(int i=0,j=0; j< s.length();j++){

            if(charMap.containsKey(s.charAt(j))){
                i = Math.max(charMap.get(s.charAt(j)), i);
            }
            ans = Math.max(ans,j-i+1);
            charMap.put(s.charAt(j), j+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring2("pwwkew"));
    }
}
