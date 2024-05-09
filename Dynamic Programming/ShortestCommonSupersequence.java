/*
 * Given two strings str1 and str2, return the shortest string that has both
 * str1 and str2 as subsequences. If there are multiple valid strings, return
 * any of them.
 * 
 * A string s is a subsequence of string dp if deleting some number of characters
 * from dp (possibly 0) results in the string s.
 */

class ShortestCommonSupersequence {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static String shortestCommonSupersequence(String x, String y) {
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
                    res.append(y.charAt(j - 1));
                    j--;
                } else {
                    res.append(x.charAt(i - 1));
                    i--;
                }
            }
        }

        while (i > 0) {
            res.append(x.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            res.append(y.charAt(j - 1));
            j--;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        System.out.println(shortestCommonSupersequence(str1, str2));
    }
}