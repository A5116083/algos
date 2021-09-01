package com.google.BST;

import java.util.Stack;
/*
Runtime Complexity #
The runtime complexity of this solution is linear, O(n)O(n).


Memory Complexity #
The memory complexity of this solution is O(h)O(h).

We will print the perimeter of the binary tree in three passes. Here is how the algorithm looks:

Print the root node.
Print the left boundary in top-down order.
Print the leaf nodes in left-right order.
Print the right boundary in bottom-up order. We will push the node values in a stack here.
Once we hit the leaf node, we will pop all elements of the stack while printing them.
 */

public class PerimeterOfTree {

   /* private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }*/


    private static void printLeftPerimeter(TreeNode node, StringBuilder nodesStr){

        while (node!=null){
            int curVal = node.val;
            if(node.left!=null)
                node= node.left;
            else if(node.right!=null)
                node= node.right;
            else break; //Skip the leaf node
            nodesStr.append(curVal+ " ");
        }


    }
    private static void printLeafNodes(TreeNode node, StringBuilder nodesStr){

        if(node== null) return;

        printLeafNodes(node.left,nodesStr);
        if(node.left== null && node.right == null)
            nodesStr.append(node.val + " ");
        printLeafNodes(node.right,nodesStr);

    }

    private static void printRightPerimeter(TreeNode node, StringBuilder nodesStr){
        Stack<TreeNode> rightNodesStack = new Stack<>();
        while (node!=null){
            rightNodesStack.push(node);
            if(node.right!=null)
                node= node.right;
            else if(node.left!=null)
                node= node.left;
            else break; //Skip the leaf node

        }
        while (!rightNodesStack.isEmpty()){

            TreeNode current = rightNodesStack.pop();
            nodesStr.append(current.val + " ");
        }

    }


    private static String printPerimeter(TreeNode root){

        StringBuilder stringBuilder = new StringBuilder();
        printLeftPerimeter(root,stringBuilder);
        printLeafNodes(root,stringBuilder);
        printRightPerimeter(root.right,stringBuilder);

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(25);
        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(14);
        System.out.println("Tree Perimeter : " + printPerimeter(root));


    }
}
