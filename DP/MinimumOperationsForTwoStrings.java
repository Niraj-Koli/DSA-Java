/*
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 */

public class MinimumOperationsForTwoStrings {
    public static int longestCommonSubsequence(String x, String y, int n, int m) {
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static int minOperations(String x, String y) {
        int n = x.length();
        int m = y.length();

        int lcs = longestCommonSubsequence(x, y, n, m);

        return (n - lcs) + (m - lcs);
    }

    public static void main(String[] args) {
        String word1 = "sea";
        String word2 = "eat";

        int answer = minOperations(word1, word2);

        System.out.println(answer);
    }
}

// class Solution {
// public int minDistance(String word1, String word2) {
// int m = word1.length();
// int n = word2.length();
// int[] dp = new int[n + 1];

// for (int i = 0; i <= n; i++) {
// dp[i] = i;
// }

// for (int i = 1; i <= m; i++) {
// int pre = dp[0];
// dp[0] = i;
// for (int j = 1; j <= n; j++) {
// int tmp = dp[j];
// if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
// dp[j] = pre;
// } else {
// dp[j] = 1 + Math.min(dp[j - 1], dp[j]);
// }
// pre = tmp;
// }
// }

// return dp[n];
// }
// }