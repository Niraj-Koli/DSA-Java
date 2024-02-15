// Time -> O(V + 2E)
// Space -> O(V)

import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BreadthFirstSearch {
    public static List<Integer> breadthFirstSearch(int v, List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<Integer>();

        boolean[] vis = new boolean[v];

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for (int vertex : adj.get(node)) {
                if (vis[vertex] == false) {
                    vis[vertex] = true;
                    queue.offer(vertex);
                }
            }
        }
        return res;
    }

    public static void addEdge(List<List<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 10;

        List<List<Integer>> adjList = new ArrayList<List<Integer>>();

        for (int i = 0; i <= v; i++) {
            adjList.add(new ArrayList<Integer>());
        }

        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 1, 6);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 2, 4);
        addEdge(adjList, 6, 7);
        addEdge(adjList, 6, 9);
        addEdge(adjList, 4, 5);
        addEdge(adjList, 7, 8);

        List<Integer> ans = breadthFirstSearch(v, adjList);

        System.out.println(ans);
    }
}
