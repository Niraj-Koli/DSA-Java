/*
 * We can scramble a string s to get a string dp using the following algorithm:
 * 
 * If the length of the string is 1, stop.
 * If the length of the string is > 1, do the following:
 * Split the string into two non-empty substrings at a random index, k.e., if
 * the string is s, divide it to x and y where s = x + y.
 * Randomly decide to swap the two substrings or to keep them in the same order.
 * k.e., after this step, s may become s = x + y or s = y + x.
 * Apply step 1 recursively on each of the two substrings x and y.
 * Given two strings s1 and s2 of the same length, return true if s2 is a
 * scrambled string of s1, otherwise, return false.
 */

import java.util.HashMap;

class ScrambleString {

    // Time -> O(n^4) //
    // Space -> O(n^3) //

    private static HashMap<String, Boolean> map = new HashMap<String, Boolean>();

    private static boolean isScramble(String a, String b) {
        int n = a.length();
        int m = b.length();

        if (n != m) {
            return false;
        }

        if (a.equals(b)) {
            return true;
        }

        if (n <= 1) {
            return false;
        }

        String key = a + " " + b;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        boolean flag = false;

        for (int k = 1; k <= n - 1; k++) {
            boolean condition1 = (isScramble(a.substring(0, k), b.substring(0, k)) == true)
                    && (isScramble(a.substring(k, n), b.substring(k, n)) == true);

            boolean condition2 = (isScramble(a.substring(0, k), b.substring(n - k, n)) == true)
                    && (isScramble(a.substring(k, n), b.substring(0, n - k)) == true);

            if (condition1 || condition2) {
                flag = true;
                break;
            }
        }

        map.put(key, flag);

        return flag;
    }

    public static void main(String[] args) {
        String s1 = "great";
        String s2 = "rgeat";

        System.out.println(isScramble(s1, s2));
    }
}