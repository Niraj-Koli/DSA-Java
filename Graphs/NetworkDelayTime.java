/*
 * You are given a network of n nodes, labeled from 1 to n. You are also given
 * times, a list of travel times as directed edges times[i] = (ui, vi, wi),
 * where ui is the source node, vi is the target node, and wi is the time it
 * takes for a signal to travel from source to target.
 * 
 * We will send a signal from a given node k. Return the minimum time it takes
 * for all the n nodes to receive the signal. If it is impossible for all the n
 * nodes to receive the signal, return -1.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class NetworkDelayTime {
    private static class Pair {
        private int node;
        private int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    // Time -> O(E * log(V)) //
    // Space -> O(V) //

    private static int networkDelayTime(int[][] times, int n, int k) {
        int m = times.length;

        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < m; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int w = times[i][2];

            adj.get(u).add(new ArrayList<Integer>(Arrays.asList(v, w)));
        }

        int[] dist = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dist[i] = (int) (1e9);
        }

        dist[k] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> Integer.compare(x.distance, y.distance));
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            int node = pair.node;
            int distance = pair.distance;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int neighbor = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (distance + edgeWeight < dist[neighbor]) {
                    dist[neighbor] = distance + edgeWeight;
                    pq.offer(new Pair(neighbor, dist[neighbor]));
                }
            }
        }

        int time = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) (1e9)) {
                return -1;
            }

            time = Math.max(time, dist[i]);
        }

        return time;
    }

    public static void main(String[] args) {
        int[][] times = {
                { 2, 1, 1 },
                { 2, 3, 1 },
                { 3, 4, 1 },
        };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));
    }
}