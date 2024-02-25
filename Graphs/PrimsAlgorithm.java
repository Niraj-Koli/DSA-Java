// Time -> O(E Log(E))
// Space -> O(E)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
    private static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static int spanningTree(int v, List<List<List<Integer>>> adj) {
        boolean[] vis = new boolean[v];

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.weight - y.weight);
        pq.offer(new Pair(0, 0));

        int sum = 0;

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();

            int node = pair.node;
            int wt = pair.weight;

            if (vis[node]) {
                continue;
            }

            vis[node] = true;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (!vis[adjNode]) {
                    pq.offer(new Pair(adjNode, edgeWeight));
                }
            }
        }

        return sum;
    }

    private static void addEdge(List<List<List<Integer>>> adj, int u, int v, int w) {
        adj.get(u).add(Arrays.asList(v, w));
        adj.get(v).add(Arrays.asList(u, w));
    }

    public static void main(String[] args) {
        int v = 5;

        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1, 2);
        addEdge(adj, 0, 2, 1);
        addEdge(adj, 1, 2, 1);
        addEdge(adj, 2, 3, 2);
        addEdge(adj, 2, 4, 2);
        addEdge(adj, 3, 4, 1);

        int ans = spanningTree(v, adj);

        System.out.println(ans);
    }
}
