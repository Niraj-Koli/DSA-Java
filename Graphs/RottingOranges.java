/*
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten
 * orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 */

import java.util.ArrayDeque;

class RottingOranges {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();

        int totalOranges = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                }

                if (grid[i][j] != 0) {
                    totalOranges++;
                }
            }
        }

        if (totalOranges == 0) {
            return 0;
        }

        int rottenOranges = 0;
        int minutes = 0;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            int size = queue.size();
            rottenOranges += size;

            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int row = point[0];
                int col = point[1];

                for (int j = 0; j < 4; j++) {
                    int nrow = row + dx[j];
                    int ncol = col + dy[j];

                    boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                    if (bounds && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        queue.offer(new int[] { nrow, ncol });
                    }
                }
            }

            if (!queue.isEmpty()) {
                minutes++;
            }
        }
        return totalOranges == rottenOranges ? minutes : -1;
    }

    public static void main(String[] args) {
        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };

        System.out.println(orangesRotting(grid));
    }
}