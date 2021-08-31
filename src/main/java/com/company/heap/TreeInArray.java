package com.company.heap;

import java.util.stream.IntStream;

public class TreeInArray {

    int size;
    int[] items;
    int currentPos;
    public TreeInArray(int size) {
        this.size = size;
        items = new int[this.size];
    }
    public int getLastPosition(){
        return currentPos;
    }
    public void addItem(int val) throws Exception {
        if(currentPos< size)
            items[currentPos++]= val;
        else throw  new Exception("Capacity is full");
    }
    public void printAllNodes(){
        int count=0;
        while (count< currentPos){
            System.out.print(items[count++] + " ");
        }
    }
    public void printParentNodes(int leaf, int position){

        if(position <=0)
            return;
        else {
            if(leaf!=position) System.out.print(position + " ");
            printParentNodes(leaf,position/2);

        }


    }
    public void printChildNodes(int position){
        if(position <=0)
            return;
        else {
            printChildNodes(position -3 );
            System.out.print(position+1 + " ");
            System.out.print(position+2 + " ");
        }
    }
    public void printLeadNodes(){

    }

    public int leftMostChild(){
        int height =heightOfTree(currentPos); //log (n)
        return items[((int)Math.pow(2,height))-1];
    }


    public int rightMostChild(){
        int height =heightOfTree(currentPos); //log (n)
        int leftMostIndex = ((int)Math.pow(2,height))-1;
        int lastItem= ((int)Math.pow(2,height+1))-2;
        if(currentPos < lastItem)
            return items[leftMostIndex-1];
        else
            return items[lastItem];

    }

    public int heightOfTree(int currentPos){
        if(currentPos<=0)
            return -1;
        else
            return 1 + heightOfTree(currentPos/2);

    }

    public static void main(String[] args) {
        TreeInArray treeInArray = new TreeInArray(20);
        IntStream.range(1,18).forEach(num-> {
            try {
                treeInArray.addItem(num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        System.out.print("height of tree: ");
        int height = treeInArray.heightOfTree(treeInArray.currentPos);
        System.out.print(height);
        System.out.println("\n");
        treeInArray.printAllNodes();
        System.out.println("\nPrinting all Parent nodes");

        treeInArray.printParentNodes(treeInArray.currentPos,treeInArray.currentPos);
        System.out.println("\nPrinting all Parent nodes of left most");
        treeInArray.printParentNodes((int)Math.pow(2,height),(int)Math.pow(2,height));

        System.out.println("Left Most: + "+ treeInArray.leftMostChild());
        System.out.println("Right Most: + "+  treeInArray.rightMostChild());
        System.out.println("\nPrinting all Parent nodes of right most");
         treeInArray.printParentNodes(treeInArray.rightMostChild(),treeInArray.rightMostChild());

    }

}
