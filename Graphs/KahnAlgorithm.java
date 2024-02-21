/*
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any
 * Topological Sorting of that Graph.
 */

// Time -> O(V + E)
// Space -> O(V)

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class KahnAlgorithm {
    public static int[] topoSort(int v, List<List<Integer>> adj) {
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

        int[] res = new int[v];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            res[index++] = node;

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;

                if (indegree[adjNode] == 0) {
                    queue.offer(adjNode);
                }
            }
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