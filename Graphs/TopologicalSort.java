/*
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any
 * Topological Sorting of that Graph.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class TopologicalSort {

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static void dfs(int node, boolean[] vis, ArrayDeque<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, stack, adj);
            }
        }
        
        stack.offer(node);
    }

    private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
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

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
    }

    public static void main(String[] args) {
        int v = 6;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<>());
        }

        addEdge(adjList, 5, 0);
        addEdge(adjList, 5, 2);
        addEdge(adjList, 4, 0);
        addEdge(adjList, 4, 1);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 1);

        int[] ans = topoSort(v, adjList);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}