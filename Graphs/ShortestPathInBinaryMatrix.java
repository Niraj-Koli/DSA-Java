/*
 * Given a n * m matrix grid where each element can either be 0 or 1. You need
 * to find the shortest distance between a given source cell to a destination
 * cell. The path can only be created out of a cell if its value is 1.
 * 
 * If the path is not possible between source cell and destination cell, then
 * return -1.
 * 
 * Note : You can move into an adjacent cell if that adjacent cell is filled
 * with element 1. Two cells are adjacent if they share a side. In other words,
 * you can move in one of the four directions, Up, Down, Left and Right. The
 * source and destination cell are based on the zero based indexing. The
 * destination cell should be 1.
 */

// Time -> O(N x M)
// Space -> O(N x M)

import java.util.ArrayDeque;

public class ShortestPathInBinaryMatrix {
    private static class Tuple {
        int distance;
        int row;
        int col;

        Tuple(int distance, int row, int col) {
            this.distance = distance;
            this.row = row;
            this.col = col;
        }
    }

    public static int shortestPathBinaryMatrix(int[][] grid, int[] src, int[] dest) {
        if (src[0] == dest[0] && src[1] == dest[1]) {
            return 0;
        }
        
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = (int) (1e9);
            }
        }

        dist[src[0]][src[1]] = 0;

        ArrayDeque<Tuple> queue = new ArrayDeque<Tuple>();
        queue.offer(new Tuple(0, src[0], src[1]));

        int[] dx = { -1, 0, 1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();

            int distance = tuple.distance;
            int row = tuple.row;
            int col = tuple.col;

            for (int i = 0; i < 4; i++) {
                int newrow = row + dx[i];
                int newcol = col + dy[i];

                boolean bounds = (newrow >= 0 && newrow < n) && (newcol >= 0 && newcol < m);

                if (bounds && grid[newrow][newcol] == 1 && distance + 1 < dist[newrow][newcol]) {
                    dist[newrow][newcol] = 1 + distance;

                    if (newrow == dest[0] && newcol == dest[1]) {
                        return distance + 1;
                    }

                    queue.offer(new Tuple(distance + 1, newrow, newcol));
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

        int[] source = { 0, 1 };
        int[] destination = { 2, 2 };

        int ans = shortestPathBinaryMatrix(grid, source, destination);

        System.out.println(ans);
    }
}