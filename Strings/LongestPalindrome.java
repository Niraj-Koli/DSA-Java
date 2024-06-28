/*
 * Given a string s which consists of lowercase or uppercase letters, return the
 * length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 */

import java.util.HashMap;
import java.util.Map;

class LongestPalindrome {

    // Time -> O(n + size) //
    // Space -> O(n) //

    private static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean isOneOddPresent = false;
        int res = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            if (value % 2 == 0) {
                res += value;
            } else {
                res += value - 1;
                isOneOddPresent = true;
            }
        }

        if (isOneOddPresent) {
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abccccdd";

        System.out.println(longestPalindrome(s));
    }
}