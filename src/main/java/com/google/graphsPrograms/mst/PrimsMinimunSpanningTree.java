package com.google.graphsPrograms.mst;

import com.google.graphsPrograms.DijkstrasAlgo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsMinimunSpanningTree {

    public void dfsSpanningTree(List<List<DijkstrasAlgo.Node>> adj){

        int v = adj.size();
        int[] parentArr = new int[v];
        int[] key = new int[v];
        boolean[] mst = new boolean[v];
        for (int i=0; i< v; i++){
            key[i] = Integer.MAX_VALUE;
            mst[i]= false;
        }
        PriorityQueue<DijkstrasAlgo.Node> queue = new PriorityQueue<>(v, new DijkstrasAlgo.Node());
        queue.add(new DijkstrasAlgo.Node(0,0));
        key[0] = 0;
        parentArr[0] =-1;
        mst[0] = true;
        while (!queue.isEmpty()){
            DijkstrasAlgo.Node node = queue.poll();
            int parent = node.getV();
            for (DijkstrasAlgo.Node it: adj.get(parent)){

                if(it.getWeight() < key[it.getV()] && mst[it.getV()]== false){
                    mst[it.getV()]= true;
                    key[it.getV()] = it.getWeight();
                    parentArr[it.getV()]= parent;
                    queue.add(new DijkstrasAlgo.Node(it.getWeight(), it.getV()));
                }

            }



        }

        for (int i=1; i < v; i++){

            System.out.println(parentArr[i] + " - " + i);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<DijkstrasAlgo.Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        adj.get(0).add(new DijkstrasAlgo.Node(2,1));
        adj.get(1).add(new DijkstrasAlgo.Node(2,0));
        adj.get(1).add(new DijkstrasAlgo.Node(3,2));
        adj.get(2).add(new DijkstrasAlgo.Node(3,1));
        adj.get(0).add(new DijkstrasAlgo.Node(6,3));
        adj.get(3).add(new DijkstrasAlgo.Node(6,0));
        adj.get(1).add(new DijkstrasAlgo.Node(8,3));
        adj.get(3).add(new DijkstrasAlgo.Node(8,1));
        adj.get(1).add(new DijkstrasAlgo.Node(5,4));
        adj.get(4).add(new DijkstrasAlgo.Node(5,1));
        adj.get(2).add(new DijkstrasAlgo.Node(7,4));
        adj.get(4).add(new DijkstrasAlgo.Node(7,2));

        PrimsMinimunSpanningTree minimunSpanningTree= new PrimsMinimunSpanningTree();
        minimunSpanningTree.dfsSpanningTree(adj);

    }
}
