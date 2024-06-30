/*
 * There is a directed graph of n nodes with each node labeled from 0 to n - 1.
 * The graph is represented by a 0-indexed 2D integer array graph where graph[i]
 * is an integer array of nodes adjacent to node i, meaning there is an edge
 * from node i to each node in graph[i].
 * 
 * A node is a terminal node if there are no outgoing edges. A node is a safe
 * node if every possible path starting from that node leads to a terminal node
 * (or another safe node).
 * 
 * Return an array containing all the safe nodes of the graph. The answer should
 * be sorted in ascending order.
 */

import java.util.Collections;
import java.util.ArrayDeque;
import java.util.ArrayList;

class FindEventualSafeStates {

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static ArrayList<Integer> topoSort(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                adjRev.get(neighbor).add(i);
                indegree[i]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<Integer>();

        while (!queue.isEmpty()) {
            int node = queue.poll();

            safeNodes.add(node);

            for (int neighbor : adjRev.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static boolean dfs(int node, boolean[] vis, boolean[] pathVis, boolean[] check,
            ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, vis, pathVis, check, adj)) {
                    return true;
                }
            } else if (pathVis[neighbor]) {
                return true;
            }
        }

        check[node] = true;
        pathVis[node] = false;

        return false;
    }

    private static ArrayList<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        boolean[] vis = new boolean[n];
        boolean[] pathVis = new boolean[n];
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, vis, pathVis, check, adj);
            }
        }

        ArrayList<Integer> safeNodes = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                safeNodes.add(i);
            }
        }

        return safeNodes;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

        System.out.println(eventualSafeNodes(graph));
        System.out.println(topoSort(graph));
    }
}