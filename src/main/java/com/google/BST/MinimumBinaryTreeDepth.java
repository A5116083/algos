package com.google.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class MinimumBinaryTreeDepth {

    /*
    Find the minimum depth of a binary tree. The minimum depth is the number of nodes along the shortest path from the root node to the nearest leaf node.
    This problem follows the Binary Tree Level Order Traversal pattern.
    We can follow the same BFS approach. The only difference will be, instead of keeping track of all the nodes in a level, we will only track the depth of the tree.
    As soon as we find our first leaf node, that level will represent the minimum depth of the tree.
     */

    private static int findMinDepth(Node node){
        List<Double> result = new ArrayList<>();
        if(node==null) return 0;
        int depth=0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            depth++;
            int currentLevel = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>(currentLevel);
            for(int i=0; i< currentLevel;i++){
                Node currentNode = queue.poll();

                if(currentNode.getLeftChild()==null && currentNode.getLeftChild()==null)
                        return depth;


                if(currentNode.getLeftChild()!=null)
                    queue.offer(currentNode.getLeftChild());
                if(currentNode.getRightChild()!=null)
                    queue.offer(currentNode.getRightChild());
            }

            result.add(currentLevelNodes.stream().collect(Collectors.averagingInt(x-> Integer.parseInt(x.toString()))));

        }
        return depth;
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();

        bsT.add(12);
        bsT.add(11);
        bsT.add(40);
        bsT.add(5);
        bsT.add(45);
        bsT.add(30);
        bsT.add(20);
        bsT.add(10);
        bsT.add(50);


        int depth= findMinDepth(bsT.getRoot());
        System.out.println("Tree depth on min path :" + depth);

    }
}
