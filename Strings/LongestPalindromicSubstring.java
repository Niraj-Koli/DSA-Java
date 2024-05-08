/* Given a string str, return the longest palindromic substring in str. */

class LongestPalindromicSubstring {

    // Time -> O(n^2) //
    // Space -> O(1) //

    private static int expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }

    private static String longestPalindrome(String str) {
        int n = str.length();

        if (n <= 1) {
            return str;
        }

        int start = 0;
        int maxLength = 1;

        for (int i = 0; i < n; i++) {
            int oddLen = expandAroundCenter(str, i, i);
            int evenLen = expandAroundCenter(str, i, i + 1);

            int len = Math.max(oddLen, evenLen);

            if (len > maxLength) {
                maxLength = len;
                start = i - (len - 1) / 2;
            }
        }

        return str.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        String s = "babad";

        System.out.println(longestPalindrome(s));
    }
}