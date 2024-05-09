/*
 * There are n cities connected by some number of flights. You are given an
 * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
 * a flight from city fromi to city toi with cost pricei.
 * 
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class CheapestFlightsWithinKStops {
    private static class Pair {
        private int node;
        private int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Tuple {
        private int node;
        private int stops;
        private int distance;

        public Tuple(int node, int stops, int distance) {
            this.node = node;
            this.stops = stops;
            this.distance = distance;
        }
    }

    // Time -> O(V * E) //
    // Space -> O(V + E) //

    private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m = flights.length;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int w = flights[i][2];

            adj.get(u).add(new Pair(v, w));
        }

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }

        dist[src] = 0;

        ArrayDeque<Tuple> queue = new ArrayDeque<Tuple>();
        queue.offer(new Tuple(src, 0, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            int node = tuple.node;
            int stops = tuple.stops;
            int distance = tuple.distance;

            if (stops > k) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (distance + edgeWeight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = distance + edgeWeight;
                    queue.offer(new Tuple(adjNode, stops + 1, distance + edgeWeight));
                }
            }
        }

        if (dist[dst] == (1e9)) {
            return -1;
        }

        return dist[dst];
    }

    public static void main(String[] args) {
        int n = 4;

        int[][] flights = {
                { 0, 1, 100 },
                { 1, 2, 100 },
                { 2, 0, 100 },
                { 1, 3, 600 },
                { 2, 3, 200 },
        };

        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}