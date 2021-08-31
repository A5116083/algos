package com.google.BST;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.stream.Collectors;

public class LevelOrderTraversal {

    private static List<List<Integer>> levelOrderTraversalByLevel(Node node){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(node==null) return result ;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>(currentLevel);
            for(int i=0; i< currentLevel;i++){
                Node currentNode = queue.poll();
                currentLevelNodes.add(currentNode.getData());
                if(currentNode.getLeftChild()!=null)
                    queue.offer(currentNode.getLeftChild());
                if(currentNode.getRightChild()!=null)
                    queue.offer(currentNode.getRightChild());
            }
            result.add(currentLevelNodes);

        }
        return result;
    }

    private static List<List<Integer>> reversedLevelOrderTraversalByLevel(Node node){
        List<List<Integer>> result =new ArrayList<>();
        //List<List<Integer>> result =new LinkedList<>()
        if(node==null) return result ;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>(currentLevel);
            for(int i=0; i< currentLevel;i++){
                Node currentNode = queue.poll();
                currentLevelNodes.add(currentNode.getData());
                if(currentNode.getLeftChild()!=null)
                    queue.offer(currentNode.getLeftChild());
                if(currentNode.getRightChild()!=null)
                    queue.offer(currentNode.getRightChild());
            }
            result.add(0,currentLevelNodes);

        }

        /*
        Time complexity #
        The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
        This is due to the fact that we traverse each node once.
        Space complexity #
        The space complexity of the above algorithm will be O(N)O(N) as we need to return a list containing the level order traversal.
        We will also need O(N)O(N) space for the queue. Since we can have a maximum of N/2N/2 nodes at any level (this could happen only at the lowest level),
         therefore we will need O(N)O(N) space to store them in the queue.
         */
        return result;
    }

    private static List<Integer> levelOrderTraversal(Node node){
        Queue<Node> nodes = new LinkedBlockingQueue<>();
        List<Integer> inOrderLst = new ArrayList<>();
        if(node==null) return inOrderLst;
        nodes.add(node);
        while (!nodes.isEmpty()) {
            Node current = nodes.poll();
            inOrderLst.add(current.getData());
            if(current.getLeftChild()!=null) nodes.add(current.getLeftChild());
            if(current.getRightChild()!=null) nodes.add(current.getRightChild());
        }
        return inOrderLst;
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


        List<List<Integer>> nodesByLevel= levelOrderTraversalByLevel(bsT.getRoot());
        for (int i=0; i< nodesByLevel.size();i++){
            List<Integer> levelNodes = nodesByLevel.get(i);
            String nodes = levelNodes.stream().map(x->x.toString()).collect(Collectors.joining(","));
            System.out.println("\nLevel "+ (i +1) +" : "+ nodes);
        }

        List<List<Integer>> reversedNodesByLevel= reversedLevelOrderTraversalByLevel(bsT.getRoot());
        for (int i=0; i< reversedNodesByLevel.size() ;i++){
            List<Integer> levelNodes = reversedNodesByLevel.get(i);
            String nodes = levelNodes.stream().map(x->x.toString()).collect(Collectors.joining(","));
            System.out.println("\nReversed Level "+ (i+1) +" : "+ nodes);
        }
    }
}
