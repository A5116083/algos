package com.google.BST.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class FindPathWithMaxSum {

    private static List<List<Integer>> findPathsWithMaxSum(TreeNode root){

        TreeMap<Integer,List<List<Integer>>> allPaths = new TreeMap<>();
        List<Integer> currentPath = new ArrayList<>();

        findPathRecursive(root,allPaths,currentPath);
        return allPaths.lastEntry().getValue();
    }

     private static void findPathRecursive(TreeNode root, TreeMap<Integer,List<List<Integer>>> allPaths, List<Integer> currentPath){
         if(root==null) return;
         currentPath.add(root.val);
         if(root.left==null && root.right==null){
             int sum = currentPath.stream().mapToInt(i -> i.intValue()).sum();
             if(!allPaths.containsKey(sum))
                 allPaths.put(sum, new ArrayList<>() );
             allPaths.get(sum).add(new ArrayList<>(currentPath));
         }
         findPathRecursive(root.left, allPaths, currentPath);
         findPathRecursive(root.right, allPaths, currentPath);
         currentPath.remove(currentPath.size()-1);
     }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        List<List<Integer>> maxPathsNodes = FindPathWithMaxSum.findPathsWithMaxSum(root);
        System.out.println("Tree max path " + maxPathsNodes);

    }
}
