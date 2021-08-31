package com.google.graphsPrograms.mst;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class Node implements Comparator<Node> {

    int u;
    int v;
    int w;
    public Node(){}
    public Node( int u, int v,int w){
        this.w= w;this.u= u; this.v= v;
    }

    @Override
    public int compare(Node o1, Node o2) {
        if(o1.w < o2.w)
            return -1;
        else if(o1.w > o2.w)
            return 1;
        else return 0;
    }
}

public class KruskalMinimumSpanningTree {
    public void mst(List<Node> adj){
        int v = adj.size();
        int[] parentArr = new int[v];
        List<Node> mstLst = new ArrayList<>();
        PriorityQueue<Node> queue = new PriorityQueue<>(v, new Node());
        for (int i=0;i<v; i++){
            queue.add(adj.get(i));
            parentArr[i]= i;
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(mstLst.size()== v) break;
            if(parentArr[node.u]!=parentArr[node.v]){
                parentArr[node.v]= parentArr[node.u];
                mstLst.add(node);
            }
        }
        for (int i=0; i < mstLst.size(); i++){
            Node n = mstLst.get(i);
            System.out.println( n.u+ " - " + n.v);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        ArrayList<Node> adj = new ArrayList<Node>();
        adj.add(new Node(0, 1, 2));
        adj.add(new Node(0, 3, 6));
        adj.add(new Node(1, 3, 8));
        adj.add(new Node(1, 2, 3));
        adj.add(new Node(1, 4, 5));
        adj.add(new Node(2, 4, 7));
        KruskalMinimumSpanningTree minimumSpanningTree = new KruskalMinimumSpanningTree();
        minimumSpanningTree.mst(adj);

    }
}
