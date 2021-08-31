package com.google.BST.dfs;

import java.util.ArrayList;
import java.util.List;

/*
Given a binary tree and a number ‘S’, find all paths from root-to-leaf such that the sum of all the node values of each path equals ‘S’.
S: 23
Output: [[12, 7, 4], [12, 1, 10]]
Explanation: Here are the two paths with sum '23':12 -> 7 -> 4 and 12 -> 1 -> 10
 */
public class FindAllTreePaths {

    public static List<List<Integer>> findPaths(TreeNode root, int sum) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathRecursive(root,sum,currentPath,allPaths);
        // TODO: Write your code here
        return allPaths;
    }


    private static void findPathRecursive(TreeNode root, int sum, List<Integer> currentPath, List<List<Integer>> allpaths){

        if(root==null) return;
        currentPath.add(root.val);
        if(root.val== sum && root.left==null && root.right==null)
            allpaths.add(new ArrayList<>(currentPath));
        else {

            findPathRecursive(root.left, sum- root.val, currentPath, allpaths);
            findPathRecursive(root.right, sum- root.val, currentPath, allpaths);
        }
        currentPath.remove(currentPath.size()-1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);

        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
