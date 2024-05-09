/*
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */

class WildcardMatching {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static boolean solve(String s, String p, int i, int j, boolean[][] dp) {
        if (i < 0 && j < 0) {
            return true;
        }

        if (i < 0 && j >= 0) {
            return false;
        }

        if (j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != false) {
            return dp[i][j];
        }

        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
            dp[i][j] = solve(p, s, i - 1, j - 1, dp);
        } else {
            if (p.charAt(i) == '*') {
                dp[i][j] = (solve(p, s, i - 1, j, dp) || solve(p, s, i, j - 1, dp)) ? true : false;
            } else {
                return false;
            }
        }

        return dp[i][j];
    }

    private static boolean isAllStars(String p, int i) {
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*')
                return false;
        }

        return true;
    }

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0] = isAllStars(p, i);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    if (p.charAt(i - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        String s = "cb";
        String p = "?a";

        System.out.println(isMatch(s, p));

        int n = p.length();
        int m = s.length();

        boolean dp[][] = new boolean[n + 1][m + 1];

        System.out.println(solve(s, p, n - 1, m - 1, dp));
    }
}