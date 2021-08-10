package com.company.heap;

import java.util.Comparator;

public class MaxHeap {

    public static void main(String[] args) {
        MaxHeap mxHeap = new MaxHeap(10);
        mxHeap.insert(10);
        mxHeap.insert(20);
        mxHeap.insert(30);
        mxHeap.insert(40);
        mxHeap.insert(50);
        mxHeap.insert(60);
        System.out.println("In order ");
        mxHeap.inOrderTraversal(1);
        mxHeap.deleteMax();
        mxHeap.deleteMax();
        mxHeap.deleteMax();
        mxHeap.deleteMax();
        System.out.println("\n After deleting ");

        mxHeap.inOrderTraversal(1);

    }

    Integer[] heap; //stores the element from indices 1 to n
    int capacity;
    int n; // number of items in the heap

    public MaxHeap(int capacity) {
        this.capacity = capacity+1;
        heap = new Integer[this.capacity];
    }

    //1. Insert

    public void insert(int val){
        //insert at the end and adjust upwards
        //then check is heap properties satisfies
        //1. there should not be any gap in the array
        //2. parent is always greater than child
        heap[++n]= val;
        swim(n);
        assert isMaxHeap();
    }

    //2. Delete max item from heap, move the last element to the max position
    //Adjust the heap dop down

    public void deleteMax(){

        int temp = heap[n];
        int max = heap[1];
        heap[n]= max; //stores back the max at last element
        heap[1]= temp;
        n--;
        //swimDown(1);
        sink(1);

    }
    private void sink(int k) {
        while (2*k <= n) {
            int j = 2*k;
            if (j < n && less(j, j+1)) j++;
            if (!less(k, j)) break;
            exch(k, j);
            k = j;
        }
    }
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k, k/2);
            k = k/2;
        }
    }
    private boolean less(int parent, int child) {

        return    heap[child] > heap[parent]   ;
    }
    private boolean greater(int parent, int child) {

        return      heap[child] > heap[parent]    ;
    }
    public void exch(int i, int j){

        int temp = heap[j]; // take prarent
        heap[j]= heap[i];
        heap[i]= temp;
    }

    public boolean isMaxHeap(){

        for (int i = 1; i <= n; i++) {
            if (heap[i] == null) return false; //no gaps
        }
        for (int i = n+1; i < heap.length; i++) {
            if (heap[i] != null) return false; //after last item until legth of heap all items should be empty
        }
        if (heap[0] != null) return false; //first element is null as heap starts from position 1

        return isHeapOrdered(1);

    }
    private boolean isHeapOrdered(int k){
        if(k>n) return true;

        int left = 2*k;

        int right = 2*k +1;

        if(heap[left] > heap[k]  || heap[right] > heap[k]) return false;

        return isHeapOrdered(left) && isHeapOrdered(right);
    }
    //helper functions
    //swim
    //exchange

    //Assuming 1 is root node
    public void inOrderTraversal(int k){

        if(k > n)
            return;
        else{
            int left= 2*k;
            int right = 2*k+1;
            inOrderTraversal(left);
            System.out.print(heap[k] + " ");
            inOrderTraversal(right);
        }
    }
    //Assuming 1 is root node
    public void preOrderTraversal(int k){

        if(k > n)
            return;
        else{
            int left= 2*k;
            int right = 2*k+1;
            System.out.print(heap[k] + " ");
            inOrderTraversal(left);
            inOrderTraversal(right);
        }
    }
    //Assuming 1 is root node
    public void postOrderTraversal(int k){

        if(k > n)
            return;
        else{
            int left= 2*k;
            int right = 2*k+1;
            inOrderTraversal(left);
            inOrderTraversal(right);
            System.out.print(heap[k] + " ");
        }
    }
}
