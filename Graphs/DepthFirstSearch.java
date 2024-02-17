// Time -> O(V + 2E)
// Space -> O(V)

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    public static void dfs(int node, boolean[] vis, List<List<Integer>> adj, List<Integer> res) {
        vis[node] = true;
        res.add(node);

        for (int vertex : adj.get(node)) {
            if (vis[vertex] == false) {
                dfs(vertex, vis, adj, res);
            }
        }
    }

    public static List<Integer> depthFirstSearch(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v + 1];
        vis[0] = true;

        List<Integer> res = new ArrayList<Integer>();

        dfs(0, vis, adj, res);

        return res;
    }

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 9;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 3);
        addEdge(adjList, 2, 5);
        addEdge(adjList, 2, 6);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 3, 7);
        addEdge(adjList, 4, 8);
        addEdge(adjList, 7, 8);

        List<Integer> ans = depthFirstSearch(v, adjList);

        System.out.println(ans);
    }
}
