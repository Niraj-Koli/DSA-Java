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

// Time -> O(V + 2E)
// Space -> O(V + 2E) + O(3V)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInANetwork {
    private static int timer = 1;

    public static void dfs(int node, int parent, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int[] time,
            int[] low, List<List<Integer>> bridges) {
        vis[node] = true;
        time[node] = low[node] = timer;
        timer++;

        for (int adjNode : adj.get(node)) {
            if (adjNode == parent) {
                continue;
            }

            if (!vis[adjNode]) {
                dfs(adjNode, node, adj, vis, time, low, bridges);

                low[node] = Math.min(low[node], low[adjNode]);

                if (low[adjNode] > time[node]) {
                    bridges.add(Arrays.asList(node, adjNode));
                }
            } else {
                low[node] = Math.min(low[node], low[adjNode]);
            }
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] time = new int[n];
        int[] low = new int[n];

        List<List<Integer>> bridges = new ArrayList<List<Integer>>();

        dfs(0, -1, adj, vis, time, low, bridges);

        return bridges;
    }

    public static void main(String[] args) {
        int v = 13;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

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

        List<List<Integer>> ans = criticalConnections(v, adjList);

        System.out.println(ans);

    }
}

// class Solution {
// public List<List<Integer>> criticalConnections(int n, List<List<Integer>>
// connections) {
// List<List<Integer>> ans = new ArrayList<>();
// List<Integer>[] graph = new List[n];

// for (int i = 0; i < n; ++i)
// graph[i] = new ArrayList<>();

// for (List<Integer> connection : connections) {
// final int u = connection.get(0);
// final int v = connection.get(1);
// graph[u].add(v);
// graph[v].add(u);
// }
// int[] rank = new int[n];
// Arrays.fill(rank, NO_RANK);
// getRank(graph, 0, 0, rank, ans);
// return ans;
// }

// private static final int NO_RANK = -2;

// private int getRank(List<Integer>[] graph, int u, int myRank, int[] rank,
// List<List<Integer>> ans) {
// if (rank[u] != NO_RANK)
// return rank[u];

// rank[u] = myRank;
// int minRank = myRank;

// for (final int v : graph[u]) {
// if (rank[u] == rank.length || rank[v] == myRank - 1)
// continue;
// final int nextRank = getRank(graph, v, myRank + 1, rank, ans);
// if (nextRank == myRank + 1)
// ans.add(Arrays.asList(u, v));
// minRank = Math.min(minRank, nextRank);
// }

// rank[u] = rank.length; // Mark as visited.
// return minRank;
// }
// }