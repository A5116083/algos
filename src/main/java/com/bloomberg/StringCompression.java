package com.bloomberg;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCompression {


    static int compress(char[] chars) {

        int[] charsArr= new int[26];
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i < chars.length;i++){
            int index = Math.abs('a'- chars[i]);
            charsArr[index] = charsArr[index]+1;
        }

        for(int i=0;i< chars.length;i++){
            int index = Math.abs('a'- chars[i]);
            if(charsArr[index]>1)
                stringBuilder.append(String.valueOf(chars[i]) + charsArr[index]);
            else stringBuilder.append(String.valueOf(chars[i]));
            while (i+1< chars.length && chars[i]== chars[i+1])
                    i++;
        }
        char[] compressed  = stringBuilder.toString().toCharArray();
        chars= new char[compressed.length];
        for(int i=0; i< compressed.length;i++){
            chars[i]=compressed[i];
        }
        return stringBuilder.length();
    }

    public static void main(String[] args) {
        char[] chars = new char[]{'a','a','b','b','c','c','c'};
        char[] chars1 = new char[]{'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        //System.out.println(compress(chars));
        System.out.println(compress(chars1));

    }
}
