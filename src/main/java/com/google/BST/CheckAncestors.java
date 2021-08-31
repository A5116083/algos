package com.google.BST;

public class CheckAncestors {

    public static String findAncestors(Node root, int k) {
        return findAncestor(root, k, new StringBuilder());
    }

    public static String findAncestor(Node root, int k,  StringBuilder stringBuilder){

            if(root==null) return "";
            if( k< root.getData())
                 findAncestor(root.getLeftChild(), k, stringBuilder);
            if ( k> root.getData())
                 findAncestor(root.getRightChild(), k, stringBuilder);
            if(k== root.getData())
                return "";
            stringBuilder.append(root.getData() + " ");
            return stringBuilder.toString();
    }

    public static String findAncestorFromRoot(Node root, int k,  StringBuilder stringBuilder){

        if(root==null) return "";
        if(k!= root.getData())
            stringBuilder.append(root.getData() + ",");
        if( k< root.getData())
            findAncestorFromRoot(root.getLeftChild(), k, stringBuilder);
        if ( k > root.getData())
            findAncestorFromRoot(root.getRightChild(), k, stringBuilder);

        if(k== root.getData())
            return "";

        return stringBuilder.toString();
    }

    public static void main(String args[]) {

        BinarySearchTree bsT = new BinarySearchTree();
        bsT.add(6);
        bsT.add(4);
        bsT.add(9);
        bsT.add(5);
        bsT.add(2);
        bsT.add(8);
        bsT.add(12);
        bsT.add(10);
        bsT.add(14);
        System.out.println(findAncestors(bsT.getRoot(),14));
        System.out.println(findAncestorFromRoot(bsT.getRoot(),14, new StringBuilder()));
    }

}
