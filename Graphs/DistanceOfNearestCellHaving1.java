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

class Node {
    int first;
    int second;
    int third;

    Node(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class DistanceOfNearestCellHaving1 {
    public static int[][] nearestMatrx(int[][] grid) {
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
            int row = queue.peek().first;
            int col = queue.peek().second;
            int steps = queue.peek().third;
            queue.poll();

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

        for (int[] answer : ans) {
            for (int a : answer) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}

// class Solution {
// public int[][] updateMatrix(int[][] matrix) {
// final int rowLast = matrix.length - 1;
// final int colLast = matrix[0].length - 1;

// int[] row = matrix[0];
// int[] prevRow;
// if (row[0] == 1) // Top left corner
// row[0] = rowLast + colLast + 2;
// for (int c = 1; c <= colLast; c++) // Top row (except top left corner)
// if (row[c] == 1)
// row[c] = row[c - 1] + 1;
// for (int r = 1; r <= rowLast; r++) { // All of the other rows (not first row)
// prevRow = row;
// row = matrix[r];
// if (row[0] == 1) // First column in the current row
// row[0] = prevRow[0] + 1;
// for (int c = 1; c <= colLast; c++) // Other columns in the current row
// if (row[c] == 1)
// row[c] = Math.min(row[c - 1], prevRow[c]) + 1;
// }

// row = matrix[rowLast];
// for (int c = colLast - 1; c >= 0; c--) // Bottom row (except bottom right
// corner)
// if (row[c] > 1)
// row[c] = Math.min(row[c], row[c + 1] + 1);
// for (int r = rowLast - 1; r >= 0; r--) { // All of the other rows (not bottom
// row)
// prevRow = row;
// row = matrix[r];
// if (row[colLast] > 1) // Rightmost column in current row
// row[colLast] = Math.min(row[colLast], prevRow[colLast] + 1);
// for (int c = colLast - 1; c >= 0; c--) // Other columns in current row
// if (row[c] > 1)
// row[c] = Math.min(row[c], Math.min(row[c + 1], prevRow[c]) + 1);
// }

// return matrix;
// }
// }