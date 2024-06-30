/*
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 */

import java.util.PriorityQueue;

class PathWithMinimumEffort {
    private static class Tuple {
        private int row;
        private int col;
        private int distance;

        public Tuple(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }
    }

    // Time -> O((n * m) * log(n * m)) //
    // Space -> O(n * m) //

    private static int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[0][0] = 0;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>((x, y) -> Integer.compare(x.distance, y.distance));
        pq.offer(new Tuple(0, 0, 0));

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!pq.isEmpty()) {
            Tuple tuple = pq.poll();

            int row = tuple.row;
            int col = tuple.col;
            int diff = tuple.distance;

            if (row == n - 1 && col == m - 1) {
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds) {
                    int curEffort = Math.abs(heights[row][col] - heights[nrow][ncol]);
                    int newEffort = Math.max(diff, curEffort);

                    if (newEffort < dist[nrow][ncol]) {
                        dist[nrow][ncol] = newEffort;
                        pq.offer(new Tuple(nrow, ncol, newEffort));
                    }
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[][] heights = {
                { 1, 2, 2 },
                { 3, 8, 2 },
                { 5, 3, 5 }
        };

        System.out.println(minimumEffortPath(heights));
    }
}