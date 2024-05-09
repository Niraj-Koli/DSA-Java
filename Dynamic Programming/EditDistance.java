/*
 * Given two strings word1 and word2, return the minimum number of operations
 * required to convert word1 to word2.
 * 
 * You have the following three operations permitted on a word:
 * 
 * Insert a character
 * Delete a character
 * Replace a character
 */

class EditDistance {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int solve(String x, String y, int i, int j, int[][] dp) {
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (x.charAt(i) == y.charAt(j)) {
            dp[i][j] = solve(x, y, i - 1, j - 1, dp);
        } else {
            dp[i][j] = 1 + Math.min(solve(x, y, i - 1, j - 1, dp),
                    Math.min(solve(x, y, i - 1, j, dp), solve(x, y, i, j - 1, dp)));
        }

        return dp[i][j];
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int minDistance(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        System.out.println(solve(word1, word2, n - 1, m - 1, dp));
    }
}