/*
 * Given an adjacency list of a graph adj of V no. of vertices having 0 based
 * index. Check whether the graph is bipartite or not.
 */

// Time -> O(V + 2E)
// Space -> O(V)

import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

public class BipartiteGraph {
    public static boolean dfs(int node, int col, int[] color, List<List<Integer>> adj) {
        color[node] = col;

        for (int adjNode : adj.get(node)) {
            if (color[adjNode] == -1) {
                if (!dfs(adjNode, 1 - col, color, adj)) {
                    return false;
                }
            } else if (color[adjNode] == col) {
                return false;
            }
        }
        return true;
    }

    public static boolean bfs(int start, int v, List<List<Integer>> adj, int[] color) {
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(start);

        color[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int adjNode : adj.get(node)) {
                if (color[adjNode] == -1) {
                    color[adjNode] = 1 - color[node];
                    queue.offer(adjNode);
                } else if (color[adjNode] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int v, List<List<Integer>> adj) {
        int[] color = new int[v];

        for (int i = 0; i < v; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < v; i++) {
            if (color[i] == -1) {
                // if (!dfs(i, 0, color, adj)) {
                if (!bfs(i, v, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 8;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 2, 6);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 6, 5);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 4, 7);
        addEdge(adjList, 7, 8);

        boolean ans = isBipartite(v, adjList);

        System.out.println(ans);
    }
}