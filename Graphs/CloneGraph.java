/*
 * Given a reference of a node in a connected undirected graph.
 * 
 * Return a deep copy (clone) of the graph.
 * 
 * Each node in the graph contains a value (int) and a list (ArrayList[Node]) of its
 * neighbors.
 * 
 * class Node {
 * public int val;
 * public ArrayList<Node> neighbors;
 * }
 * 
 * 
 * Test case format:
 * 
 * For simplicity, each node's value is the same as the node's index
 * (1-indexed). For example, the first node with val == 1, the second node with
 * val == 2, and so on. The graph is represented in the test case using an
 * adjacency list.
 * 
 * An adjacency list is a collection of unordered lists used to represent a
 * finite graph. Each list describes the set of neighbors of a node in the
 * graph.
 * 
 * The given node will always be the first node with val = 1. You must return
 * the copy of the given node as a reference to the cloned graph.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

class CloneGraph {
    private static class Node {
        private int val;
        private ArrayList<Node> neighbors;

        public Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<Node>();
        }
    }

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        HashMap<Node, Node> visited = new HashMap<Node, Node>();
        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(node);

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            Node clonedCurrent = visited.get(current);

            for (Node neighbor : current.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    queue.offer(neighbor);
                    Node clonedNeighbor = new Node(neighbor.val);
                    visited.put(neighbor, clonedNeighbor);
                    clonedCurrent.neighbors.add(clonedNeighbor);
                } else {
                    clonedCurrent.neighbors.add(visited.get(neighbor));
                }
            }
        }

        return cloneNode;
    }

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static void printGraph(Node node, HashMap<Node, Boolean> visited) {
        if (node == null)
            return;

        if (visited.containsKey(node))
            return;

        visited.put(node, true);

        System.out.print(node.val + " -> ");
        for (Node neighbor : node.neighbors) {
            System.out.print(neighbor.val + " ");
        }
        System.out.println();

        for (Node neighbor : node.neighbors) {
            printGraph(neighbor, visited);
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clonedGraph = cloneGraph(node1);

        printGraph(clonedGraph, new HashMap<Node, Boolean>());
    }
}