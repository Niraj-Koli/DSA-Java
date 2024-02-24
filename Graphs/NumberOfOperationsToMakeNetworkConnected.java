/*
 * There are n computers numbered from 0 to n - 1 connected by ethernet cables
 * connections forming a network where connections[i] = [ai, bi] represents a
 * connection between computers ai and bi. Any computer can reach any other
 * computer directly or indirectly through the network.
 * 
 * You are given an initial computer network connections. You can extract
 * certain cables between two directly connected computers, and place them
 * between any pair of disconnected computers to make them directly connected.
 * 
 * Return the minimum number of times you need to do this in order to make all
 * the computers connected. If it is not possible, return -1.
 */

import java.util.ArrayList;

public class NumberOfOperationsToMakeNetworkConnected {
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

    public static int makeConnected(int n, int[][] connections) {
        int m = connections.length;

        DisjointSet dsu = new DisjointSet(n);

        int extraEdges = 0;

        for (int i = 0; i < m; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (dsu.findUltimateParent(u) == dsu.findUltimateParent(v)) {
                extraEdges++;
            } else {
                dsu.unionBySize(u, v);
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.parent.get(i) == i) {
                components++;
            }
        }

        int res = components - 1;

        if (extraEdges >= res) {
            return res;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int n = 8;

        int[][] connections = {
                { 0, 1 }, { 0, 3 }, { 0, 2 },
                { 1, 2 }, { 2, 3 }, { 4, 5 },
                { 5, 6 }, { 7, 8 }
        };

        int ans = makeConnected(n, connections);

        System.out.println(ans);
    }
}

// class Solution {
// int[] parent;
// int[] rank;

// int find(int x) {
// while (parent[x] != x) {
// x = parent[parent[x]];
// }
// return x;
// }

// int makeUnion(int x, int y) {
// int parX = find(x);
// int parY = find(y);
// if (parX == parY) {
// return 0;
// } else if (rank[parX] < rank[parY]) {
// parent[parX] = parY;
// } else if (rank[parX] > rank[parY]) {
// parent[parY] = parX;
// } else {
// parent[parY] = parX;
// rank[parX]++;
// }
// return 1;
// }

// public int makeConnected(int n, int[][] connections) {
// int edges = connections.length;
// if (edges < n - 1) {
// return -1;
// }
// parent = new int[n];
// rank = new int[n];
// for (int i = 0; i < n; i++) {
// parent[i] = i;
// }
// int components = n;
// for (int[] con : connections) {
// components -= makeUnion(con[0], con[1]);
// }
// return components - 1;
// }
// }