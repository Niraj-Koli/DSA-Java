/*
 * Given a boolean 2D matrix grid of size n * m. You have to find the number of
 * distinct islands where a group of connected 1s (horizontally or vertically)
 * forms an island. Two islands are considered to be distinct if and only if one
 * island is not equal to another (not rotated or reflected).
 */

import java.util.ArrayList;
import java.util.HashSet;

class NumberOfDistinctIslands {
    private static String toSting(int row, int col) {
        return Integer.toString(row) + " " + Integer.toString(col);
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static void dfs(int row, int col, int row0, int col0, boolean[][] vis, int[][] grid,
            ArrayList<String> island,
            int[] dx, int[] dy) {
        int n = grid.length;
        int m = grid[0].length;

        vis[row][col] = true;
        island.add(toSting(row - row0, col - col0));

        for (int i = 0; i < 4; i++) {
            int nrow = row + dx[i];
            int ncol = col + dy[i];

            boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

            if (bounds && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, row0, col0, vis, grid, island, dx, dy);
            }
        }
    }

    private static int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        HashSet<ArrayList<String>> set = new HashSet<ArrayList<String>>();

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, -1, 0, 1 };

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> island = new ArrayList<String>();
                    dfs(i, j, i, j, vis, grid, island, dx, dy);
                    set.add(island);
                }
            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1 },
                { 1, 1, 0, 1, 1 },
        };

        System.out.println(countDistinctIslands(grid));
    }
}