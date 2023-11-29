/*
 * Given two strings str1 and str2, return the shortest string that has both
 * str1 and str2 as subsequences. If there are multiple valid strings, return
 * any of them.
 * 
 * A string s is a subsequence of string t if deleting some number of characters
 * from t (possibly 0) results in the string s.
 */

public class ShortestCommonSupersequence {
    public static String shortestCommonSupersequence(String x, String y) {
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

        StringBuilder result = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (x.charAt(i - 1) == y.charAt(j - 1)) {
                result.append(x.charAt(i - 1));

                i--;
                j--;
            } else {
                if (t[i][j - 1] > t[i - 1][j]) {
                    result.append(y.charAt(j - 1));

                    j--;
                } else {
                    result.append(x.charAt(i - 1));

                    i--;
                }
            }
        }

        while (i > 0) {
            result.append(x.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            result.append(y.charAt(j - 1));
            j--;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String str1 = "abac";
        String str2 = "cab";

        String answer = shortestCommonSupersequence(str1, str2);

        System.out.println(answer);
    }
}

// class Solution {
// public String shortestCommonSupersequence(String str1, String str2) {
// char[] char1 = str1.toCharArray();
// char[] char2 = str2.toCharArray();

// int n = str1.length();
// int m = str2.length();

// int[][] t = new int[n + 1][m + 1];
// for (int i = n - 1; i >= 0; i--) {
// for (int j = m - 1; j >= 0; j--) {
// if (char1[i] == char2[j])
// t[i][j] = t[i + 1][j + 1] + 1;
// else
// t[i][j] = Math.max(t[i + 1][j], t[i][j + 1]);
// }
// }
// StringBuilder sb = new StringBuilder();
// int i = 0, j = 0;
// while (i < n && j < m) {
// if (char1[i] == char2[j]) {
// sb.append(char1[i]);
// i++;
// j++;
// } else if (t[i][j] == t[i + 1][j]) {
// sb.append(char1[i]);
// i++;
// } else {
// sb.append(char2[j]);
// j++;
// }
// }
// while (i < n) {
// sb.append(char1[i]);
// i++;
// }
// while (j < m) {
// sb.append(char2[j]);
// j++;
// }
// return sb.toString();
// }
// }