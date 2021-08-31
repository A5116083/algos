package com.google.graphsPrograms;


public class DirectedGraphCycleDfs {


    public boolean isCycle(GraphAdjList.Graph graph){
    int num_vertex= graph.vertx();
        boolean[] visited = new boolean[num_vertex];
        boolean[] dfsVisit = new boolean[num_vertex];
        for (int i=0;i<num_vertex;i++)
            if(!visited[i])
             if(cycleUtil(graph, i,visited, dfsVisit))
                 return true;
        return false;

    }

    public boolean cycleUtil(GraphAdjList.Graph graph,int v,  boolean[] visited, boolean[] dfsVisit){
        if (dfsVisit[v])
            return true;
        if (visited[v])
            return false;

        visited[v] = true;
        dfsVisit[v] = true;
        for (Object c: graph.getAdj().get(v)) {
            if (cycleUtil(graph, (int)c, visited, dfsVisit))
                return true;
        }
        dfsVisit[v] = false;
        return false;
    }

    public static void main(String[] args) {
        DirectedGraphCycleDfs cycle = new DirectedGraphCycleDfs();
        GraphAdjList.Graph  graph =new  GraphAdjList.Graph(9);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);
        //graph.addEdge(8, 5);

        if(cycle.isCycle(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }
}
