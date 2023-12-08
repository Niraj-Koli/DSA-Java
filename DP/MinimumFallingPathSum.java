/*
 * Given an n x n array of integers matrix, return the minimum sum of any
 * falling path through matrix.
 * 
 * A falling path starts at any element in the first row and chooses the element
 * in the next row that is either directly below or diagonally left/right.
 * Specifically, the next element from position (row, col) will be (row + 1, col
 * - 1), (row + 1, col), or (row + 1, col + 1).
 */

import java.util.Arrays;

public class MinimumFallingPathSum {
    public static int[][] dp = new int[100000][100000];

    public static int solve(int i, int j, int m, int[][] matrix) {
        if (j < 0 || j >= m) {
            return (int) Math.pow(-10, 9);
        }

        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = matrix[i][j] + solve(i - 1, j, m, matrix);
        int leftDiagonal = matrix[i][j] + solve(i - 1, j - 1, m, matrix);
        int rightDiagonal = matrix[i][j] + solve(i - 1, j + 1, m, matrix);

        return dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
    }

    public static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);

        int max = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            int ans = solve(n - 1, j, m, matrix);
            max = Math.min(max, ans);
        }

        return max;
    }

    public static int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = dp[i - 1][j];

                int leftDiagonal = j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int rightDiagonal = j + 1 < m ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }

        int min = Integer.MAX_VALUE;

        for (int k = 0; k < m; k++) {
            min = Math.min(min, dp[n - 1][k]);
        }

        return min;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };

        int answer = minFallingPathSum(matrix);

        System.out.println(answer);
    }
}

// class Solution {

// public void minSum(int[][] mat, int n, int r) {
// if (r < 0)
// return;
// for (int i = 0; i < n; i++) {
// int nextMin = mat[r + 1][i] + mat[r][i];
// if (i > 0)
// nextMin = Math.min(nextMin, mat[r + 1][i - 1] + mat[r][i]);
// if (i < n - 1)
// nextMin = Math.min(nextMin, mat[r + 1][i + 1] + mat[r][i]);
// mat[r][i] = nextMin;
// }
// minSum(mat, n, r - 1);
// }

// public int minFallingPathSum(int[][] matrix) {
// int n = matrix.length;
// minSum(matrix, n, n - 2);
// int ans = Integer.MAX_VALUE;
// for (int i = 0; i < n; i++) {
// if (ans > matrix[0][i])
// ans = matrix[0][i];
// }
// return ans;
// }
// }