/*
 * Given two strings x and y, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 */

class LongestCommonSubsequence {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int lcs(String x, String y, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != 0) {
            return dp[n][m];
        }

        if (x.charAt(n - 1) == y.charAt(m - 1)) {
            dp[n][m] = 1 + lcs(x, y, n - 1, m - 1, dp);
        } else {
            dp[n][m] = Math.max(lcs(x, y, n, m - 1, dp), lcs(x, y, n - 1, m, dp));
        }

        return dp[n][m];
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String x = "abcde";
        String y = "ace";

        System.out.println(longestCommonSubsequence(x, y));

        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        System.out.println(lcs(x, y, n, m, dp));
    }
}