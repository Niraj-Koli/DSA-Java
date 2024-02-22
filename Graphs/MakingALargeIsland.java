/*
 * You are given an n x n binary matrix grid. You are allowed to change at most
 * one 0 to be 1.
 * 
 * Return the size of the largest island in grid after applying this operation.
 * 
 * An island is a 4-directionally connected group of 1s.
 */

// Time -> O(N^2)
// Space -> O(N^2)

import java.util.ArrayList;
import java.util.HashSet;

public class MakingALargeIsland {
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

    public static int largestIsland(int[][] grid) {
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
                    int newrow = row + dx[i];
                    int newcol = col + dy[i];

                    boolean bounds = (newrow >= 0 && newrow < n) && (newcol >= 0 && newcol < m);

                    if (bounds && grid[newrow][newcol] == 1) {
                        int nodeNo = row * m + col;
                        int adjNode = newrow * m + newcol;

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
                    int newrow = row + dx[i];
                    int newcol = col + dy[i];

                    boolean bounds = (newrow >= 0 && newrow < n) && (newcol >= 0 && newcol < m);

                    if (bounds && grid[newrow][newcol] == 1) {
                        components.add(dsu.findUltimateParent(newrow * m + newcol));
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

        int ans = largestIsland(grid);

        System.out.println(ans);
    }
}

// class Solution {
// public int largestIsland(int[][] grid) {
// int n = grid.length;
// int[] count = new int[n * n + 2];
// int max = Integer.MIN_VALUE;
// int id = 2;

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// if (grid[i][j] == 1) {
// dfs(grid, count, id, i, j);
// max = Math.max(max, count[id]);
// id++;
// }
// }
// }

// for (int i = 0; i < n; i++) {
// for (int j = 0; j < n; j++) {
// if (grid[i][j] == 0) {
// max = Math.max(max, sumCount(grid, count, i, j) + 1);
// }
// }
// }
// return max;
// }

// private int sumCount(int[][] grid, int[] count, int i, int j) {
// int[] ids = new int[4];
// if (i - 1 >= 0) {
// ids[0] = grid[i - 1][j];
// }
// if (i + 1 < grid.length) {
// ids[1] = grid[i + 1][j];
// }
// if (j - 1 >= 0) {
// ids[2] = grid[i][j - 1];
// }
// if (j + 1 < grid.length) {
// ids[3] = grid[i][j + 1];
// }

// int sum = count[ids[0]];
// if (ids[0] != ids[1]) {
// sum += count[ids[1]];
// }
// if (ids[2] != ids[0] && ids[2] != ids[1]) {
// sum += count[ids[2]];
// }
// if (ids[3] != ids[0] && ids[3] != ids[1] && ids[3] != ids[2]) {
// sum += count[ids[3]];
// }
// return sum;
// }

// private void dfs(int[][] grid, int[] count, int id, int i, int j) {
// if (i >= grid.length || i < 0 || j >= grid.length || j < 0) {
// return;
// }
// if (grid[i][j] != 1) {
// return;
// }
// grid[i][j] = id;
// count[id]++;
// dfs(grid, count, id, i + 1, j);
// dfs(grid, count, id, i - 1, j);
// dfs(grid, count, id, i, j + 1);
// dfs(grid, count, id, i, j - 1);
// }
// }