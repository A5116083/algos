package com.google.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LevelOrderSuccessor {

    private static Integer getSuccessor(Node node, int k){
        if(node==null) return null ;
        Node successor= node;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for(int i=0; i< currentLevel;i++){
                Node currentNode = queue.poll();
                if(currentNode.getLeftChild()!=null)
                    queue.offer(currentNode.getLeftChild());
                if(currentNode.getRightChild()!=null)
                    queue.offer(currentNode.getRightChild());
                if(currentNode.getData()==k) {
                    successor = queue.peek();
                    break;
                }
            }

        }
        return successor.getData();
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

        System.out.println("Successor of 4 is : " + getSuccessor(bsT.getRoot(), 4));
    }
}
