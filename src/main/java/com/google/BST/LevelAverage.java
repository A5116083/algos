package com.google.BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class LevelAverage {

    private static List<Double> levelAverageTraversal(Node node){
        List<Double> result = new ArrayList<>();
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
            result.add(currentLevelNodes.stream().collect(Collectors.averagingInt(x-> Integer.parseInt(x.toString()))));

        }
        return result;
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


        List<Double> nodesByLevel= levelAverageTraversal(bsT.getRoot());
        for (int i=0; i< nodesByLevel.size();i++){

            System.out.println("\nLevel "+ (i +1) +" : "+ nodesByLevel.get(i));
        }


    }
}
