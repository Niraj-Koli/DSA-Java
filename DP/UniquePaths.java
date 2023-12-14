/*
 * There is a robot on an m x n grid. The robot is initially located at the
 * top-left corner (i.e., grid[0][0]). The robot tries to move to the
 * bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move
 * either down or right at any point in time.
 * 
 * Given the two integers m and n, return the number of possible unique paths
 * that the robot can take to reach the bottom-right corner.
 * 
 * The test cases are generated so that the answer will be less than or equal to
 * 2 * 10^9.
 */

public class UniquePaths {
    public static int[][] dp = new int[100000][100000];

    public static int solve(int i, int j) {
        if (i == 0 && j == 0) {
            return 1;
        }

        if (i < 0 || j < 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int up = solve(i - 1, j);
        int left = solve(i, j - 1);

        dp[i][j] = up + left;

        return dp[i][j];
    }

    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
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
        int m = 3;
        int n = 7;

        int answer = uniquePaths(m, n);

        System.out.println(answer);
    }
}

// class Solution {
// public int uniquePaths(int m, int n) {
// int[][] p = new int[m][n];
// for (int i = 0; i < m; i++) {
// for (int j = 0; j < n; j++) {
// if (i == 0 || j == 0) {
// p[i][j] = 1;
// } else {
// p[i][j] = p[i][j - 1] + p[i - 1][j];
// }
// }
// }
// return p[m - 1][n - 1];
// }
// }