package com.google.graphsPrograms;

public class Pair {

    int node;
    int prev;

    public Pair(int node, int prev) {
        this.node = node;
        this.prev = prev;
    }

    public int getNode() {
        return node;
    }

    public int getPrev() {
        return prev;
    }
}
