/*
 * You are given an n x n integer matrix grid where each value grid[i][j]
 * represents the elevation at that point (i, j).
 * 
 * The rain starts to fall. At time t, the depth of the water everywhere is t.
 * You can swim from a square to another 4-directionally adjacent square if and
 * only if the elevation of both squares individually are at most t. You can
 * swim infinite distances in zero time. Of course, you must stay within the
 * boundaries of the grid during your swim.
 * 
 * Return the least time until you can reach the bottom right square (n - 1, n -
 * 1) if you start at the top left square (0, 0).
 */

import java.util.PriorityQueue;

class SwimInRisingWater {
    private static class Pair {
        private int row;
        private int col;
        private int distance;

        public Pair(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    // Time -> O((n * m) * log(n * m)) //
    // Space -> O(n * m) //

    private static int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);
        pq.offer(new Pair(0, 0, grid[0][0]));
        vis[0][0] = true;

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            int row = pair.row;
            int col = pair.col;
            int distance = pair.distance;

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && !vis[nrow][ncol]) {
                    int newmax = Math.max(distance, grid[nrow][ncol]);

                    pq.offer(new Pair(nrow, ncol, newmax));
                    vis[nrow][ncol] = true;

                    if (nrow == n - 1 && ncol == m - 1) {
                        return newmax;
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 2, 3, 4 },
                { 24, 23, 22, 21, 5 },
                { 12, 13, 14, 15, 16 },
                { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 },
        };

        System.out.println(swimInWater(grid));
    }
}