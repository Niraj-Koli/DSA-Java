/*
 * Given an undirected graph with V vertices labelled from 0 to V-1 and E edges,
 * check whether it contains any cycle or not. Graph is in the form of adjacency
 * list where adj[i] contains all the nodes ith node is having edge with.
 */

// Time -> O(V + 2E) 
// Space -> O(V)

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class DetectACycleInAnUndirectedGraph {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static boolean dfs(int node, int parent, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;

        for (int neighbors : adj.get(node)) {
            if (!vis[neighbors]) {
                if (dfs(neighbors, node, vis, adj)) {
                    return true;
                }
            } else if (vis[neighbors] && (neighbors != parent)) {
                return true;
            }
        }
        return false;
    }

    public static boolean bfs(int src, boolean[] vis, List<List<Integer>> adj) {
        vis[src] = true;

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(src, -1));

        while (!queue.isEmpty()) {
            int node = queue.peek().first;
            int parent = queue.peek().second;
            queue.poll();

            for (int neighbors : adj.get(node)) {
                if (!vis[neighbors]) {
                    vis[neighbors] = true;
                    queue.offer(new Pair(neighbors, node));
                } else if (vis[neighbors] && (parent != neighbors)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCycle(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                // if (dfs(i, -1, vis, adj)) {
                if (bfs(i, vis, adj)) {
                    return true;
                }

            }
        }
        return false;
    }

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 8;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 3, 6);
        addEdge(adjList, 5, 7);
        addEdge(adjList, 6, 7);

        boolean ans = isCycle(v, adjList);

        System.out.println(ans);
    }
}