/*
 * Given an n nrow n binary matrix grid, return the length of the shortest clear
 * path in the matrix. If there is no clear path, return -1.
 * 
 * A clear path in a binary matrix is a path from the top-left cell (i.e., (0,
 * 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:
 * 
 * All the visited cells of the path are 0.
 * All the adjacent cells of the path are 8-directionally connected (i.e., they
 * are different and they share an edge or a corner).
 * The length of a clear path is the number of visited cells of this path.
 */

import java.util.ArrayDeque;

class ShortestPathInBinaryMatrix {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int shortestPathBinaryMatrix(int[][] grid, int[] src, int[] dest) {
        int srcX = src[0];
        int srcY = src[1];
        int destX = dest[0];
        int destY = dest[1];

        if ((srcX == destX) && (srcY == destY)) {
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;

        if (grid[srcX][srcY] != 1 || grid[destX][destY] != 1) {
            return -1;
        }

        boolean[][] vis = new boolean[n][m];

        ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(new int[] { srcX, srcY, 1 });
        vis[srcX][srcY] = true;

        int[] dx = { -1, 0, 1, 0, 1, -1, -1, 1 };
        int[] dy = { 0, 1, 0, -1, -1, -1, 1, 1 };

        while (!queue.isEmpty()) {
            int[] data = queue.poll();

            int row = data[0];
            int col = data[1];
            int distance = data[2];

            if (row == destX && col == destY) {
                return distance;
            }

            for (int i = 0; i < 8; i++) {
                int nrow = row + dx[i];
                int ncol = col + dy[i];

                boolean bounds = (nrow >= 0 && nrow < n) && (ncol >= 0 && ncol < m);

                if (bounds && !vis[nrow][ncol] && grid[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    queue.offer(new int[] { nrow, ncol, distance + 1 });
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 1, 1, 1 },
                { 1, 1, 0, 1 },
                { 1, 1, 1, 1 },
                { 1, 1, 0, 0 },
                { 1, 0, 0, 1 }
        };
        int[] src = { 0, 1 };
        int[] dest = { 2, 2 };

        System.out.println(shortestPathBinaryMatrix(grid, src, dest));
    }
}