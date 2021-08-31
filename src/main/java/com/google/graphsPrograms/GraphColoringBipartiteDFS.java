package com.google.graphsPrograms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GraphColoringBipartiteDFS {
    private  boolean colorBipartite(List<List<Integer>> adj, int node, int[] colors) {
        Queue<Integer> queue  = new LinkedList<>();
        queue.offer(node);
        colors[node]= 1;

        while (!queue.isEmpty()){
            int current = queue.poll();
            List<Integer> adjList=  adj.get(current);
            for(int c : adjList){
                if(colors[c]==-1) {
                    colors[c]= 1- colors[current];
                    queue.offer(c);
                }else if (colors[c] == colors[current]) return false;
            }
        }
        return true;
    }

    public boolean checkBipartite(GraphAdjList.Graph graph){
        int V = graph.getAdj().size();
        int[] colors = new int[V];
        for(int i=0;i< V; i++){
            colors[i]=-1;
        }
        for (int i=0; i< V; i++){

            if(colors[i]==-1){
                if(!colorBipartite(graph.getAdj(),i,colors))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        GraphAdjList.Graph  graph =new  GraphAdjList.Graph(10);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 8);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        //uncomment to check not a valid bipartite
        //graph.addEdge(5, 8);
        graph.addEdge(6, 7);
        graph.addEdge(8,9);;
        graph.addEdge(9,5);;


        GraphAdjList.Graph  nonPartitegraph =new  GraphAdjList.Graph(9);
        nonPartitegraph.addEdge(1, 2);
        nonPartitegraph.addEdge(2, 3);
        nonPartitegraph.addEdge(2, 8);
        nonPartitegraph.addEdge(3, 4);
        nonPartitegraph.addEdge(4, 5);
        nonPartitegraph.addEdge(5, 6);
        nonPartitegraph.addEdge(5, 8);

        GraphColoringBipartiteDFS bipartiteDFS = new GraphColoringBipartiteDFS();
        if(bipartiteDFS.checkBipartite(graph))
            System.out.println("Graph is bipartite");
        else
            System.out.println("Graph is not bipartite");

        if(bipartiteDFS.checkBipartite(nonPartitegraph))
            System.out.println("nonPartitegraph Graph is bipartite");
        else
            System.out.println("nonPartitegraph Graph is not bipartite");
    }
}
