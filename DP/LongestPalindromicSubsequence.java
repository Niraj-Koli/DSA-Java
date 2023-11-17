/*
 * Given a string s, find the longest palindromic subsequence's length in s.
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * deleting some or no elements without changing the order of the remaining
 * elements.
 */

public class LongestPalindromicSubsequence {
    public static int longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();

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

    public static int longestPalindromeSubseq(String s) {
        StringBuilder p = new StringBuilder(s);

        return longestCommonSubsequence(s, p.reverse().toString());
    }

    public static void main(String[] args) {
        String s = "bbbab";

        int answer = longestPalindromeSubseq(s);

        System.out.println(answer);
    }
}

// class Solution {
// public int longestPalindromeSubseq(String s) {
// char[] str = s.toCharArray();

// int[] prev = new int[str.length + 1];
// int[] curr = new int[str.length + 1];

// for (int i = 1; i <= str.length; i++) {
// for (int j = str.length - 1; j >= 0; j--) {
// if (str[i - 1] == str[j]) {
// curr[j] = 1 + prev[j + 1];
// } else {
// curr[j] = Math.max(prev[j], curr[j + 1]);
// }
// }
// int[] temp = prev;
// prev = curr;
// curr = temp;
// }

// return prev[0];
// }
// }