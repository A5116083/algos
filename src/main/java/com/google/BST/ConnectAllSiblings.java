package com.google.BST;

import java.util.*;
/*
Given the root to a binary tree where each node has an additional pointer called sibling (or next), connect the sibling pointer to the next node in the same level.
The last node in each level should point to the first node of the next level in the tree.

Consider the following binary tree.
100,50,200,25,75,300,350
100->50->200->25->75->300->350->NULL

 */
/*class TreeNode {

};*/

class ConnectAllSiblings {

    public static void connect(TreeNode root) {

        if(root==null) return  ;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode current = root;
        while (!queue.isEmpty()) {
            int currentLevel = queue.size();

            for(int i=0; i< currentLevel;i++){
                TreeNode currentNode = queue.poll();
                current.next = currentNode;
                current = currentNode;

                if(currentNode.left!=null)
                    queue.offer(currentNode.left);
                if(currentNode.right!=null)
                    queue.offer(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        ConnectAllSiblings.connect(root);

        // level order traversal using 'next' pointer
        TreeNode current = root;
        System.out.println("Traversal using 'next' pointer: ");
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}