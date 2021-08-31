package com.company.symboltable;

import java.util.HashMap;
  class Node{
    int value;
    int key;
    Node next;
    Node prev;

    public Node() {
    }

    public Node(int key, int value) {
        this.key= key;
        this.value = value;
    }
}
 class Cache{

    int capacity;
    int size= 0;
    Node head, tail= null;
    HashMap<Integer, Node> nodeHashMap;

    public Cache(int capacity) {
        this.capacity = capacity;
        nodeHashMap = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        //head pointing to tail
        head.next = tail;
        //tail prev is head
        tail.prev = head;

        head.prev = null;
        tail.next = null;
    }

    public boolean isEmpty(){
        return capacity==0;
    }

    private void insertAtHead(Node newNode) {
        newNode.next = head.next; //assign current head next
        newNode.next.prev = newNode; //assign current head next , prev to the new node
        newNode.prev = head; //new node prev = head
        head.next = newNode; // current top item is new node
        size++;
    }

    public void removeAtTail(){
        tail.prev = tail.prev.prev;
        tail.prev.next= tail;
        size--;
    }
    private void deleteNode(Node currentNode) {
        currentNode.prev.next = currentNode.next;
        currentNode.next.prev = currentNode.prev;
    }

    public void printCache(Node node){
        if(node.next == null)
            return;
        else{

            if(node.prev!=null)
                System.out.print(node.value + " ");
            printCache(node.next);

        }
    }
    //1. If key is present , take current node, remove from linked list and put it again at head
    //2. if key is not present, then check the capacity, if there is allowed capacity then insert at head
    //if capacity is full, then remove from tail used and put a new item at the head

    public void put(int key, int value){
        if(nodeHashMap.containsKey(key)){
            Node currentNode = nodeHashMap.get(key);
            currentNode.value = value;
            deleteNode(currentNode);
            insertAtHead(currentNode);
        }else {

            Node node = new Node(key,value);
            nodeHashMap.put(key, node);

            if(size < capacity ){

                insertAtHead(node);
            }else {
                nodeHashMap.remove(tail.prev.key);
                removeAtTail();
                insertAtHead(node);

            }
        }
    }
    public Integer get(int key){
        if(nodeHashMap.containsKey(key)){
            Node currentNode = nodeHashMap.get(key);
            deleteNode(currentNode);
            insertAtHead(currentNode);
            return currentNode.value;
        }
        else return null;
    }
}
public class LRUCache {



    public static void main(String[] args) {
        Cache cache = new Cache(4);
        cache.put(1,11);
        cache.put(2,12);
        cache.put(3,13);
        cache.put(4,14);
        cache.printCache(cache.head);
        System.out.println("");
        System.out.println("Adding a new item after cache is full");
        cache.put(5,15);
        cache.printCache(cache.head);
        System.out.println();
        System.out.println("value of cache with key 3: "+  cache.get(3));
        cache.printCache(cache.head);
        System.out.println("");
        cache.put(4,24);
        System.out.println("cache after updating an entry");
        cache.printCache(cache.head);
        System.out.println("");
        cache.put(6,16);
        cache.printCache(cache.head);
        System.out.println("");


    }
}
