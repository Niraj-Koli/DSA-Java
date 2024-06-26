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

class NumberOfOperationsToMakeNetworkConnected {
    private static class DisjointSet {
        private ArrayList<Integer> parent = new ArrayList<Integer>();
        private ArrayList<Integer> size = new ArrayList<Integer>();

        public DisjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        private int findUltimateParent(int node) {
            if (node == parent.get(node)) {
                return node;
            }

            int ultimateParent = findUltimateParent(parent.get(node));

            parent.set(node, ultimateParent);

            return parent.get(node);
        }

        private void unionBySize(int u, int v) {
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

    // Time -> O(n + m) //
    // Space -> O(n) //

    private static int makeConnected(int n, int[][] connections) {
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

        return extraEdges >= res ? res : -1;
    }

    public static void main(String[] args) {
        int n = 8;

        int[][] connections = {
                { 0, 1 }, { 0, 3 }, { 0, 2 },
                { 1, 2 }, { 2, 3 }, { 4, 5 },
                { 5, 6 }, { 7, 8 }
        };

        System.out.println(makeConnected(n, connections));
    }
}