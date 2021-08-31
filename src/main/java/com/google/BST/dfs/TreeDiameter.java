package com.google.BST.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/*
Given a binary tree, find the length of its diameter. The diameter of a tree is the number of nodes on the longest path between any two leaf nodes.
The diameter of a tree may or may not pass through the root.
Note: You can always assume that there are at least two leaf nodes in the given tree.

Example 2:
1,2,3,5,6,7,8,10,9,11

Output: 7
Explanation: The diameter of the tree is: [10, 8, 5, 3, 6, 9, 11]
 */
public class TreeDiameter {


    private static int treeDiameter=0;
    static List<Integer> diameterNodes= new ArrayList<>();
    public static int findDiameter(TreeNode root) {
        calculateHeight(root);
        return treeDiameter;
    }


    private static int calculateHeight(TreeNode root){
        if(root==null) return 0;
        int leftTreeHeight= calculateHeight(root.left);
        int rightTreeHeight = calculateHeight(root.right);
        if(leftTreeHeight!=0 && rightTreeHeight !=0){
            int diameter = leftTreeHeight+rightTreeHeight+1;
            treeDiameter = Math.max(diameter,treeDiameter) ;
        }
        return Math.max(leftTreeHeight,rightTreeHeight)+1;
    }


    private static List<Integer> printDiameter(TreeNode root){
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathRecursive(root,currentPath,allPaths);
        return currentPath;

    }
    private static void findPathRecursive(TreeNode root, List<Integer> currentPath, List<List<Integer>> allpaths){

        if(root==null) return;
        currentPath.add(root.val);
        if(root.left==null && root.right==null)
            allpaths.add(new ArrayList<>(currentPath));
        else {

            findPathRecursive(root.left,  currentPath, allpaths);
            findPathRecursive(root.right,  currentPath, allpaths);
        }
        currentPath.remove(currentPath.size()-1);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
        root.left.left = null;
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.left.right.left = new TreeNode(10);
        root.right.right.left.left = new TreeNode(11);
        System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root));
    }
}
