package com.google.graphsPrograms;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Graph {
    private static final String NEWLINE = System.getProperty("line.separator");
    private  int vertxSize;
    private static int edges;
    Bag<Integer>[] adj;

    public Graph(int size){
        vertxSize = size ;
        edges =0;
        adj  =new Bag[vertxSize];
        for (int v=0; v < size; v++){
            adj[v] = new Bag<Integer>();
        }

    }
    /**
     * Initializes a graph from the specified input stream.
     * The format is the number of vertices <em>V</em>,
     * followed by the number of edges <em>E</em>,
     * followed by <em>E</em> pairs of vertices, with each entry separated by whitespace.
     *
     * @param  in the input stream
     * @throws IllegalArgumentException if {@code in} is {@code null}
     * @throws IllegalArgumentException if the endpoints of any edge are not in prescribed range
     * @throws IllegalArgumentException if the number of vertices or edges is negative
     * @throws IllegalArgumentException if the input stream is in the wrong format
     */
    public Graph(String in) {
        if (in == null) throw new IllegalArgumentException("argument is null");
        try {
            URL url = getClass().getResource(in);
            File file = new File(in);
            Scanner scanner = new Scanner(new File(in));
           int E=0;
            this.vertxSize =0;
            if(scanner.hasNext())
                this.vertxSize = scanner.nextInt();


            if (vertxSize < 0) throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
            adj = (Bag<Integer>[]) new Bag[vertxSize];
            for (int v = 0; v < vertxSize; v++) {
                adj[v] = new Bag<Integer>();
            }

            if(scanner.hasNext())
                E = scanner.nextInt();

            if (E < 0) throw new IllegalArgumentException("number of edges in a Graph must be non-negative");
            for (int i = 0; i < E; i++) {
                int v = scanner.nextInt();
                int w = scanner.nextInt();
                validateVertex(v);
                validateVertex(w);
                addEdge(v, w);
            }
        }
        catch (NoSuchElementException e) {
            throw new IllegalArgumentException("invalid input format in Graph constructor", e);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getVertxSize(){
        return vertxSize;
    }
    public int getEdges(){
        return edges;
    }
    public int degree(int vertx){
        validateVertex(vertx);
        return adj[vertx].size();
    }

    public void addEdge(int v, int w){
        validateVertex(v);
        validateVertex(w);
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    public Iterable<Integer> adj(int v){
        validateVertex(v);
        return adj[v];
    }
    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= vertxSize)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertxSize-1));
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertxSize + " vertices, " + edges + " edges " + NEWLINE);
        for (int v = 0; v < vertxSize; v++) {
            s.append(v + ": ");
            for (Object w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }

    public static void main(String[] args) {



        String fileName = "C:\\project\\frommac\\algos\\src\\main\\resources\\tinygraph.txt";
        Graph gh = new Graph(fileName);
        System.out.println(gh.vertxSize);
        System.out.println(gh.toString());
    }
}
