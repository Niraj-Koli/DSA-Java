/*
 * A string is called a happy prefix if is a non-empty prefix which is also a
 * suffix (excluding itself).
 * 
 * Given a string s, return the longest happy prefix of s. Return an empty
 * string "" if no such prefix exists.
 */

public class LongestHappyPrefix {

    // Time -> O(n) //
    // Space -> O(1) //

    private static String longestPrefix(String s) {
        int n = s.length();

        long mod = (long) 1e9 + 7;

        long prefix = 0;
        long suffix = 0;

        long power = 1;

        int k = 0;

        for (int i = 0; i < n - 1; i++) {
            prefix = (prefix * 128 + s.charAt(i)) % mod;

            suffix = (suffix + power * s.charAt(n - i - 1)) % mod;

            if (prefix == suffix) {
                k = i + 1;
            }

            power = power * 128 % mod;
        }

        return s.substring(0, k);
    }

    public static void main(String[] args) {
        String s = "ababab";

        System.out.println(longestPrefix(s));
    }
}