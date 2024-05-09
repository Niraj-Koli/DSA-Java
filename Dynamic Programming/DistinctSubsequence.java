/*
 * Given two strings s and t, return the number of distinct subsequences of s
 * which equals t.
 * 
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 */

class DistinctSubsequence {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int solve(String x, String y, int i, int j, int[][] dp) {
        if (j < 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (x.charAt(i) == y.charAt(j)) {
            int leaveOne = solve(x, y, i - 1, j - 1, dp);
            int stay = solve(x, y, i - 1, j, dp);

            dp[i][j] = (leaveOne + stay);
        } else {
            dp[i][j] = solve(x, y, i - 1, j, dp);
        }

        return dp[i][j];
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int numDistinct(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= m; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "babgbag";
        String t = "bag";

        System.out.println(numDistinct(s, t));

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n + 1][m + 1];

        System.out.println(solve(s, t, n - 1, m - 1, dp));
    }
}