/*
 * Given a Directed Acyclic Graph of N vertices from 0 to N-1 and a 2D Integer
 * array(or vector) edges[ ][ ] of length M, where there is a directed edge from
 * edge[i][0] to edge[i][1] with a distance of edge[i][2] for all i.
 * 
 * Find the shortest path from src(0) vertex to all the vertices and if it is
 * impossible to reach any vertex, then return -1 for that vertex.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class ShortestPathInDirectedAcyclicGraph {
    private static class Pair {
        private int node;
        private int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    // Time -> O(V + E) //
    // Space -> O(V + E) //

    private static void dfs(int node, boolean[] vis, ArrayDeque<Integer> stack, ArrayList<ArrayList<Pair>> adj) {
        vis[node] = true;

        int n = adj.get(node).size();

        for (int i = 0; i < n; i++) {
            int v = adj.get(node).get(i).node;

            if (!vis[v]) {
                dfs(v, vis, stack, adj);
            }
        }
        stack.offer(node);
    }

    private static int[] shortestPath(int[][] edges, int n, int m) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            adj.get(u).add(new Pair(v, wt));
        }

        boolean[] vis = new boolean[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, stack, adj);
            }
        }

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }

        dist[0] = 0;

        while (!stack.isEmpty()) {
            int node = stack.pollLast();

            int size = adj.get(node).size();

            for (int i = 0; i < size; i++) {
                int v = adj.get(node).get(i).node;
                int wt = adj.get(node).get(i).weight;

                if (dist[node] + wt < dist[v]) {
                    dist[v] = wt + dist[node];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == (int) (1e9)) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {
                { 0, 1, 2 },
                { 0, 4, 1 },
                { 4, 5, 4 },
                { 4, 2, 2 },
                { 1, 2, 3 },
                { 2, 3, 6 },
                { 5, 3, 1 }
        };
        int n = 6;
        int m = 7;

        int[] ans = shortestPath(edges, n, m);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}