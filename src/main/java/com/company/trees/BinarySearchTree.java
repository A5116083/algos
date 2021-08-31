package com.company.trees;

public class BinarySearchTree {

    private TreeNode root;

    public void insert(int value) {
        if (root == null)
            root = new TreeNode(value);
        else root.insert(value);
    }

    public TreeNode find(int value) {
        if (root == null)
            return null;
        return root.find(value);
    }

    public void delete(int value) {

        TreeNode current = this.root;
        TreeNode parent = this.root;

        boolean isLeftChild = false;

        if (current == null)
            return;
        while (current != null && current.getData() != value) {
            parent = current;

            if (value > current.getData()) {
                current = current.getRight();
                isLeftChild = false;

            } else {
                current = current.getLeft();
                isLeftChild = true;
            }
        }
        if (current == null)
            return; //data is not found
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root)
                root = null;
            else {
                if (isLeftChild)
                    parent.setLeft(null);
                else parent.setRight(null);
            }
        } // This is case 2 broken down further into 2 separate cases
        else if (current.getRight() == null) { //when has left child only
            if (current == root)
                root = current.getLeft();
            else if (isLeftChild)
                parent.setLeft(current.getLeft());
            else
                parent.setRight(current.getLeft());
        } else if (current.getLeft() == null) { //when has right child only

            if (current == root)
                root = current.getRight();
            else if (isLeftChild)
                parent.setLeft(current.getRight());
            else
                parent.setRight(current.getRight());
        }
        // This is case 3 - Most complicated (node to be deleted has 2 children). When node has both left and right child
        else {
            TreeNode successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }

    }
    private TreeNode getSuccessor(TreeNode node) {
        TreeNode parentOfSuccessor = node;
        TreeNode successor = node;
        TreeNode current = node.getRight();
        while (current != null) {
            parentOfSuccessor = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != node.getRight()) {
            parentOfSuccessor.setLeft(successor.getRight());
            successor.setRight(node.getRight());
        }
        return successor;
    }

    public Integer smallest(){

        if(root!=null)
            return root.smallest();
        return null;

    }
    public Integer largest(){
        if(root!=null)
            return root.largest();
        return null;
    }

    /*
    In order traversl
    1. Go to the left node
    2. go the parent
    3. go to the right node
     */
    public void traverseInOrder(){
        if(root!=null)
            root.inOrder();
        System.out.println();

    }
    public int numOfLeafNodes(){
        if(root==null)
            return 0;

        return root.numberOfLeafNodes();

    }
    public int height(){
        if(root==null)
            return 0;

        return root.height();

    }

    public static void main(String[] args) {
        int[] sample = { 212, 580, 6, 7, 28, 84, 112, 434};
        BinarySearchTree bst = new BinarySearchTree();
        for (int x : sample) {
            bst.insert(x);
        }
        System.out.println("element found: " + bst.find(65));
        System.out.println("smallest: " + bst.smallest());
        System.out.println("largest: " + bst.largest());
//		bst.delete(84);
        System.out.println("number of leaf nodes: " + bst.numOfLeafNodes());
        System.out.println("tree height: " + bst.height());
        bst.traverseInOrder();
    }
}

