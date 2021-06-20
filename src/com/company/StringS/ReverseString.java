package com.company.StringS;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

public class ReverseString {

    public static void main(String[] args) {
        String seq = "getting good at coding needs a lot of practice";

        String resp = reverseString(seq);
        System.out.println(resp);
    }

    public static String reverseString(String input) {

        Stack<String> stringStack = new StringStack();
        StringBuilder retunString = new StringBuilder();
        String[] splittedStr = input.split(" ");
        //split("-|\\."); split string on multiple delimiter
        for (int i = 0; i < splittedStr.length; i++) {
            stringStack.push(splittedStr[i]);
        }
        for (int i = 0; i < splittedStr.length; i++) {
            retunString.append(stringStack.pop() + " ");
        }
        return retunString.toString().trim();
    }
}
