package com.google.Recurssion.LinkedListProblems;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {


    public class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
        public Node(int value, Node nextNode) {
            this.value = value;
            this.next = nextNode;
        }
    }

    private Node head;
    private Node tail;

    public Node insertAtHead(Node headNode, int value){

        if(headNode==null) {
            headNode = new Node(value, null);
            return headNode;
        }else {

            Node newNode = new Node(value, headNode);
            return newNode;
        }
    }
    public Node insertAtTail(Node headNode, int value){
        if(headNode==null) {
            headNode = new Node(value, null);
            return headNode;
        }else {

            Node newNode = new Node(value);
            headNode.next = newNode;
            return newNode;
        }
    }
    public void insertAfter(Node current, int afterNodeValue, int data){

        if(current==null)
            return ;
        else {
            if(current.value== afterNodeValue){
                Node temp = current.next;
                Node newNode = new Node(data, temp);
                current.next = newNode;
                return;
            }else
                insertAfter(current.next, afterNodeValue, data);
        }

    }
    public void printList(Node head){

        if(head==null)
            return;
        else {
            System.out.print(head.value + " ");
            printList(head.next);
        }

    }
    public void printReverseList(Node head){

        if(head==null)
            return;
        else {

            printReverseList(head.next);
            System.out.print(head.value + " ");
        }

    }
    public int sum(Node head){

        if(head==null)
            return 0;
        else {
           return head.value + sum(head.next);
        }
    }
    public int product(Node head){

        if(head==null)
            return 1;
        else {
            return head.value * product(head.next);
        }
    }
    public int get(Node current, int value){

        if(current== null)
            return  -1;
        else {
            if(current.value== value)
                return value;
            else return get(current.next, value);
        }

    }
    public Node deleteAtHead(Node head){

        if(head!=null){
            Node temp = head.next;
            head = null;
            return temp;
        }
        else return head;
    }
    public void deleteNodeWithValue(Node current, Node prev,  int val){
        if(current==null)
            return;
        else {
            if(current.value== val){
                prev.next = current.next;
                current= null;
                return;
            }else deleteNodeWithValue(current.next, current, val);
        }

    }

    public Node reverse(Node head){

        Node current= head;
        Node prev = null;
        Node next = null;

        while (current.next!=null){
            next = current.next;
            current.next = prev;
            prev= current;
            current = next;
        }

        return prev;
    }
    public boolean detectCyle(Node head){
        Node fast= head;
        Node slow= head;
        while (fast!=null && slow!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast==slow)
                return true;
        }
        return false;
    }

    public Node findMiddleNode(Node head){

        Node fast= head;
        Node slow= head;
        while (fast!=null && slow!=null && fast.next!=null){
            fast= fast.next.next;

            if(fast!=null)
                slow = slow.next;

        }
        return slow;
    }

    public Node removeDuplicates(Node head){
        Set<Integer> unique = new HashSet<>();
        Node current= head;
        while (current!=null && current.next!=null){

            unique.add(current.value);

            if(unique.contains(current.next.value)) {
                    current.next= current.next.next;
            }
            else current= current.next;
        }
        return head;
    }




}
