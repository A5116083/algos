package com.google.BST.dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Given a binary tree and a number sequence, find if the sequence is present as a root-to-leaf path in the given tree.
Sequence: [1, 0, 7]
Output: false
Explanation: The tree does not have a path 1 -> 0 -> 7.
Sequence: [1, 1, 6]
Output: true
Explanation: The tree has a path 1 -> 1 -> 6.
 */
public class PathWithGivenSequence {

    public static boolean findPath(TreeNode root, int[] sequence) {
        // TODO: Write your code here
        Set<String> paths= new HashSet<>();
        findRootToLeafPathNumbers(root,paths,"");
        StringBuilder path = new StringBuilder();
        for (int i=0; i < sequence.length; i++){
            path.append(sequence[i]);
        }
        String key = path.toString();
        return paths.contains(key) ;
    }

    private static void findRootToLeafPathNumbers(TreeNode currentNode, Set<String> paths, String currentPath) {
        if (currentNode == null)
            return ;
        currentPath = currentPath+ currentNode.val;

        // if the current node is a leaf, return the current path sum.
        if (currentNode.left == null && currentNode.right == null) {
             paths.add(currentPath);
        }

        // traverse the left and the right sub-tree
        findRootToLeafPathNumbers(currentNode.left, paths, currentPath) ;
        findRootToLeafPathNumbers(currentNode.right, paths,currentPath);
    }

    private static boolean findPathRecursive(TreeNode currentNode, int[] sequence, int sequenceIndex) {

        if (currentNode == null)
            return false;

        if (sequenceIndex >= sequence.length || currentNode.val != sequence[sequenceIndex])
            return false;

        // if the current node is a leaf, add it is the end of the sequence, we have found a path!
        if (currentNode.left == null && currentNode.right == null && sequenceIndex == sequence.length - 1)
            return true;

        // recursively call to traverse the left and right sub-tree
        // return true if any of the two recusrive call return true
        return findPathRecursive(currentNode.left, sequence, sequenceIndex + 1)
                || findPathRecursive(currentNode.right, sequence, sequenceIndex + 1);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);

        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
        System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
    }
}
