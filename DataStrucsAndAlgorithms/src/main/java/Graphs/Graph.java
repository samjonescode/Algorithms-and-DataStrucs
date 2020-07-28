package Graphs;

import java.util.*;

public class Graph {
    int data;
    Set<Graph> children;

    public static void main(String[] args) {
        Graph sam = new Graph(3);
        sam.addChild(6).addChild(9).addChild(12);
        Graph.depthFirstTraversal(sam);
        System.err.println();
        Graph.breadthFirstTraversal(sam);

    }

    public Graph(int data) {
        this.data = data;
        this.children = new HashSet<>();
    }

    public String toString() {
        return "" + this.data;
    }

    Graph addChild(int data) {
        Graph newN = new Graph(data);
        this.children.add(newN);
        return this;
    }

    static void breadthFirstTraversal(Graph node) {
        Queue<Graph> toVisit = new LinkedList<Graph>();
        Set<Graph> visited = new HashSet<>();
        toVisit.add(node);
        visited.add(node);
        while (!toVisit.isEmpty()) {
            Graph curr = toVisit.remove();
            System.out.println("Current: " + curr);
            for (Graph child : curr.children) {
                toVisit.add(child);
                visited.add(child);
            }
        }
    }

    static void depthFirstTraversal(Graph node) {
        Stack<Graph> toVisit = new Stack<Graph>();
        Set<Graph> visited = new HashSet<Graph>();
        toVisit.add(node);
        visited.add(node);
        while (!toVisit.isEmpty()) {
            Graph curr = toVisit.pop();
            System.out.println("Current: " + curr);
            for (Graph child : curr.children) {
                toVisit.add(child);
                visited.add(child);
            }
        }
    }

}