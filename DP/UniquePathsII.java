/*
 * You are given an m x n integer array grid. There is a robot initially located
 * at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * An obstacle and space are marked as 1 or 0 respectively in grid. A path that
 * the robot takes cannot include any square that is an obstacle.
 * 
 * Return the number of possible unique paths that the robot can take to reach
 * the bottom-right corner.
 * 
 * The testcases are generated so that the answer will be less than or equal to
 * 2 * 10^9.
 */

public class UniquePathsII {
    public static int[][] dp = new int[100000][100000];

    public static int solve(int i, int j, int[][] maze) {
        if (maze[i][j] == 1) {
            return 0;
        }

        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = solve(i - 1, j, maze);
        int left = solve(i, j - 1, maze);

        dp[i][j] = up + left;

        return dp[i][j];
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }

                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = i > 0 ? dp[i - 1][j] : 0;
                int left = j > 0 ? dp[i][j - 1] : 0;

                dp[i][j] = up + left;
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        int answer = uniquePathsWithObstacles(obstacleGrid);

        System.out.println(answer);
    }
}

// class Solution {

// private static final int[][] DIRECTIONS = new int[][] {
// { 0, 1 }, // left
// { 1, 0 } // down
// };

// public int uniquePathsWithObstacles(int[][] obstacleGrid) {
// int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
// for (int i = 0; i < dp.length; i++) {
// for (int j = 0; j < dp[i].length; j++) {
// dp[i][j] = -1;
// }
// }
// return dfs(obstacleGrid, 0, 0, dp);
// }

// private int dfs(int[][] obstacleGrid, int row, int col, int[][] dp) {

// if (row < 0 || row >= obstacleGrid.length || col < 0 || col >=
// obstacleGrid[0].length ||
// obstacleGrid[row][col] == 1) {

// return 0;
// }

// if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
// return 1;
// }

// if (dp[row][col] != -1) {
// return dp[row][col];
// }

// int numberOfWaysForCurrentCell = 0;
// for (int[] direction : DIRECTIONS) {
// numberOfWaysForCurrentCell += dfs(obstacleGrid, row + direction[0], col +
// direction[1], dp);
// }
// dp[row][col] = numberOfWaysForCurrentCell;
// return numberOfWaysForCurrentCell;
// }
// }