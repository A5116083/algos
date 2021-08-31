package com.google.BST;

import com.company.trees.BalancedTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

Given the root node of a binary tree, swap the ‘left’ and ‘right’ children for each node. The below example shows how the mirrored binary tree should look like.

20
50
200
75
25
300


20
200
50
300
25
75


 */
public class MirrorBT {

    private static void mirrorTee(TreeNode node){

        if(node==null) return;
        mirrorTee(node.left);
        mirrorTee(node.right);
        TreeNode temp = node.left;
        node.left = node.right;
        node.right= temp;
    }

    public static List<List<Integer>> levelOrderTraversalByLevel(TreeNode node){
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(node==null) return result ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();
            List<Integer> currentLevelNodes = new ArrayList<>(currentLevel);
            for(int i=0; i< currentLevel;i++){
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode.val);
                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
            result.add(currentLevelNodes);

        }
        return result;
    }


    public static void main(String[] args)  {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        System.out.println("InOrder tree before :");
        List<List<Integer>> treeBefore = levelOrderTraversalByLevel(root);
        System.out.println(treeBefore);
        mirrorTee(root);
        System.out.println("\nInOrder tree After :");
        List<List<Integer>> treeAfter = levelOrderTraversalByLevel(root);
        System.out.println(treeAfter);

    }
}
