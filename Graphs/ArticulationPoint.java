/*
 * Given an undirected connected graph with V vertices and adjacency list adj.
 * You are required to find all the vertices removing which (and edges through
 * it) disconnects the graph into 2 or more components and return it in sorted
 * manner.
 * Note: Indexing is zero-based i.e nodes numbering from (0 to V-1). There might
 * be loops present in the graph.
 */

// Time -> O(V + 2E)
// Space -> O(5V)

import java.util.ArrayList;
import java.util.List;

public class ArticulationPoint {
    public static int timer = 1;

    public static void dfs(int node, int parent, boolean[] vis, boolean[] mark, int[] time, int[] low,
            List<List<Integer>> adj) {
        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;

        int child = 0;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) {
                continue;
            }

            if (!vis[adjNode]) {
                dfs(adjNode, node, vis, mark, time, low, adj);

                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] >= time[node] && parent != -1) {
                    mark[node] = true;
                }
                child++;
            } else {
                low[node] = Math.min(low[node], time[adjNode]);
            }
        }

        if (child > 1 && parent == -1) {
            mark[node] = true;
        }
    }

    public static List<Integer> articulationPoints(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] mark = new boolean[v];
        int[] time = new int[v];
        int[] low = new int[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, -1, vis, mark, time, low, adj);
            }
        }

        List<Integer> points = new ArrayList<Integer>();

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

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 7;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

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

        List<Integer> ans = articulationPoints(v, adjList);

        System.out.println(ans);
    }
}