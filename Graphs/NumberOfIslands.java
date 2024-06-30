/*
 * Given an m nrow n 2D binary grid grid which represents a map of '1's (land) and
 * '0's (water), return the number of islands.
 * 
 * An island is surrounded by water and is formed by connecting adjacent lands
 * horizontally or vertically. You may assume all four edges of the grid are all
 * surrounded by water.
 */

import java.util.ArrayDeque;

class NumberOfIslands {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static void bfs(int r, int c, boolean[][] vis, char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        vis[r][c] = true;

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { r, c });

        while (!queue.isEmpty()) {
            int[] point = queue.poll();

            int row = point[0];
            int col = point[1];

            for (int drow = -1; drow <= 1; drow++) {
                for (int dcol = -1; dcol <= 1; dcol++) {
                    int nrow = row + drow;
                    int ncol = col + dcol;

                    boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                    if (bounds && !vis[nrow][ncol] && grid[nrow][ncol] == '1') {
                        vis[nrow][ncol] = true;
                        queue.offer(new int[] { nrow, ncol });
                    }
                }
            }
        }
    }

    private static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int islands = 0;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if (!vis[row][col] && grid[row][col] == '1') {
                    bfs(row, col, vis, grid);
                    islands++;
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

        System.out.println(numIslands(grid));
    }
}