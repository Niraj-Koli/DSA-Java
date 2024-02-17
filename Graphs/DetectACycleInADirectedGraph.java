/*
 * Given a Directed Graph with V vertices (Numbered from 0 to V-1) and E edges,
 * check whether it contains any cycle or not.
 */

// Time -> O(V + E)
// Space -> O(V)

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class DetectACycleInADirectedGraph {
    public static boolean bfs(int v, List<List<Integer>> adj) {
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int adjNode : adj.get(i)) {
                indegree[adjNode]++;
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

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
        }
        return count == v ? false : true;
    }

    public static boolean dfs(int node, boolean[] vis, boolean[] pathVis, List<List<Integer>> adj) {
        vis[node] = true;
        pathVis[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                if (dfs(adjNode, vis, pathVis, adj)) {
                    return true;
                }
            } else if (pathVis[adjNode]) {
                return true;
            }
        }
        pathVis[node] = false;

        return false;
    }

    public static boolean isCyclic(int v, List<List<Integer>> adj) {
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

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
    }

    public static void main(String[] args) {
        int v = 11;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

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

        boolean ans = isCyclic(v, adjList);

        System.out.println(ans);
    }
}