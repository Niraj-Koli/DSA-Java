// Time -> O(E log(V))
// Space -> O(V)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {
    private static class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static int[] dijkstra(int v, List<List<List<Integer>>> adj, int src) {
        int[] dist = new int[v];

        for (int i = 0; i < v; i++) {
            dist[i] = (int) (1e9);
        }

        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int node = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            for (int i = 0; i < adj.get(node).size(); i++) {
                int adjNode = adj.get(node).get(i).get(0);
                int edgeWeight = adj.get(node).get(i).get(1);

                if (distance + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = distance + edgeWeight;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        return dist;
    }

    private static void addEdge(List<List<List<Integer>>> adj, int u, int v, int w) {
        adj.get(u).add(Arrays.asList(v, w));
        adj.get(v).add(Arrays.asList(u, w));
    }

    public static void main(String[] args) {
        int v = 6;

        List<List<List<Integer>>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        addEdge(adj, 0, 1, 4);
        addEdge(adj, 0, 2, 4);
        addEdge(adj, 1, 2, 2);
        addEdge(adj, 2, 3, 3);
        addEdge(adj, 2, 4, 1);
        addEdge(adj, 2, 5, 6);
        addEdge(adj, 3, 5, 2);
        addEdge(adj, 4, 5, 3);

        int src = 0;

        int[] ans = dijkstra(v, adj, src);

        for (int answer : ans) {
            System.out.print(answer + " ");
        }
    }
}
