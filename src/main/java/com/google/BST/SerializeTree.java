package com.google.BST;

import java.io.*;

public class SerializeTree {
    private static final int MARKER = Integer.MIN_VALUE;
    private static void serializePreOrder(TreeNode root, ObjectOutputStream stream) throws IOException {
        if(root==null){
            stream.writeInt(MARKER);
            return;
        }
        stream.writeInt(root.val);
        serializePreOrder(root.left, stream);
        serializePreOrder(root.right, stream);
    }
    private static void serializeInOrder(TreeNode root, ObjectOutputStream stream) throws IOException {
        if(root==null) {
            stream.writeInt(MARKER);
            return;
        }
        serializeInOrder(root.left, stream);
        stream.writeInt(root.val);
        serializeInOrder(root.right, stream);
    }

    private static void serializePostOrder(TreeNode root, ObjectOutputStream stream) throws IOException {
        if(root==null) return;
        serializePostOrder(root.left, stream);
        serializePostOrder(root.right, stream);
        stream.writeInt(root.val);
    }
    private static TreeNode deSerializePreOrder(ObjectInputStream stream) throws IOException {

        if(stream==null) return null;
        int val = stream.readInt();
        if(val==MARKER)return null;
        TreeNode node = new TreeNode(val);
        node.left = deSerializePreOrder(stream);
        node.right = deSerializePreOrder(stream);
        return node;
    }
    private static void printInOrderTree(TreeNode current) {

        if (current == null) return;

        System.out.print(current.val + ",");
        printInOrderTree(current.left);
        printInOrderTree(current.right);

    }

    public static void main(String[] args) throws IOException {

        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(9);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        root.left.left.left = new TreeNode(3);
        System.out.println("InOrder tree before serialze :\n");
        printInOrderTree(root);

        ByteArrayOutputStream baostream1 = new ByteArrayOutputStream();
        ObjectOutputStream stream1 = new ObjectOutputStream(baostream1);
        serializePreOrder(root, stream1);
        stream1.close();

        ByteArrayInputStream baiStream1= new ByteArrayInputStream(  baostream1.toByteArray());
        ObjectInputStream  istream1 = new ObjectInputStream(baiStream1);
        TreeNode newRoot=  deSerializePreOrder(istream1);
        System.out.println("Deserialized Tree");
        printInOrderTree(newRoot);
    }





}
