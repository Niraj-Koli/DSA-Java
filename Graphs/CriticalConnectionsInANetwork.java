/*
 * There are n servers numbered from 0 to n - 1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [ai,
 * bi] represents a connection between servers ai and bi. Any server can reach
 * other servers directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some
 * servers unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * Bridges In Graph
 */

import java.util.ArrayList;
import java.util.Arrays;

// Time -> O(V + E) //
// Space -> O(V + E) //

class CriticalConnectionsInANetwork {
    private static int timer = 1;

    private static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] time,
            int[] low, ArrayList<ArrayList<Integer>> bridges) {
        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;

        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            }

            if (!vis[neighbor]) {
                dfs(neighbor, node, adj, vis, time, low, bridges);

                low[node] = Math.min(low[node], low[neighbor]);

                if (low[neighbor] > time[node]) {
                    bridges.add(new ArrayList<>(Arrays.asList(node, neighbor)));
                }
            } else {
                low[node] = Math.min(low[node], low[neighbor]);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> criticalConnections(int n, ArrayList<ArrayList<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (ArrayList<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];

        ArrayList<ArrayList<Integer>> bridges = new ArrayList<ArrayList<Integer>>();

        dfs(0, -1, adj, vis, time, low, bridges);

        return bridges;
    }

    public static void main(String[] args) {
        int v = 13;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        adjList.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1, 2)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(2, 3)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(4, 3)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(1, 4)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(4, 5)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(5, 6)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(6, 7)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(7, 8)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(6, 9)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(9, 8)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(8, 10)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(10, 11)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(10, 12)));
        adjList.add(new ArrayList<Integer>(Arrays.asList(11, 12)));

        System.out.println(criticalConnections(v, adjList));

    }
}