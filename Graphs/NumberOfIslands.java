/*
 * Given an m x n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 */

// Time -> O(N^2)
// Space -> O(N^2)

import java.util.ArrayDeque;

class Pair {
    int first;
    int second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class NumberOfIslands {
    public static void bfs(int r, int c, boolean[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        vis[r][c] = true;

        ArrayDeque<Pair> queue = new ArrayDeque<Pair>();
        queue.offer(new Pair(r, c));

        while (!queue.isEmpty()) {
            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.poll();

            for (int drow = -1; drow <= 1; drow++) {
                for (int dcol = -1; dcol <= 1; dcol++) {
                    int nrow = row + drow;
                    int ncol = col + dcol;

                    boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                    if (bounds && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = true;
                        queue.offer(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }

    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int islands = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    islands++;
                    bfs(row, col, vis, grid);
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
        };

        int ans = numIslands(grid);

        System.out.println(ans);
    }
}

// class Solution {
// int r;
// int c;
// char[][] a;
// int count;

// public int numIslands(char[][] grid) {
// r = grid.length;
// c = grid[0].length;
// a = grid;
// count = 0;
// for (int i = 0; i < r; i++) {
// check(grid[i], i);
// }
// return count;
// }

// void check(char[] a, int i) {
// for (int j = 0; j < c; j++) {
// if (a[j] == '1') {
// visit(i, j);
// count++;
// }
// }
// }

// public void visit(int i, int j) {
// a[i][j] = 2;
// if (i - 1 >= 0 && a[i - 1][j] == '1') {
// visit(i - 1, j);
// }
// if (i + 1 < r && a[i + 1][j] == '1') {
// visit(i + 1, j);
// }
// if (j - 1 >= 0 && a[i][j - 1] == '1') {
// visit(i, j - 1);
// }
// if (j + 1 < c && a[i][j + 1] == '1') {
// visit(i, j + 1);
// }
// }
// }