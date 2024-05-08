/*
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 */

import java.util.HashMap;

class LongestSubstringWithoutRepeatingCharacters {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            char ch = s.charAt(j);

            if (map.containsKey(ch)) {
                i = Math.max(map.get(ch) + 1, i);
            }

            map.put(ch, j);

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";

        System.out.println(lengthOfLongestSubstring(s));
    }
}