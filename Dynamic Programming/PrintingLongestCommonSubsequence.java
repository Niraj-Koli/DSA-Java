/*
 * Given two sequences, print the longest subsequence present in both of them.
 */

class PrintingLongestCommonSubsequence {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static String printLCS(String x, String y) {
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

        StringBuilder res = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                res.append(x.charAt(i - 1));

                i--;
                j--;
            } else {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            }
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String x = "AGGTAB";
        String y = "GXTXAYB";

        System.out.println(printLCS(x, y));
    }
}