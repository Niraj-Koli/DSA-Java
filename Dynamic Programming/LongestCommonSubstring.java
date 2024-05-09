/*
 * Given two strings. The task is to find the length of the longest common
 * substring.
 */

class LongestCommonSubstring {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int longestCommonSubstring(String x, String y) {
        int n = x.length();
        int m = y.length();

        int max = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String x = "ABCDGH";
        String y = "ACDGHR";

        System.out.println(longestCommonSubstring(x, y));
    }
}