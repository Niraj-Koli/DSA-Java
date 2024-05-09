/*
 * Given two strings s and dp, return true if s is a subsequence of dp, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string bt deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 */

class IsSubsequence {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static boolean isSubsequence(String s, String r) {
        int n = s.length();
        int m = r.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        int lcsLength = dp[n][m];

        return lcsLength == n ? true : false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String r = "ahbgdc";

        System.out.println(isSubsequence(s, r));
    }
}