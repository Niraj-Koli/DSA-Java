/*
 * Given an input string (s) and a pattern (p), implement wildcard pattern
 * matching with support for '?' and '*' where:
 * 
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 */

public class WildcardMatching {
    public static boolean[][] dp = new boolean[1000][1000];

    public static boolean solve(String s, String p, int i, int j) {
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
            dp[i][j] = solve(p, s, i - 1, j - 1);

            return dp[i][j];
        } else {
            if (p.charAt(i) == '*') {
                dp[i][j] = (solve(p, s, i - 1, j) == true
                        || solve(p, s, i, j - 1) == true) ? true : false;

                return dp[i][j];
            } else {
                return false;
            }
        }
    }

    public static boolean isAllStars(String p, int i) {
        for (int j = 1; j <= i; j++) {
            if (p.charAt(j - 1) != '*')
                return false;
        }
        return true;
    }

    public static boolean isMatch(String s, String p) {
        int n = p.length();
        int m = s.length();

        boolean dp[][] = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        for (int j = 1; j < m + 1; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i < n + 1; i++) {
            dp[i][0] = isAllStars(p, i);
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
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

        boolean answer = isMatch(s, p);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isMatch(String s, String p) {
// int sid = 0, pid = 0, star = -1, match = 0;

// while (sid < s.length()) {
// if (pid < p.length() && (s.charAt(sid) == p.charAt(pid) || p.charAt(pid) ==
// '?')) {
// sid++;
// pid++;
// } else if (pid < p.length() && p.charAt(pid) == '*') {
// star = pid;
// pid++;
// match = sid; // from sid start match, * match non so sid not+1
// } else if (star != -1) {
// pid = star + 1;
// match++;
// sid = match;
// } else {
// return false;
// }
// }

// while (pid < p.length())
// if (p.charAt(pid) == '*') // not break loop
// pid++;
// else
// break;

// return pid == p.length();
// }
// }