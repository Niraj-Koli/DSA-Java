/*
 * You are given an m nrow n binary matrix grid, where 0 represents a sea cell and
 * 1 represents a land cell.
 * 
 * A move consists of walking from one land cell to another adjacent
 * (4-directionally) land cell or walking off the boundary of the grid.
 * 
 * Return the number of land cells in grid for which we cannot walk off the
 * boundary of the grid in any number of moves.
 */

import java.util.ArrayDeque;

class NumberOfEnclaves {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                boolean boundaries = (i == 0 || j == 0 || i == n - 1 || j == m - 1);

                if (boundaries && grid[i][j] == 1) {
                    queue.offer(new int[] { i, j });
                    vis[i][j] = true;
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int row = point[0];
            int col = point[1];

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    queue.offer(new int[] { nrow, ncol });
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

        System.out.println(numEnclaves(grid));
    }
}