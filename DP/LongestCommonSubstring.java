/*
 * Given two strings. The task is to find the length of the longest common
 * substring.
 */

public class LongestCommonSubstring {
    public static int longestCommonSubstr(String x, String y, int n, int m) {
        int max = 0;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
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
        String s1 = "ABCDGH";
        String s2 = "ACDGHR";
        int n = 6;
        int m = 6;

        int answer = longestCommonSubstr(s1, s2, n, m);

        System.out.println(answer);
    }
}