/*
 * You are given an m x n binary matrix grid, where 0 represents a sea cell and
 * 1 represents a land cell.
 * 
 * A move consists of walking from one land cell to another adjacent
 * (4-directionally) land cell or walking off the boundary of the grid.
 * 
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 */

// Time -> O(N x M)
// Space -> O(N x M)

import java.util.ArrayDeque;

public class NumberOfEnclaves {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean boundaries = i == 0 || j == 0 || i == n - 1 || j == m - 1;

                if (boundaries && grid[i][j] == 1) {
                    vis[i][j] = true;
                    queue.offer(new Pair(i, j));
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    queue.offer(new Pair(nrow, ncol));
                }
            }
        }

        int enclaves = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    enclaves++;
                }
            }
        }

        return enclaves;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 }
        };

        int ans = numEnclaves(grid);

        System.out.println(ans);
    }
}

// class Solution {

// private int[][] g;
// private int xlen;
// private int ylen;

// private void paint(int x, int y) {
// if (x < 0 || y < 0 || x >= xlen || y >= ylen) {
// return;
// }
// if (g[y][x] != 1) {
// return;
// }

// g[y][x] = 0;
// paint(x + 1, y);
// paint(x - 1, y);
// paint(x, y + 1);
// paint(x, y - 1);
// }

// public int numEnclaves(int[][] grid) {
// g = grid;
// ylen = g.length;
// xlen = g[0].length;
// for (int x = 0; x < xlen; x++) {
// paint(x, 0);
// paint(x, ylen - 1);
// }
// for (int y = 0; y < ylen; y++) {
// paint(0, y);
// paint(xlen - 1, y);
// }

// int ct = 0;
// for (int x = 0; x < xlen; x++) {
// for (int y = 0; y < ylen; y++) {
// ct += g[y][x];
// }
// }
// return ct;
// }
// }