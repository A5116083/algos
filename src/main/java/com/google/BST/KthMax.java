package com.google.BST;

import java.util.ArrayList;
import java.util.List;

public class KthMax {
    static int counter=0;
    public static int findKthMax(Node root, int k) {
        List<Integer> result = inOrderTraversal(root, new ArrayList<Integer>());
        if ((result.size() - k) >= 0) return result.get(result.size() - k);
        return - 1;
    }


    public static List<Integer> inOrderTraversal(Node root, List<Integer> result) {

        if(root.getLeftChild()!=null) inOrderTraversal(root.getLeftChild(), result);
         result.add(root.getData());
        if(root.getRightChild()!=null) inOrderTraversal(root.getRightChild(), result);
        return result;
    }


    public static Node findKthMaxRecursive(Node root, int k){
        if(root==null) return null;
        //go the right most child
        Node current= findKthMaxRecursive(root.getRightChild(), k);

        if(counter!=k){
            counter++;
            current=root;
        }

        if(counter==k)
            return current;
        else return findKthMaxRecursive(root.getLeftChild(), k);


    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);

        System.out.println(findKthMax(bsT.getRoot(),3));

        Node current = findKthMaxRecursive(bsT.getRoot(), 4);

        if(current!=null) System.out.println("Kth Max " + current.getData());
        else System.out.println("Not found");
    }
}
