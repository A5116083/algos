package com.google.BST.dfs;
/*
Find the path with the maximum sum in a given binary tree. Write a function that returns the maximum sum.

A path can be defined as a sequence of nodes between any two nodes and doesn’t necessarily pass through the root.
The path must contain at least one node.
Output: 31
Explanation: The path with maximum sum is: [8, 5, 3, 6, 9]
Solution #
This problem follows the Binary Tree Path Sum pattern and shares the algorithmic logic with Tree Diameter.
We can follow the same DFS approach. The only difference will be to ignore the paths with negative sums.
Since we need to find the overall maximum sum, we should ignore any path which has an overall negative sum.
Time complexity #
The time complexity of the above algorithm is O(N)O(N), where ‘N’ is the total number of nodes in the tree.
This is due to the fact that we traverse each node once.

Space complexity #
The space complexity of the above algorithm will be O(N)O(N) in the worst case. This space will be used to store the recursion stack.
The worst case will happen when the given tree is a linked list (i.e., every node has only one child).
 */
public class MaximumPathSum {

    public static int globalMaxSum=0;

    public static int findMaximumPathSum(TreeNode root) {
        globalMaxSum = Integer.MIN_VALUE;
        findMaximumPathSumRecursive(root);
        return globalMaxSum;
    }

    private static int findMaximumPathSumRecursive(TreeNode root){
        if(root==null) return 0;

        int leftTreeSum= findMaximumPathSumRecursive(root.left);
        int rightTreeSum = findMaximumPathSumRecursive(root.right);

        leftTreeSum = Math.max(leftTreeSum,0);
        rightTreeSum = Math.max(rightTreeSum,0);

        int localSum = leftTreeSum + rightTreeSum + root.val;

        globalMaxSum = Math.max(localSum, globalMaxSum);

        return Math.max(leftTreeSum,rightTreeSum)+root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));

    }
}
