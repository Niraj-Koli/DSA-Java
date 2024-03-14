/*
 * You have been given an N*M matrix filled with integer numbers, find the
 * maximum sum that can be obtained from a path starting from any cell in the
 * first row to any cell in the last row.
 * 
 * From a cell in a row, you can move to another cell directly below that row,
 * or diagonally below left or right. So from a particular cell (row, col), we
 * can move in three directions i.e.
 */

public class MaximumFallingPathSum {

    // Time -> O((n * m^2) //
    // Space -> O(n * m) //

    private static int solve(int i, int j, int[][] matrix, int[][] dp) {
        if (j < 0 || j >= matrix[0].length) {
            return (int) Math.pow(-10, 9);
        }

        if (i == 0) {
            return matrix[0][j];
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = solve(i - 1, j, matrix, dp);

        int leftDiagonal = solve(i - 1, j - 1, matrix, dp);
        int rightDiagonal = solve(i - 1, j + 1, matrix, dp);

        dp[i][j] = matrix[i][j] + Math.max(up, Math.max(leftDiagonal, rightDiagonal));

        return dp[i][j];
    }

    private static int getMaxPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int dp[][] = new int[n][m];

        int max = Integer.MIN_VALUE;

        for (int j = 0; j < m; j++) {
            int ans = solve(n - 1, j, matrix, dp);
            max = Math.max(max, ans);
        }

        return max;
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int maxFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for (int j = 0; j < m; j++) {
            dp[0][j] = matrix[0][j];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int up = dp[i - 1][j];

                int leftDiagonal = j - 1 >= 0 ? dp[i - 1][j - 1] : Integer.MIN_VALUE;
                int rightDiagonal = j + 1 < m ? dp[i - 1][j + 1] : Integer.MIN_VALUE;

                dp[i][j] = matrix[i][j] + Math.max(up, Math.max(leftDiagonal, rightDiagonal));
            }
        }

        int max = Integer.MIN_VALUE;

        for (int k = 0; k < m; k++) {
            max = Math.max(max, dp[n - 1][k]);
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 2, 3 },
                { 3, 7, 2 },
                { 8, 1, 5 }
        };

        System.out.println(maxFallingPathSum(matrix));
        System.out.println(getMaxPathSum(matrix));
    }
}