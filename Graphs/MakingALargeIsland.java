/*
 * You are given an n x n binary matrix grid. You are allowed to change at most
 * one 0 to be 1.
 * 
 * Return the size of the largest island in grid after applying this operation.
 * 
 * An island is a 4-directionally connected group of 1s.
 */

import java.util.ArrayList;
import java.util.HashSet;

class MakingALargeIsland {
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

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int largestIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        DisjointSet dsu = new DisjointSet(n * m);

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 0) {
                    continue;
                }

                int[] dx = { -1, 0, 1, 0 };
                int[] dy = { 0, -1, 0, 1 };

                for (int i = 0; i < 4; i++) {
                    int nrow = row + dx[i];
                    int ncol = col + dy[i];

                    boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                    if (bounds && grid[nrow][ncol] == 1) {
                        int nodeNo = row * m + col;
                        int adjNode = nrow * m + ncol;

                        dsu.unionBySize(nodeNo, adjNode);
                    }
                }
            }
        }

        int max = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (grid[row][col] == 1) {
                    continue;
                }

                int[] dx = { -1, 0, 1, 0 };
                int[] dy = { 0, -1, 0, 1 };

                HashSet<Integer> components = new HashSet<Integer>();

                for (int i = 0; i < 4; i++) {
                    int nrow = row + dx[i];
                    int ncol = col + dy[i];

                    boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                    if (bounds && grid[nrow][ncol] == 1) {
                        components.add(dsu.findUltimateParent(nrow * m + ncol));
                    }
                }

                int islandSize = 0;

                for (int parents : components) {
                    islandSize += dsu.size.get(parents);
                }

                max = Math.max(max, islandSize + 1);
            }
        }

        for (int cell = 0; cell < n * m; cell++) {
            max = Math.max(max, dsu.size.get(dsu.findUltimateParent(cell)));
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 1, 1, 1 }
        };

        System.out.println(largestIsland(grid));
    }
}