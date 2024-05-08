/*
 * Given two strings s and t of lengths m and n respectively, return the minimum
 * window
 * substring
 * of s such that every character in t (including duplicates) is included in the
 * window. If there is no such substring, return the empty string "".
 * 
 * The testcases will be generated such that the answer is unique.
 */

import java.util.HashMap;

class MinimumWindowSubstring {

    // Time -> O(n + m) //
    // Space -> O(m) //

    private static String minWindow(String s, String t) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (char ch : t.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int size = map.size();

        int windowStart = 0;
        int windowSize = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < n; j++) {
            char charAtJ = s.charAt(j);

            if (map.containsKey(charAtJ)) {
                map.put(charAtJ, map.get(charAtJ) - 1);

                if (map.get(charAtJ) == 0) {
                    size--;
                }
            }

            while (size == 0) {
                if (windowSize > j - i + 1) {
                    windowSize = j - i + 1;
                    windowStart = i;
                }

                char charAtI = s.charAt(i);

                if (map.containsKey(charAtI)) {
                    map.put(charAtI, map.get(charAtI) + 1);

                    if (map.get(charAtI) == 1) {
                        size++;
                    }
                }
                i++;
            }
        }

        return windowSize == Integer.MAX_VALUE ? "" : s.substring(windowStart, windowStart + windowSize);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }
}