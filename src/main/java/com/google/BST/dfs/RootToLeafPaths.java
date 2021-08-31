package com.google.BST.dfs;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {


    public static List<List<Integer>> findAllPaths(TreeNode root){

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();

        findPathRecursive(root, currentPath, allPaths);

        return allPaths;

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
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = RootToLeafPaths.findAllPaths(root);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }

}
