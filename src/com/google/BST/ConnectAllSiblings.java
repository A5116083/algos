package com.google.BST;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;

    TreeNode(int x) {
        val = x;
        left = right = next = null;
    }
};

class ConnectAllSiblings {

    public static void connect(TreeNode root) {

        List<List<Integer>> result = new ArrayList<List<Integer>>();
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