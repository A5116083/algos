package com.company.trees;

public class TreeNode {

    private int data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }
    public int smallest(){
        if(this.left==null)
            return this.data;
        else return this.left.smallest();
    }
    public int largest(){
        if(this.right==null)
            return this.data;
        else return this.right.largest();
    }

    public void inOrder(){
        if(this.left!=null)
            this.left.inOrder();
        System.out.print(this + " ");
        if(this.right!=null)
            this.right.inOrder();
    }
    public int height(){
        if(isLeaf())return  1;
        int leftCount = 0;
        int rightCount = 0;
        if (this.left != null)
            leftCount = this.left.height();
        if (this.right != null)
            rightCount = this.right.height();
        return (leftCount > rightCount) ? (leftCount + 1) : (rightCount + 1);

    }
    public int numberOfLeafNodes(){
        if(isLeaf())return  1;
        int leftCount = 0;
        int rightCount = 0;
        if (this.left != null)
            leftCount = this.left.numberOfLeafNodes();
        if (this.right != null)
            rightCount = this.right.numberOfLeafNodes();
        return leftCount+ rightCount;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode find(int value){
        if(this.data== value)
            return this;
        if(value > this.data && this.right!=null)
            return this.right.find(value);
        else if (this.left!= null)
            return this.left.find(value);
        else return null;
    }

    public void insert(int value){
        if(value >=this.data){
            if(this.right==null)
                this.right = new TreeNode(value);
            else this.right.insert(value);
        }else{
            if(this.left==null)
                this.left = new TreeNode(value);
            else this.left.insert(value);

        }
    }
    @Override
    public String toString() {
        return String.valueOf(this.data);
    }
}
