/*
 * Given a n x m grid filled with non-negative numbers, find a path from top
 * left to bottom right, which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 */

class MinimumPathSum {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int solve(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return (int) Math.pow(10, 9);
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);

        dp[i][j] = grid[i][j] + Math.min(up, left);

        return dp[i][j];
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int dp[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = grid[i][j];
                    continue;
                }

                int up = i > 0 ? dp[i - 1][j] : Integer.MAX_VALUE;
                int left = j > 0 ? dp[i][j - 1] : Integer.MAX_VALUE;

                dp[i][j] = grid[i][j] + Math.min(up, left);
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, 3, 1 },
                { 1, 5, 1 },
                { 4, 2, 1 }
        };

        System.out.println(minPathSum(grid));

        int n = grid.length;
        int m = grid[0].length;

        int[][] dp = new int[n][m];

        System.out.println(solve(n - 1, m - 1, grid, dp));
    }
}