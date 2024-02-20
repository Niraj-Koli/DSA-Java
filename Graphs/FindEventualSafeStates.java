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

// Time -> O(V + E)
// Space -> O(V)

import java.util.Collections;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
    public static List<Integer> bfs(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        List<List<Integer>> adjRev = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            adjRev.add(new ArrayList<Integer>());
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int adjNode : adj.get(i)) {
                adjRev.get(adjNode).add(i);
                indegree[i]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        List<Integer> safeNodes = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            safeNodes.add(node);

            for (int adjNode : adjRev.get(node)) {
                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }

        Collections.sort(safeNodes);

        return safeNodes;
    }

    public static boolean dfs(int node, boolean[] vis, boolean[] pathVis, boolean[] check, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;
        check[node] = false;

        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, vis, pathVis, check, adj)) {
                    return true;
                }
            } else if (pathVis[adjNode]) {
                return true;
            }
        }
        check[node] = true;
        pathVis[node] = false;

        return false;
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<Integer>());
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

        List<Integer> safeNodes = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            if (check[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

        List<Integer> ans = eventualSafeNodes(graph);

        System.out.println(ans);
    }
}

// class Solution {
// public List<Integer> eventualSafeNodes(int[][] graph) {
// int n = graph.length;
// int[] color = new int[n];
// List<Integer> ans = new ArrayList<Integer>();
// for (int i = 0; i < n; ++i) {
// if (safe(graph, color, i)) {
// ans.add(i);
// }
// }
// return ans;
// }

// public boolean safe(int[][] graph, int[] color, int x) {
// if (color[x] > 0) {
// return color[x] == 2;
// }
// color[x] = 1;
// for (int y : graph[x]) {
// if (!safe(graph, color, y)) {
// return false;
// }
// }
// color[x] = 2;
// return true;
// }
// }
