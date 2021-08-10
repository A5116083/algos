package com.google.Recurssion.LinkedListProblems;

public class DoublyLinkedList<T> {


    public class Node<T>{
        T value;
        Node next;
        Node prev;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int size=0;

    public int getSize(){
        return size;
    }

    public Node getHead(){
        return head;
    }
    public Node getTail(){
        return tail;
    }
    //returns true if list is empty
    public boolean isEmpty() {
        if (head == null && tail == null) //checking tailNode to make sure
            return true;
        return false;
    }
    public DoublyLinkedList<T> insertAtHead(T value){

        Node newNode = new Node(value);
        if(this.isEmpty()){
            head = newNode;
            tail = newNode;
        }else{
            newNode.next = head;
            head.prev= newNode;
            this.head = newNode;
        }
        size++;
        return this;
    }
    public DoublyLinkedList<T> insertAtEnd(T value){
        Node newNode = new Node(value);
        if(this.isEmpty()){
            head = newNode;
            tail = newNode;

        }else{
            tail.next= newNode;
            newNode.prev = tail;
            this.tail = newNode;
        }
        size++;
        return this;
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


}
