package com.google.graphsPrograms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphTraversal {
    boolean[] marked ;
    boolean[] dfsMarker;
    int[] distTo;
    int[] pathto;
/*
The bfs() function performs the traversal on one source vertex at a time and outputs all vertices reachable from the source.
In the bfs() function, we insert the vertices into the queue, starting from the source vertex.
To keep track of the nodes that have been traversed, every node inserted into the queue is marked visited in the visited array.

The result string is our output variable. The value of a node is appended to result when it is dequeued from the queue.
For each node that is dequeued, its adjacent nodes are added to the queue if they have not been visited.
Time complexity is O(E+V)
 */
    public  String bfs (Graph graph, int v){
        marked = new boolean[graph.getVertxSize()];
        pathto= new int[graph.getVertxSize()];
        distTo= new int[graph.getVertxSize()];
        for(int i =0; i< graph.getVertxSize();i++) {
            //pathto[i] = Integer.MAX_VALUE;
            distTo[i] = Integer.MAX_VALUE;
        }
        StringBuilder strBuilder = new StringBuilder();
        Queue<Integer> queue  = new LinkedList<>();
        if(v <0 ) return "";
        queue.offer(v);
        marked[v]=true;
        distTo[v]= 0;
        while (!queue.isEmpty()){
            int vertex = queue.poll();
            strBuilder.append(vertex + " ");
            for(Object w : graph.adj[vertex]){
                int adj= (int)w;
                if(!marked[adj]){
                    pathto[adj]= vertex;
                    distTo[adj] = distTo[v]+1;
                    marked[adj]= true;
                    queue.offer(adj);
                }
            }
        }
        return strBuilder.toString();
    }

    public String dfs(Graph graph, int v){
        dfsMarker = new boolean[graph.getVertxSize()];
        return dfsRecursive(graph, v, new StringBuilder());
    }
    /*
    in Depth first search we have start from any node and go one of the adjacent node and then go there adjacent until there is no adjacent.
    on every node keep a boolean to mark it visited, roll back to the starting node and then visit the next adjacent node and so on.
    Time complexity is O(E+V)
     */
    public String dfsRecursive(Graph graph, int v, StringBuilder path){
        if(graph==null) return "";
        if(graph.adj[v].size()==0)
            return "";
        path.append(v + " ");
        dfsMarker[v]= true;
        for (Object w : graph.adj[v]){
            int vertx= (int)w;
            if(!dfsMarker[vertx]) {
                dfsRecursive(graph, vertx, path);
                dfsMarker[vertx]= true;
            }
        }
        return path.toString();
    }


    public static String dfs(Graph g){
        String result = "";
        //Checking if the graph has no vertices
        if (g.getVertxSize() < 1){
            return result;
        }
        //Boolean Array to hold the history of visited nodes (by default-false)
        boolean[] visited = new boolean[g.getVertxSize()];
        return dfsVisit(g, 0, visited);
    }
    public static String dfsVisit(Graph g, int source, boolean[] visited) {

        String result = "";

        //Create Stack(Implemented in previous lesson) for Depth First Traversal and Push source in it
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);

        //Traverse while stack is not empty
        while (!stack.isEmpty()) {
            //Pop a vertex/node from stack and add it to the result
            int current_node = stack.pop();
            result +=" " + String.valueOf(current_node);
            //Get adjacent vertices to the current_node from the array,
            //and if they are not already visited then push them in the stack
            for(Object w : g.adj[current_node]){
                int current= (int)w;
                if(!visited[current]){
                    stack.push(current);
                    visited[current]=true;
                }
            }
            //Visit the node
            visited[current_node] = true;
        }//end of while
        return result;
    }


    public static void main(String[] args) {
        String fileName = "C:\\project\\frommac\\algos\\src\\main\\resources\\tinygraph.txt";
        Graph gh = new Graph(fileName);
        GraphTraversal traversal = new GraphTraversal();
        System.out.println("bfs: "+ traversal.bfs(gh,0));


        System.out.println("dfs: " + traversal.dfs(gh,0));

        System.out.println("dfs-Stack implementation : " + traversal.dfs(gh));


    }

}
