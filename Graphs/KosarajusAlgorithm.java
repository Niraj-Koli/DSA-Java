import java.util.ArrayDeque;
import java.util.ArrayList;

class KosarajusAlgorithm {

    // Time -> O(V + E) //
    // Space -> O(V + E) //

    private static void dfsSort(int node, boolean[] vis, ArrayDeque<Integer> stack, ArrayList<ArrayList<Integer>> adj) {
        vis[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfsSort(neighbor, vis, stack, adj);
            }
        }

        stack.offer(node);
    }

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT, ArrayList<Integer> component) {
        vis[node] = true;
        component.add(node);

        for (int neighbor : adjT.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adjT, component);
            }
        }
    }

    private static ArrayList<ArrayList<Integer>> kosaraju(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                dfsSort(i, vis, stack, adj);
            }
        }

        ArrayList<ArrayList<Integer>> adjT = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < v; i++) {
            adjT.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < v; i++) {
            vis[i] = false;

            for (int neighbor : adj.get(i)) {
                adjT.get(neighbor).add(i);
            }
        }

        ArrayList<ArrayList<Integer>> stronglyConnectedComponents = new ArrayList<ArrayList<Integer>>();

        while (!stack.isEmpty()) {
            int node = stack.pollLast();

            if (!vis[node]) {
                ArrayList<Integer> component = new ArrayList<Integer>();
                dfs(node, vis, adjT, component);
                stronglyConnectedComponents.add(component);
            }
        }

        return stronglyConnectedComponents;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
    }

    public static void main(String[] args) {
        int v = 8;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

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

        System.out.println(kosaraju(v, adjList).size());
        System.out.println(kosaraju(v, adjList));
    }
}
