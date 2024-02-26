/*
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any
 * Topological Sorting of that Graph.
 */

// Time -> O(V + E)
// Space -> O(V)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class TopologicalSort {
    public static void dfs(int node, boolean[] vis, ArrayDeque<Integer> stack, List<List<Integer>> adj) {
        vis[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, vis, stack, adj);
            }
        }
        stack.offer(node);
    }

    public static int[] topoSort(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfs(i, vis, stack, adj);
            }
        }

        int[] res = new int[v];
        int index = 0;

        while (!stack.isEmpty()) {
            res[index++] = stack.pollLast();
        }
        return res;
    }

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
    }

    public static void main(String[] args) {
        int v = 6;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 5, 0);
        addEdge(adjList, 5, 2);
        addEdge(adjList, 4, 0);
        addEdge(adjList, 4, 1);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 1);

        int[] ans = topoSort(v, adjList);

        for (int answer : ans) {
            System.out.print(answer + " ");
        }
    }
}