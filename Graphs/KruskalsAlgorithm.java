// Time -> O(V + E) + O(E log(E)) + O(E x 4α x 2)
// Space -> O(V) + O(V) + O(E)

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class KruskalsAlgorithm {
    private static class DisjointSet {
        ArrayList<Integer> parent = new ArrayList<Integer>();
        ArrayList<Integer> size = new ArrayList<Integer>();

        DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltimateParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findUltimateParent(parent.get(node));

            parent.set(node, ultimateParent);

            return parent.get(node);
        }

        public void unionBySize(int u, int v) {
            int ulp_u = findUltimateParent(u);
            int ulp_v = findUltimateParent(v);

            if (ulp_u == ulp_v) {
                return;
            }

            if (size.get(ulp_u) < size.get(ulp_v)) {
                parent.set(ulp_u, ulp_v);
                size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
            } else {
                parent.set(ulp_v, ulp_u);
                size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
            }
        }
    }

    private static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int weight;

        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        public int compareTo(Edge compareEdge) {
            return this.weight - compareEdge.weight;
        }
    }

    public static int spanningTree(int n, List<List<List<Integer>>> adj) {
        ArrayList<Edge> edges = new ArrayList<Edge>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int node = i;
                int adjNode = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);

                edges.add(new Edge(node, adjNode, wt));
            }
        }

        DisjointSet dsu = new DisjointSet(n);

        Collections.sort(edges);

        int m = edges.size();

        int sum = 0;

        for (int i = 0; i < m; i++) {
            int u = edges.get(i).src;
            int v = edges.get(i).dest;
            int wt = edges.get(i).weight;

            if (dsu.findUltimateParent(u) != dsu.findUltimateParent(v)) {
                sum += wt;
                dsu.unionBySize(u, v);
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