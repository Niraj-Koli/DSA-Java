/*
 * You are given an Undirected Graph having unit weight, Find the shortest path
 * from src to all the vertex and if it is unreachable to reach any vertex, then
 * return -1 for that vertex.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class ShortestPathInUndirectedGraphWithUnitWeights {

    // Time -> O(V + E) //
    // Space -> O(V + E) //

    private static int[] shortestPath(int[][] edges, int n, int m, int src) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }

        dist[src] = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : adj.get(node)) {
                if (dist[node] + 1 < dist[neighbor]) {
                    dist[neighbor] = 1 + dist[node];
                    queue.offer(neighbor);
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
                { 0, 1 }, { 0, 3 }, { 3, 4 },
                { 4, 5 }, { 5, 6 }, { 1, 2 },
                { 2, 6 }, { 6, 7 }, { 7, 8 },
                { 6, 8 }
        };
        int n = 9;
        int m = 10;
        int src = 0;

        int[] ans = shortestPath(edges, n, m, src);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}