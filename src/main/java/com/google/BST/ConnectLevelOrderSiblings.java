package com.google.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class ConnectLevelOrderSiblings {

    private static List<LinkedList<Node>> levelOrderSiblings(Node node){
        List<LinkedList<Node>> result = new ArrayList<>();
        if(node==null) return result ;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            LinkedList<Node> currentLevelNodes = new LinkedList();
            for(int i=0; i< currentLevel;i++){
                Node currentNode = queue.poll();
                currentLevelNodes.add(currentNode);
                if(currentNode.getLeftChild()!=null)
                    queue.offer(currentNode.getLeftChild());
                if(currentNode.getRightChild()!=null)
                    queue.offer(currentNode.getRightChild());
            }
            result.add(currentLevelNodes);

        }
        return result;
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

        List<LinkedList<Node>> nodesByLevel= levelOrderSiblings(bsT.getRoot());
        for (int i=0; i< nodesByLevel.size();i++) {
            StringBuilder levelNodes = new StringBuilder();
            LinkedList<Node> currentLst = nodesByLevel.get(i);
            while (!currentLst.isEmpty()) {
                levelNodes.append(String.valueOf(currentLst.poll().getData()) + ",");
            }
            System.out.println("Current Level " + i + "Nodes at this level :" + levelNodes);

        }
    }
}
