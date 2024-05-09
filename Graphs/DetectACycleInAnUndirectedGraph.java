/*
 * Given an undirected graph with V vertices labelled from 0 to V-1 and E edges,
 * check whether it contains any cycle or not. Graph is in the form of adjacency
 * list where adj[i] contains all the nodes ith node is having edge with.
 */

import java.util.ArrayList;
import java.util.ArrayDeque;

class DetectACycleInAnUndirectedGraph {

    // Time -> O(V + E) //
    // Space -> O(V) //

    public static boolean dfs(int node, int parent, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, node, vis, adj)) {
                    return true;
                }
            } else if (vis[neighbor] && (neighbor != parent)) {
                return true;
            }
        }
        
        return false;
    }

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static boolean bfs(int src, boolean[] vis, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { src, -1 });

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int node = point[0];
            int parent = point[1];

            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    queue.offer(new int[] { neighbor, node });
                    vis[neighbor] = true;
                } else if (vis[neighbor] && (parent != neighbor)) {
                    return true;
                }
            }
        }

        return false;
    }

    // Time -> O(V) //
    // Space -> O(V) //

    private static boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
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

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 3, 6);
        addEdge(adjList, 5, 7);
        addEdge(adjList, 6, 7);

        System.out.println(isCycle(v, adjList));
    }
}