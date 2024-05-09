/*
 * You are given an n n m integer array grid. There is a robot initially located
 * at the top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[n - 1][m - 1]). The robot can only move
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

class UniquePathsII {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int solve(int i, int j, int[][] maze, int[][] dp) {
        if (i >= 0 && j >= 0 && maze[i][j] == 1) {
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

        int up = solve(i - 1, j, maze, dp);
        int left = solve(i, j - 1, maze, dp);

        dp[i][j] = up + left;

        return dp[i][j];
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int uniquePathsWithObstacles(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maze[i][j] == 1) {
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

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 0, 0, 0 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };

        System.out.println(uniquePathsWithObstacles(maze));

        int n = maze.length;
        int m = maze[0].length;

        int[][] dp = new int[n][m];

        System.out.println(solve(n - 1, m - 1, maze, dp));
    }
}