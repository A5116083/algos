package com.google.BST;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TreeHieghtRecursive {

    public static int treeHeight(Node node){

        if(node==null)return -1;
        return 1 + Math.max(treeHeight(node.getLeftChild()), treeHeight(node.getRightChild()));
    }

    public static void toArray(Node node, int[] items, int index){
        if(node!=null) {
            items[index] = node.getData();
            toArray(node.getLeftChild(), items, 2* index);

            toArray(node.getRightChild(), items, 2* index + 1);

        }
    }




    //Helper recursive function to traverse tree and append all the nodes
    // at k distance into result StringBuilder
    public static StringBuilder findK(Node root, int k, StringBuilder result) {

        if (root == null) return null;

        if (k == 0) {
            result.append(root.getData() + ",");
        }
        else {
            //Decrement k at each step till you reach at the leaf node
            // or when k == 0 then append the Node's data into result string
            findK(root.getLeftChild(), k - 1, result);
            findK(root.getRightChild(), k - 1, result);
        }
        return result;
    }


    public static int[] nodesAtKthDist(Node root, int k){
        int[] items= new int[20];
        toArray(root, items,1);
        int lowerBound =(int) Math.pow(2,k);
        int upperBound = (int) Math.pow(2,k+1);
        return Arrays.copyOfRange(items,lowerBound,upperBound);
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

        System.out.println("Height of Tree " + treeHeight(bsT.getRoot()));


        Arrays.stream(nodesAtKthDist(bsT.getRoot(), 3)).forEach(item-> System.out.print(item + " "));

        System.out.println("\nKth Nodes from root : " + findK(bsT.getRoot(), 3, new StringBuilder()));

    }
}
