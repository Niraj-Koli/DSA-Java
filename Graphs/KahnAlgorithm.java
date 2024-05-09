/*
 * Given a Directed Acyclic Graph (DAG) with V vertices and E edges, Find any
 * Topological Sorting of that Graph.
 */

import java.util.ArrayDeque;
import java.util.ArrayList;

class KahnAlgorithm {

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static int[] topoSort(int v, ArrayList<ArrayList<Integer>> adj) {
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

        int[] res = new int[v];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            res[index++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
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
            adjList.add(new ArrayList<Integer>());
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