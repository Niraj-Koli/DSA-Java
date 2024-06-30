/*
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 * check whether it contains any cycle or not.
 */

import java.util.ArrayList;
import java.util.ArrayDeque;

class DetectACycleInADirectedGraph {

    // Time -> O(V + E)
    // Space -> O(V)

    private static boolean topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == v ? false : true;
    }

    // Time -> O(V + E)
    // Space -> O(V)

    private static boolean dfs(int node, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, vis, pathVis, adj)) {
                    return true;
                }
            } else if (pathVis[neighbor]) {
                return true;
            }
        }
        
        pathVis[node] = false;

        return false;
    }

    private static boolean isCyclic(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        boolean[] pathVis = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                if (dfs(i, vis, pathVis, adj)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
    }

    public static void main(String[] args) {
        int v = 11;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 3, 7);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, 6);
        addEdge(adjList, 7, 5);
        addEdge(adjList, 8, 9);
        addEdge(adjList, 9, 10);
        addEdge(adjList, 10, 8);

        System.out.println(topoSort(v, adjList));
        System.out.println(isCyclic(v, adjList));
    }
}