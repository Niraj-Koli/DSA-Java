/*
 * You are given a string s. You can convert s to a
 * palindrome
 * by adding characters in front of it.
 * 
 * Return the shortest palindrome you can find by performing this
 * transformation.
 */

public class ShortestPalindrome {

    // Time -> O(n^2) //
    // Space -> O(1) //

    private static String shortestPalindrome(String s) {
        int n = s.length();

        StringBuilder sb = new StringBuilder();

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            sb.append(ch);
        }

        String t = sb.toString();

        int m = t.length();

        for (int i = 0; i <= m; i++) {
            String subString = t.substring(i);

            if (s.startsWith(subString)) {
                return t.substring(0, i) + s;
            }
        }

        return t + s;
    }

    public static void main(String[] args) {
        String s = "abcd";

        System.out.println(shortestPalindrome(s));
    }
}