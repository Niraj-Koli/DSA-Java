/*
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 */

class LongestPalindromicSubsequence {

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

    private static int longestPalindromeSubsequence(String s) {
        StringBuilder t = new StringBuilder(s);

        return longestCommonSubsequence(s, t.reverse().toString());
    }

    public static void main(String[] args) {
        String s = "cbbd";

        System.out.println(longestPalindromeSubsequence(s));
    }
}