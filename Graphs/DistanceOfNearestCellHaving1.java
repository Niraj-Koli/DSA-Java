/*
 * Given a binary grid of n*m. Find the distance of the nearest 1 in the grid
 * for each cell.
 * The distance is calculated as |i1 - i2| + |j1 - j2|, where i1, j1 are the row
 * number and column number of the current cell, and i2, j2 are the row number
 * and column number of the nearest cell having value 1. There should be atleast
 * one 1 in the grid.
 */

// Time -> O(N x M)
// Space -> O(N x M)

import java.util.ArrayDeque;

class DistanceOfNearestCellHaving1 {
    private static class Node {
        private int row;
        private int col;
        private int steps;

        public Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    private static int[][] nearestMatrx(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        int[][] dist = new int[n][m];

        ArrayDeque<Node> queue = new ArrayDeque<Node>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int row = node.row;
            int col = node.col;
            int steps = node.steps;

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    queue.offer(new Node(nrow, ncol, steps + 1));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 1, 1 } };

        int[][] ans = nearestMatrx(grid);

        for (int[] row : ans) {
            for (int col : row) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }
}