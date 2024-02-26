/*
 * You are given an Undirected Graph having unit weight, Find the shortest path
 * from src to all the vertex and if it is unreachable to reach any vertex, then
 * return -1 for that vertex.
 */

// Time -> O(V + 2E)
// Space -> O(N x M)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class ShortestPathInUndirectedGraphWithUnitWeights {
    public static int[] shortestPath(int[][] edges, int n, int m, int src) {
        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) 1e9;
        }

        dist[src] = 0;

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(src);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adjNode : adj.get(node)) {
                if (dist[node] + 1 < dist[adjNode]) {
                    dist[adjNode] = 1 + dist[node];
                    queue.offer(adjNode);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) {
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

        for (int answer : ans) {
            System.out.print(answer + " ");
        }
    }
}