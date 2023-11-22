/*
 * Given two strings s and t, return true if s is a subsequence of t, or false
 * otherwise.
 * 
 * A subsequence of a string is a new string that is formed from the original
 * string bt deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (i.e., "ace" is a
 * subsequence of "abcde" while "aec" is not).
 */

public class IsSubsequence {
    public static boolean isSubsequence(String s, String r) {
        int n = s.length();
        int m = r.length();

        int[][] t = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == r.charAt(j - 1)) {
                    t[i][j] = 1 + t[i - 1][j - 1];
                } else {
                    t[i][j] = Math.max(t[i][j - 1], t[i - 1][j]);
                }
            }
        }

        int lcsLength = t[n][m];

        if (lcsLength == n) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        String r = "ahbgdc";

        boolean answer = isSubsequence(s, r);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isSubsequence(String s, String t) {

// int slen = s.length();
// int tlen = t.length();

// if (slen == 0)
// return true;

// int count = 0;
// char c = s.charAt(slen - 1 - count);

// for (int i = tlen - 1; i >= 0; i--) {
// if (c == t.charAt(i)) {
// count++;
// if (count == slen)
// return true;
// c = s.charAt(slen - 1 - count);
// }
// }
// return false;
// }
// }