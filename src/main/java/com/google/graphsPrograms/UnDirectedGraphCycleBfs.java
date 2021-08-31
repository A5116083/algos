package com.google.graphsPrograms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class UnDirectedGraphCycleBfs {

    private static boolean checkCycle(List<List<Integer>> adj, int node, boolean[] visited) {
        Queue<Pair> queue  = new LinkedList<>();
        queue.offer(new Pair(node,-1));
        visited[node] = true;
        while (!queue.isEmpty()){
            Pair current = queue.poll();
            List<Integer> adjList=  adj.get(current.node);
            for(int c : adjList){
                if(visited[c]==false){
                    queue.offer(new Pair(c,current.node));
                    visited[c]=true;
                }else if (current.prev!= c) return true;
            }
        }
        return false;
    }

    public static boolean isCycle(List<List<Integer>> adj){

        int vertx = adj.size();
        boolean[] visited = new boolean[vertx];

        for (int i=0;i< vertx;i++){
            if(visited[i]==false)
                if(checkCycle(adj,i,visited))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        UnDirectedGraphCycleBfs cycle = new UnDirectedGraphCycleBfs();
        GraphAdjList.Graph  graph =new  GraphAdjList.Graph(9);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 5);

        if(cycle.isCycle(graph.getAdj()))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
