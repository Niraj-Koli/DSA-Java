
import java.util.ArrayList;

class DepthFirstSearch {

    // Time -> O(V + E) //
    // Space -> O(V) //

    private static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> res) {
        vis[node] = true;
        res.add(node);

        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, res);
            }
        }
    }

    private static ArrayList<Integer> depthFirstSearch(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[v];
        vis[0] = true;

        ArrayList<Integer> res = new ArrayList<Integer>();

        dfs(0, vis, adj, res);

        return res;
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adj, int vertex1, int vertex2) {
        adj.get(vertex1).add(vertex2);
        adj.get(vertex2).add(vertex1);
    }

    public static void main(String[] args) {
        int v = 9;

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();

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

        System.out.println(depthFirstSearch(v, adjList));
    }
}
