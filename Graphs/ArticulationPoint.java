/*
 * Given an undirected connected graph with V vertices and adjacency list adj.
 * You are required to find all the vertices removing which (and edges through
 * it) disconnects the graph into 2 or more components and return it in sorted
 * manner.
 * Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might
 * be loops present in the graph.
 */

import java.util.ArrayList;

// Time -> O(V + E) //
// Space -> O(V + E) //

class ArticulationPoint {
    private static int timer = 1;

    private static void dfs(int node, int parent, boolean[] vis, boolean[] mark, int[] time, int[] low,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;

        int child = 0;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            if (!vis[neighbor]) {
                dfs(neighbor, node, vis, mark, time, low, adj);

                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] >= time[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], time[neighbor]);
            }
        }

        if (child > 1 && parent == -1) {
            mark[node] = true;
        }
    }

    private static ArrayList<Integer> articulationPoints(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] mark = new boolean[v];
        int[] time = new int[v];
        int[] low = new int[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, mark, time, low, adj);
            }
        }

        ArrayList<Integer> points = new ArrayList<Integer>();

        for (int i = 0; i < v; i++) {
            if (mark[i]) {
                points.add(i);
            }
        }

        if (points.isEmpty()) {
            points.add(-1);
        }

        return points;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 7;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 0, 2);
        addEdge(adjList, 0, 3);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 4, 6);
        addEdge(adjList, 5, 6);

        System.out.println(articulationPoints(v, adjList));
    }
}