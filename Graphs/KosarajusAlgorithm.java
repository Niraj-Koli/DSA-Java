// Time -> O(V + E)
// Space -> O(V + E) + O(V)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class KosarajusAlgorithm {
    public static void dfsSort(int node, boolean[] vis, ArrayDeque<Integer> stack, List<List<Integer>> adj) {
        vis[node] = true;

        for (int adjNode : adj.get(node)) {
            if (!vis[adjNode]) {
                dfsSort(adjNode, vis, stack, adj);
            }
        }

        stack.offer(node);
    }

    public static void dfs(int node, boolean[] vis, List<List<Integer>> adjT, List<Integer> component) {
        vis[node] = true;
        component.add(node);

        for (int adjNode : adjT.get(node)) {
            if (!vis[adjNode]) {
                dfs(adjNode, vis, adjT, component);
            }
        }
    }

    public static List<List<Integer>> kosaraju(int v, List<List<Integer>> adj) {
        boolean[] vis = new boolean[v];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfsSort(i, vis, stack, adj);
            }
        }

        List<List<Integer>> adjT = new ArrayList<List<Integer>>();

        for (int i = 0; i < v; i++) {
            adjT.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < v; i++) {
            vis[i] = false;

            for (int adjNode : adj.get(i)) {
                adjT.get(adjNode).add(i);
            }
        }

        List<List<Integer>> sscList = new ArrayList<List<Integer>>();

        while (!stack.isEmpty()) {
            int node = stack.pollLast();

            if (!vis[node]) {
                List<Integer> sscComponent = new ArrayList<Integer>();
                dfs(node, vis, adjT, sscComponent);
                sscList.add(sscComponent);
            }
        }

        return sscList;
    }

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
    }

    public static void main(String[] args) {
        int v = 8;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 0);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 4);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 5, 6);
        addEdge(adjList, 6, 4);
        addEdge(adjList, 4, 7);
        addEdge(adjList, 6, 7);

        List<List<Integer>> ans = kosaraju(v, adjList);

        System.out.println(ans.size());
        System.out.println(ans);
    }
}
