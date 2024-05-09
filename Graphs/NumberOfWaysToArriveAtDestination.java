/*
 * You are in a city that consists of n intersections numbered from 0 to n - 1
 * with bi-directional roads between some intersections. The inputs are
 * generated such that you can reach any intersection from any other
 * intersection and that there is at most one road between any two
 * intersections.
 * 
 * You are given an integer n and a 2D integer array roads where roads[i] = [ui,
 * vi, timei] means that there is a road between intersections ui and vi that
 * takes timei minutes to travel. You want to know in how many ways you can
 * travel from intersection 0 to intersection n - 1 in the shortest amount of
 * time.
 * 
 * Return the number of ways you can arrive at your destination in the shortest
 * amount of time. Since the answer may be large, return it modulo 109 + 7.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

class NumberOfWaysToArriveAtDestination {
    private static class Pair {
        private int node;
        private long distance;

        public Pair(int node, long distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Time -> O(V + (E * log(V))) //
    // Space -> O(V + E) //

    private static int countPaths(int n, int[][] roads) {
        int m = roads.length;

        int mod = (int) (1e9 + 7);

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int w = roads[i][2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        long[] dist = new long[n];
        int[] ways = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (long) (1e18);
            ways[i] = 0;
        }

        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> (int) (x.distance - y.distance));
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            int node = pair.node;
            long distance = pair.distance;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                long edgeWeight = neighbor.distance;

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    ways[adjNode] = ways[node];
                    pq.offer(new Pair(adjNode, distance + edgeWeight));
                } else if (distance + edgeWeight == dist[adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }

    public static void main(String[] args) {
        int n = 7;

        int[][] roads = {
                { 0, 6, 7 },
                { 0, 1, 2 },
                { 1, 2, 3 },
                { 1, 3, 3 },
                { 6, 3, 3 },
                { 3, 5, 1 },
                { 6, 5, 1 },
                { 2, 5, 1 },
                { 0, 4, 5 },
                { 4, 6, 2 },
        };

        System.out.println(countPaths(n, roads));
    }
}