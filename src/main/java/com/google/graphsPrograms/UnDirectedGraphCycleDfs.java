package com.google.graphsPrograms;

import java.util.List;

public class UnDirectedGraphCycleDfs {

    private static boolean checkCycle(List<List<Integer>> adj, int node, int prev, boolean[] visited) {
        if(visited[node]) return false;
        visited[node] = true;
        for (Integer c : adj.get(node)) {
            if (visited[c] == false) {
                if (checkCycle(adj, c, node, visited))
                    return true;
            }
            else if(c!= prev) {
                    return true;
                }
        }
        return false;
    }

    public static boolean isCycle(List<List<Integer>> adj){

        int vertx = adj.size();
        boolean[] visited = new boolean[vertx];

        for (int i=0;i< vertx;i++){
            if(visited[i]==false)
                if(checkCycle(adj,i,-1,visited))
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        GraphAdjList.Graph  graph =new  GraphAdjList.Graph(9);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        //graph.addEdge(8, 5);
        if(UnDirectedGraphCycleDfs.isCycle(graph.getAdj()))
            System.out.println("Graph has cycle");
        else System.out.println("Graph doesn't have cycle");
    }
}
