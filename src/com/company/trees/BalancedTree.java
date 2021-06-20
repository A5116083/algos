package com.company.trees;

public class BalancedTree {


    class Height{
        int height;
    }
    public class Tree{

        private Node root;

        class Node{

            Node left;
            Node right;
            int data;

            public Node(int data) {
                this.data = data;
            }
        }

        public void add (Node node){

            if(root==null){
                root = node;
                return;
            }

            if(node.data < root.data){

                //add node on the left most
                if(node.left== null)
                    node.left = node;
                else add(node.left);
            }else {
                if(node.right== null)
                    node.right = node;
                else add(node.right);
            }

        }

        private boolean isBalanced(Node root, Height height){

            if(root==null){

                height.height =0;
                return true;
            }

            Height lheight = new Height();
            Height rheight = new Height();

            boolean l = isBalanced(root.left, lheight);
            boolean r = isBalanced(root.right, rheight);

            int lh = lheight.height;
            int rh= rheight.height;

            height.height = (lh > rh ? lh : rh) + 1;

            if(Math.abs(lh-rh)>= 2)
                return false;
            else
                return l && r;

        }
    }
}
