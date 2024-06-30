/*
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for
 * each cell.
 * 
 * The distance between two adjacent cells is 1.
 */

import java.util.ArrayDeque;

class ZeroOneMatrix {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[][] dist = new int[n][m];

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    vis[i][j] = true;
                    queue.offer(new int[] { i, j, 0 });
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int[] data = queue.poll();

            int row = data[0];
            int col = data[1];
            int steps = data[2];

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    queue.offer(new int[] { nrow, ncol, steps + 1 });
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] mat = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 1, 1, 1 },
        };

        int[][] ans = updateMatrix(mat);

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}