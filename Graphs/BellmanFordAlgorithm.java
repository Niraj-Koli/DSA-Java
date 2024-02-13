// Time -> O(V x E)
// Space -> O(V)

public class BellmanFordAlgorithm {
    public static int[] bellmanFord(int n, int[][] edges, int src) {
        int[] dist = new int[n];

        for (int i = 0; i < n; i++) {
            dist[i] = (int) (1e8);
        }

        dist[src] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                // Negative Cycle
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int n = 6;

        int[][] edges = {
                { 0, 1, 5 },
                { 1, 5, -3 },
                { 1, 2, -2 },
                { 5, 3, 1 },
                { 2, 4, 3 },
                { 3, 2, 6 },
                { 3, 4, -2 },
        };

        int src = 0;

        int[] ans = bellmanFord(n, edges, src);

        for (int answer : ans) {
            System.out.print(answer + " ");
        }
    }
}
