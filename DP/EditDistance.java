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

public class EditDistance {
    public static int[][] dp = new int[1000][1000];

    static int solve(String x, String y, int i, int j) {
        if (i < 0) {
            return j + 1;
        }

        if (j < 0) {
            return i + 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (x.charAt(i) == y.charAt(j)) {
            dp[i][j] = solve(x, y, i - 1, j - 1);

            return dp[i][j];
        } else {
            dp[i][j] = 1 + Math.min(solve(x, y, i - 1, j - 1),
                    Math.min(solve(x, y, i - 1, j), solve(x, y, i, j - 1)));

            return dp[i][j];
        }
    }

    public static int minDistance(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j < m + 1; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
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

        int answer = minDistance(word1, word2);

        System.out.println(answer);
    }
}

// class Solution {
// public int minDistance(String word1, String word2) {
// if (word1.equals(word2)) {
// return 0;
// }

// int m = word1.length() + 1;
// int n = word2.length() + 1;

// if (n > m) {
// return minDistance(word2, word1);
// }

// int[] dp = new int[m];

// for (int i = 0; i < m; i++) {
// dp[i] = i;
// }

// for (int i = 1; i < m; i++) {
// int temp = dp[0];
// dp[0] = i;
// for (int j = 1; j < n; j++) {
// int prev = dp[j];
// if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
// dp[j] = temp;
// } else {
// dp[j] = Math.min(dp[j], Math.min(dp[j - 1], temp)) + 1;
// }
// temp = prev;
// }
// }

// return dp[n - 1];
// }
// }