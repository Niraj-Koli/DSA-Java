
import java.util.ArrayList;
import java.util.ArrayDeque;

class BreadthFirstSearch {

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static ArrayList<Integer> breadthFirstSearch(int v, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> res = new ArrayList<Integer>();

        boolean[] vis = new boolean[v];

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(0);
        vis[0] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);

            for (int neighbor : adj.get(node)) {
                if (!vis[neighbor]) {
                    queue.offer(neighbor);
                    vis[neighbor] = true;
                }
            }
        }

        return res;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 10;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

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

        System.out.println(breadthFirstSearch(v, adjList));
    }
}
