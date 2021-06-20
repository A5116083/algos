package com.company.Stack;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class StackBasedOnQueue {

    public static void main(String[] args) {

        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());
        s.pop();
        System.out.println(s.top());

        System.out.println("current size: " + s.size());

    }

    static class Stack {

        int currentSize;

        Queue<Integer> q1 = new ArrayBlockingQueue<Integer>(10);
        Queue<Integer> q2 = new ArrayBlockingQueue<Integer>(10);

        void push(int value) {

            currentSize++;
            q2.add(value);
            while (!q1.isEmpty()) {

                int temp = q1.remove();
                q2.add(temp);
            }
            Queue<Integer> q = q1;
            q1 = q2;
            q2 = q;

        }

        void pop() {

            if (q1.isEmpty())
                return;
            q1.remove();
            currentSize--;
        }

        public int top() {

            if (q1.isEmpty())
                return -1;
            return q1.peek();
        }

        public int size(){
            return currentSize;
        }
    }
}
