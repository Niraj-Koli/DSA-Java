/*
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 */

class PalindromicSubstrings {

    // Time -> O(n^2) //
    // Space -> O(1) //

    private static int count = 0;

    private static int countSubstrings(String s) {
        int n = s.length();

        if (s == null || n == 0) {
            return 0;
        }

        for (int i = 0; i < n; i++) {
            extendPalindrome(s, i, i);
            extendPalindrome(s, i, i + 1);
        }

        return count;
    }

    private static void extendPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "aaa";

        System.out.println(countSubstrings(s));
    }
}