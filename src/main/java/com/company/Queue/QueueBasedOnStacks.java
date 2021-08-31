package com.company.Queue;

import java.util.Stack;

public class QueueBasedOnStacks {


    public class Queue{

        Stack<Integer> s1= new Stack<>();
        Stack<Integer> s2= new Stack<>();

        public void enque(int value){

            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(value);
            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }

        }

        public void deque(){

            if(s1.isEmpty())
                return;
            int x = s1.peek();
            s1.pop();
            System.out.println(x + " ");

        }

    }
}
