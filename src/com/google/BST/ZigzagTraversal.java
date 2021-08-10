package com.google.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ZigzagTraversal {


    public static List<List<Integer>> traverseZigzag(Node root){
        List<List<Integer>> results = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();

        if(root==null) return results;

        queue.offer(root);
        int level=0;
        while (!queue.isEmpty()){
            level++;
            int currentSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>(currentSize);

            for (int i=0; i< currentSize;i++){

                Node current = queue.poll();

                if(level%2 ==0)
                    levelNodes.add(0,current.getData());
                else
                    levelNodes.add(current.getData());

                if(current.getLeftChild()!=null)
                    queue.offer(current.getLeftChild());
                if(current.getRightChild()!=null)
                    queue.offer(current.getRightChild());
            }
            results.add(levelNodes);
        }

        return results;

    }

    public static void main(String[] args) {
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


        List<List<Integer>> nodesByLevel= traverseZigzag(bsT.getRoot());
        for (int i=0; i< nodesByLevel.size();i++){
            List<Integer> levelNodes = nodesByLevel.get(i);
            String nodes = levelNodes.stream().map(x->x.toString()).collect(Collectors.joining(","));
            System.out.println("\nLevel "+ (i +1) +" : "+ nodes);
        }
    }

}
