package com.google.graphsPrograms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphAdjList {
    public static class Graph {

        private final int V;
        private final List<List<Integer>> adj;

        public Graph(int V) {
            this.V = V;
            adj = new ArrayList<>(V);

            for (int i = 0; i < V; i++)
                adj.add(new LinkedList<>());
        }
        public void addEdge(int source, int dest) {
            adj.get(source).add(dest);
        }

        public int vertx(){
            return V;
        }
        public List<List<Integer>> getAdj(){
            return adj;
        }
    }
}
