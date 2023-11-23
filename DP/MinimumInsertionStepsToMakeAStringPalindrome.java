/*
 * Given a string s. In one step you can insert any character at any index of
 * the string.
 * 
 * Return the minimum number of steps to make s palindrome.
 * 
 * A Palindrome String is one that reads the same backward as well as forward.
 */

public class MinimumInsertionStepsToMakeAStringPalindrome {
    public static int lcs(String x, String y) {
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

    public static int lps(String s) {
        StringBuilder p = new StringBuilder(s);

        return lcs(s, p.reverse().toString());
    }

    public static int minInsertions(String s) {
        int n = s.length();

        int lpsLength = lps(s);

        return n - lpsLength;
    }

    public static void main(String[] args) {
        String s = "mbadm";

        int answer = minInsertions(s);

        System.out.println(answer);
    }
}

// class Solution {
// public int minInsertions(String s) {
// return s.length() - longestPalindromeSubseq(s);
// }

// public int longestPalindromeSubseq(String s) {
// char[] c = s.toCharArray();

// int[] t = new int[c.length];

// for (int j = 0; j < t.length; j++) {
// t[j] = 1;
// int topRight = 0;
// for (int i = j - 1; i >= 0; i--) {
// int temp = t[i];
// t[i] = c[i] == c[j] ? 2 + topRight : Math.max(t[i], t[i + 1]);
// topRight = temp;
// }
// }
// return t[0];
// }
// }