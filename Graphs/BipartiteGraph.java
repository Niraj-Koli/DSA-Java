/*
 * There is an undirected graph with n nodes, where each node is numbered
 * between 0 and n - 1. You are given a 2D array graph, where graph[u] is an
 * array of nodes that node u is adjacent to. More formally, for each v in
 * graph[u], there is an undirected edge between node u and node v. The graph
 * has the following properties:
 * 
 * There are no self-edges (graph[u] does not contain u).
 * There are no parallel edges (graph[u] does not contain duplicate values).
 * If v is in graph[u], then u is in graph[v] (the graph is undirected).
 * The graph may not be connected, meaning there may be two nodes u and v such
 * that there is no path between them.
 * A graph is bipartite if the nodes can be partitioned into two independent
 * sets A and B such that every edge in the graph connects a node in set A and a
 * node in set B.
 * 
 * Return true if and only if it is bipartite.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class BipartiteGraph {

    // Time -> O(V + E) //
    // Space -> O(V) //

    public static boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adj) {
        color[node] = col;

        for (int neighbor : adj.get(node)) {
            if (color[neighbor] == -1) {
                if (!dfs(neighbor, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[neighbor] == col) {
                return false;
            }
        }
        
        return true;
    }

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static boolean bfs(int start, int v, ArrayList<ArrayList<Integer>> adj, int[] color) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(start);

        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean isBipartite(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[v];

        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                // if (!dfs(i, 0, color, adj)) {
                if (!bfs(i, v, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 8;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 2, 6);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 6, 5);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 4, 7);
        addEdge(adjList, 7, 8);

        System.out.println(isBipartite(v, adjList));
    }
}