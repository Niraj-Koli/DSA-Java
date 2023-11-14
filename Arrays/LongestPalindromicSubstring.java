/*
 * Given a string s, return the longest palindromic substring in s.
 */

public class LongestPalindromicSubstring {
    public static String expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return s.substring(left + 1, right);
    }

    public static String longestPalindrome(String s) {
        int n = s.length();

        if (n <= 1) {
            return s;
        }

        String longStr = s.substring(0, 1);

        for (int i = 0; i < n - 1; i++) {
            String odd = expandFromCenter(s, i, i);
            String even = expandFromCenter(s, i, i + 1);

            if (odd.length() > longStr.length()) {
                longStr = odd;
            }
            if (even.length() > longStr.length()) {
                longStr = even;
            }
        }

        return longStr;
    }

    public static void main(String[] args) {
        String s = "aacabdkacaa";

        String answer = longestPalindrome(s);

        System.out.println(answer);
    }
}

// class Solution {
// int start = 0, end = 0;

// public String longestPalindrome(String s) {
// if (s.length() < 2)
// return s;
// char[] c = s.toCharArray();
// longestPallindromeAt(c, 0);
// return s.substring(start, end + 1);
// }

// private void longestPallindromeAt(char[] c, int p) {
// int a = p;
// int b = p;
// int n = c.length;
// if ((p == n - 1 || (n - p) < (end - start + 1) / 2))
// return;
// while (b < n - 1 && c[b] == c[b + 1])
// b++;
// p = b;
// while (a > 0 && b < n - 1 && c[a - 1] == c[b + 1]) {
// a--;
// b++;
// }
// if ((b - a) > (end - start)) {
// end = b;
// start = a;
// }
// longestPallindromeAt(c, p + 1);
// }
// }