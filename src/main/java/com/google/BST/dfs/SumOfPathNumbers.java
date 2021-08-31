package com.google.BST.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SumOfPathNumbers {

    /*
    Given a binary tree where each node can only have a digit (0-9) value, each root-to-leaf path will represent a number.
    Find the total sum of all the numbers represented by all paths.
    Output: 332 Explanation:
    The sum of all path numbers: 101 + 116 + 115
     */
    public static int findSumOfPathNumbers(TreeNode root) {

        List<Integer> allNodesPathSum = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathNumRecursive(root,allNodesPathSum,currentPath);

        return allNodesPathSum.stream().mapToInt(x->x.intValue()).sum();
    }

    private static void findPathNumRecursive(TreeNode root, List<Integer> allNodes, List<Integer> currentPath){

        if(root==null) return;
        currentPath.add(root.val);
        if(root.right==null && root.left==null){

            String joinedNodesNum = currentPath.stream().map(x->x.toString()).collect(Collectors.joining(""));
            int val = Integer.valueOf(joinedNodesNum);
            allNodes.add(val);
        }
        findPathNumRecursive(root.left, allNodes, currentPath);
        findPathNumRecursive(root.right, allNodes, currentPath);
        currentPath.remove(currentPath.size()-1);
    }

    private static int findRootToLeafPathNumbers(TreeNode currentNode, int pathSum) {
        if (currentNode == null)
            return 0;

        // calculate the path number of the current node
        pathSum = 10 * pathSum + currentNode.val;

        // if the current node is a leaf, return the current path sum.
        if (currentNode.left == null && currentNode.right == null) {
            return pathSum;
        }

        // traverse the left and the right sub-tree
        return findRootToLeafPathNumbers(currentNode.left, pathSum) +
                findRootToLeafPathNumbers(currentNode.right, pathSum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
        System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findRootToLeafPathNumbers(root,0));
    }
}
