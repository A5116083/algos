package com.google.Recurssion.LinkedListProblems;

import java.sql.SQLOutput;

public class LinkedListDriver {

    public static void main(String[] args) {


        LinkedList lst = new LinkedList();


        LinkedList.Node head=
                lst.insertAtHead(null, 5);
        head= lst.insertAtHead(head, 4);
        head= lst.insertAtHead(head, 3);
        head= lst.insertAtHead(head, 3);
        head= lst.insertAtHead(head, 2);
        head= lst.insertAtHead(head, 1);
        head= lst.insertAtHead(head, 1);
        lst.insertAfter(head, 5,6);

        //lst.deleteNodeWithValue(head,null, 5);
        //head= lst.insertAtHead(head, 0);
        //head=  lst.reverse(head);
        //LinkedList.Node midleNode=  lst.findMiddleNode(head);
        //lst.printList(head);
        //System.out.println("\nMiddle node is : "+ midleNode.value);
        //lst.removeDuplicates(head);
        lst.printList(lst.removeDuplicates(head));
        /*System.out.println("\nReverse list");
        lst.printReverseList(head);
        */
       /* System.out.println("\nSum of all items in list: " + lst.sum(head));
        System.out.println("\nProduct of all items in list: " + lst.product(head));
        System.out.println("Find node 4: " +(lst.get(head, 4)> 0 ? "contains the value": "doesnt contains the value"));*/
    }
}
