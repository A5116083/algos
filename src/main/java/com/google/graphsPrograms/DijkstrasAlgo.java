package com.google.graphsPrograms;

import java.util.*;

public class DijkstrasAlgo {
    public static class Node implements Comparator<Node> {
        int weight;
        int v;
        public Node(){}
        public Node(int weight, int v) {
            this.weight = weight;
            this.v = v;
        }

        @Override
        public int compare(Node first, Node second) {
            if(first.weight< second.weight)
                return -1;
            else if (first.weight > second.weight)
                return 1;
            else return 0;
        }
        public int getWeight(){return weight;}
        public int getV(){return  v;}
    }

    private int[] bfsSortedDistance(List<List<Node>> adjList,int source){
        int v= adjList.size();
        PriorityQueue<Node> queue = new PriorityQueue<Node>(v, new Node());
        int[] dist = new int[v];
        for (int i=0;i< v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        queue.offer(new Node(0,source));
        dist[source]=0;
        while (!queue.isEmpty()){

            Node node = queue.poll();

            for (Node it: adjList.get(node.getV())){

                if(dist[node.getV()]+ it.getWeight() < dist[it.getV()] ){
                    dist[it.getV()]= dist[node.getV()]+ it.getWeight();
                    queue.offer(new Node(dist[it.getV()], it.getV()));
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int n = 5;
        List<List<Node>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<Node>());

        adj.get(0).add(new Node( 2,1));
        adj.get(1).add(new Node( 2,0));

        adj.get(1).add(new Node( 4,2));
        adj.get(2).add(new Node( 4,1));

        adj.get(0).add(new Node( 1,3));
        adj.get(3).add(new Node( 1,0));

        adj.get(3).add(new Node( 3,2));
        adj.get(2).add(new Node( 3,3));

        adj.get(1).add(new Node( 5,4));
        adj.get(4).add(new Node( 5,1));

        adj.get(2).add(new Node( 1,4));
        adj.get(4).add(new Node( 1,2));

        DijkstrasAlgo obj = new DijkstrasAlgo();
        int[] dist = obj.bfsSortedDistance(adj, 0);
        System.out.print("sorted distance from source 0: " );
        for (int i=0;i< dist.length;i++){
            System.out.print(dist[i] + " ");
        }
    }

}
