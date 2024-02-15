/*
 * There are n cities connected by some number of flights. You are given an
 * array flights where flights[i] = [fromi, toi, pricei] indicates that there is
 * a flight from city fromi to city toi with cost pricei.
 * 
 * You are also given three integers src, dst, and k, return the cheapest price
 * from src to dst with at most k stops. If there is no such route, return -1.
 */

// Time -> O(E)
// Space -> O(N)

import java.util.ArrayDeque;
import java.util.ArrayList;

public class CheapestFlightsWithinKStops {
    private static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    private static class Tuple {
        int stops;
        int node;
        int distance;

        Tuple(int stops, int node, int distance) {
            this.stops = stops;
            this.node = node;
            this.distance = distance;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int m = flights.length;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<ArrayList<Pair>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Pair>());
        }

        for (int i = 0; i < m; i++) {
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }

        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e9);
        }

        dist[src] = 0;

        ArrayDeque<Tuple> queue = new ArrayDeque<Tuple>();
        queue.offer(new Tuple(0, src, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            int stops = tuple.stops;
            int node = tuple.node;
            int distance = tuple.distance;

            if (stops > k) {
                continue;
            }

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.node;
                int edgeWeight = neighbor.weight;

                if (distance + edgeWeight < dist[adjNode] && stops <= k) {
                    dist[adjNode] = distance + edgeWeight;
                    queue.offer(new Tuple(stops + 1, adjNode, distance + edgeWeight));
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
        int dist = 3;
        int k = 1;

        int ans = findCheapestPrice(n, flights, src, dist, k);

        System.out.println(ans);
    }
}

// class Solution {
// public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
// {
// int[] distance = new int[n];
// Arrays.fill(distance, Integer.MAX_VALUE);
// distance[src] = 0;
// for (int i = 0; i <= k; i++) {
// if (isRoutePossible(distance, flights)) {
// break;
// }
// }
// return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
// }

// private boolean isRoutePossible(int[] dist, int[][] flights) {
// int[] copy = Arrays.copyOf(dist, dist.length);
// boolean result = true;

// for (int[] flight : flights) {
// int src = flight[0];
// int dst = flight[1];
// int cost = flight[2];

// if (copy[src] < Integer.MAX_VALUE && dist[dst] > dist[src] + cost) {
// dist[dst] = cost + copy[src];
// result = false;
// }
// }
// return result;
// }
// }