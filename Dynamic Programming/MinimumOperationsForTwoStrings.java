/*
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 */

class MinimumOperationsForTwoStrings {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int longestCommonSubsequence(String x, String y, int n, int m) {
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

    private static int minOperations(String x, String y) {
        int n = x.length();
        int m = y.length();

        int lcs = longestCommonSubsequence(x, y, n, m);

        return (n - lcs) + (m - lcs);
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minOperations(word1, word2));
    }
}