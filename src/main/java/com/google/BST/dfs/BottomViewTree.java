package com.google.BST.dfs;

import java.util.ArrayList;
import java.util.List;

public class BottomViewTree {




    private static void findPathRecursive(TreeNode root, List<Integer> bottomNodes){

        if(root==null) return;

        if(root.left==null && root.right==null)
            bottomNodes.add(root.val);
        else {
            findPathRecursive(root.left,   bottomNodes);
            findPathRecursive(root.right, bottomNodes);
        }
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
        System.out.println("Bottom view of the given binary tree:");
        List<Integer> bottomNodes = new ArrayList<>();
        BottomViewTree.findPathRecursive(root,bottomNodes);
        System.out.println("Bottom view of the given binary tree: " + bottomNodes);

        // System.out.println("Tree max path " + maxPathsNodes);
    }

}
