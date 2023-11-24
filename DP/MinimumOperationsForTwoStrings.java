/*
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 */

public class MinimumOperationsForTwoStrings {
    public static int longestCommonSubsequence(String x, String y, int n, int m) {
        int[][] t = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        return t[n][m];
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
// int[] t = new int[n + 1];

// for (int i = 0; i <= n; i++) {
// t[i] = i;
// }

// for (int i = 1; i <= m; i++) {
// int pre = t[0];
// t[0] = i;
// for (int j = 1; j <= n; j++) {
// int tmp = t[j];
// if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
// t[j] = pre;
// } else {
// t[j] = 1 + Math.min(t[j - 1], t[j]);
// }
// pre = tmp;
// }
// }

// return t[n];
// }
// }