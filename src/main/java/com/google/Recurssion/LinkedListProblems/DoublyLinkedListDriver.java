package com.google.Recurssion.LinkedListProblems;

public class DoublyLinkedListDriver {

    public static void main(String[] args) {
        DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

        dll= dll.insertAtHead( 5);
        dll.insertAtHead( 4)
        .insertAtHead( 3)
        .insertAtHead( 2)
        .insertAtHead(1)
        .insertAtEnd(6)
        .insertAtHead(7);


        dll.printList(dll.getHead());

        System.out.println("\nSize of DLL : " + dll.getSize());
    }
}
