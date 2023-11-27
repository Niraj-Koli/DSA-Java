/*
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */

public class MinimumPathSum {
    public static int[][] t = new int[100000][100000];

    static int solve(int i, int j, int[][] matrix) {
        if (i == 0 && j == 0) {
            return matrix[0][0];
        }

        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }

        if (t[i][j] != 0) {
            return t[i][j];
        }

        int up = matrix[i][j] + solve(i - 1, j, matrix);
        int left = matrix[i][j] + solve(i, j - 1, matrix);

        t[i][j] = Math.min(up, left);

        return t[i][j];
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int t[][] = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    t[i][j] = grid[i][j];

                    continue;
                }

                int up = i > 0 ? t[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? t[i][j - 1] : Integer.MAX_VALUE;

                t[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return t[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        int answer = minPathSum(grid);

        System.out.println(answer);
    }
}

// class Solution {
// public int minPathSum(int[][] grid) {
// int m = grid.length;
// int n = grid[0].length;

// int[][] t = new int[m][n];
// t[0][0] = grid[0][0];

// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (i == 0 && j == 0)
// continue;
// if (i - 1 < 0)
// t[i][j] = t[i][j - 1] + grid[i][j];
// else if (j - 1 < 0)
// t[i][j] = t[i - 1][j] + grid[i][j];
// else
// t[i][j] = Math.min(t[i][j - 1], t[i - 1][j]) + grid[i][j];
// }
// }

// return t[m - 1][n - 1];
// }
// }
