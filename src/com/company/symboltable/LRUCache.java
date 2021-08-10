package com.company.symboltable;

import java.util.HashMap;

public class LRUCache {


    public static class Node{
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

    public static class Cache{

        int capacity;
        int size= 0;
        Node head, tail= null;
        HashMap<Integer, Node> nodeHashMap;

        public Cache(int capacity) {
            this.capacity = capacity;
            nodeHashMap = new HashMap<>();
            head = new Node(0,0);;
            tail = new Node(0,0);;
            head.next = tail;
            tail.prev = head;
            head.prev = null;
            tail.next = null;
        }

        public boolean isEmpty(){
            return head==null && tail== null;
        }

        private void insertAtHead(Node newNode) {
            newNode.next = head.next;
            newNode.next.prev = newNode;
            newNode.prev = head;
            head.next = newNode;
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

        private void printNode(Node node){
            if(node.next == null)
                return;
            else{
                if(node.prev!=null)
                    System.out.print(node.value + " ");
                printNode(node.next);

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
                    size++;
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

    public static void main(String[] args) {
        LRUCache.Cache cache = new LRUCache.Cache(4);

        cache.put(4,44);
        cache.put(3,33);
        cache.put(2,22);
        cache.put(1,11);
        cache.put(5,55);
        cache.put(3,33);
        cache.printNode(cache.head);
    }
}
