package com.google.graphsPrograms;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SortestDistanceBfs  {

    private void bfsDistance(List<List<Integer>> adjList, int source, int[] dist){
        int v= adjList.size();
        Queue<Integer> queue = new LinkedList<>();
        //
        for (int i=0;i< v;i++){
            dist[i]=Integer.MAX_VALUE;
        }
        queue.offer(source);
        dist[source]=0;
        while (!queue.isEmpty()){

            int node = queue.poll();
            for (int c: adjList.get(node)){
                if(dist[node]+1 < dist[c] ){
                    dist[c]= dist[node]+1;
                    queue.offer(c);
                }
            }
        }

    }
    public int sortestDist(GraphAdjList.Graph graph, int source, int dest){
        int v= graph.getAdj().size();
        int[] dist = new int[v];

        bfsDistance(graph.getAdj(), source, dist);

        return dist[dest];
    }

    public static void main(String[] args) {

        SortestDistanceBfs sortedDis = new SortestDistanceBfs();
        GraphAdjList.Graph  graph =new  GraphAdjList.Graph(9);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        graph.addEdge(8, 5);

        sortedDis.sortestDist(graph,1,2);
    }

}
