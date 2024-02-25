/*
 * You are given a weighted undirected graph having n+1 vertices numbered from 0
 * to n and m edges describing there are edges between a to b with some weight,
 * find the shortest path between the vertex 1 and the vertex n, and if the path
 * does not exist then return a list consisting of only -1.
 */

// Time -> O(E log(V)) + O(N)
// Space -> O(V)

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class PrintShortestPathInAWeightedUndirectedGraph {
    private static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static List<Integer> shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dist[i] = (int) (1e9);
            parent[i] = i;
        }

        dist[1] = 0;
        pq.offer(new Pair(1, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            for (Pair pair : adj.get(node)) {
                int adjNode = pair.node;
                int edgeWeight = pair.distance;

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                    parent[adjNode] = node;
                }
            }
        }

        List<Integer> path = new ArrayList<Integer>();

        if (dist[n] == 1e9) {
            return path;
        }

        int node = n;

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];
        }

        path.add(1);

        Collections.reverse(path);

        return path;
    }

    public static void main(String[] args) {
        int v = 5;
        int e = 6;

        int[][] edges = {
                { 1, 2, 2 },
                { 2, 5, 5 },
                { 2, 3, 4 },
                { 1, 4, 1 },
                { 4, 3, 3 },
                { 3, 5, 1 }
        };

        List<Integer> ans = shortestPath(v, e, edges);

        System.out.println(ans);
    }
}