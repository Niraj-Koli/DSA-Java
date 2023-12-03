/*
 * Given two strings s and dp, return the number of distinct subsequences of s
 * which equals dp.
 * 
 * The test cases are generated so that the answer fits on a 32-bit signed
 * integer.
 */

public class DistinctSubsequence {
    public static int[][] dp = new int[1000][1000];

    static int solve(String s1, String s2, int i, int j) {
        if (j < 0) {
            return 1;
        }

        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            int leaveOne = solve(s1, s2, i - 1, j - 1);
            int stay = solve(s1, s2, i - 1, j);

            return dp[i][j] = (leaveOne + stay);
        } else {
            return dp[i][j] = solve(s1, s2, i - 1, j);
        }
    }

    public static int numDistinct(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
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
        String dp = "bag";

        int answer = numDistinct(s, dp);

        System.out.println(answer);
    }
}

// class Solution {
// public int numDistinct(String s, String dp) {
// int m = s.length();
// int n = dp.length();

// int[] dp = new int[n];

// int prev = 1;

// for (int i = m - 1; i >= 0; i--) {
// prev = 1;
// for (int j = n - 1; j >= 0; j--) {
// int old_dpj = dp[j];

// if (s.charAt(i) == dp.charAt(j))
// dp[j] += prev;

// prev = old_dpj;
// }
// }

// return dp[0];
// }
// }