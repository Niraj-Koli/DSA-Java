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

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int index = 0; index < t.length(); index++) {
            char charAtT = t.charAt(index);
            int count = map.getOrDefault(charAtT, 0);

            map.put(charAtT, count + 1);
        }

        int i = 0;
        int j = 0;

        int len = s.length();
        int size = map.size();

        int windowSize = Integer.MAX_VALUE;

        String result = "";

        while (j < len) {
            char charAtJ = s.charAt(j);

            if (map.containsKey(charAtJ)) {
                map.put(charAtJ, map.get(charAtJ) - 1);

                if (map.get(charAtJ) == 0) {
                    size--;
                }
            }

            if (size == 0) {
                while (size == 0) {
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);

                        if (map.get(s.charAt(i)) == 1) {
                            size++;

                            if (windowSize > j - i + 1) {
                                windowSize = Math.min(windowSize, j - i + 1);

                                result = s.substring(i, j + 1);
                            }
                        }
                    }
                    i++;
                }
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";

        String answer = minWindow(s, t);

        System.out.println(answer);
    }
}

// class Solution {
// public String minWindow(String s, String t) {
// int[] mapFreq = new int[128];
// int count = t.length();
// int left = 0;
// int right = 0;
// int leftIndex = 0;
// int minLen = Integer.MAX_VALUE;

// for (char c : t.toCharArray()) {
// mapFreq[c]++;
// }
// char[] window = s.toCharArray();
// while (right < window.length) {
// if (mapFreq[window[right++]]-- > 0) {
// count--;
// }
// while (count == 0) {
// if (right - left < minLen) {
// leftIndex = left;
// minLen = right - left;
// }
// if (mapFreq[window[left++]]++ == 0) {
// count++;
// }
// }
// }

// return minLen == Integer.MAX_VALUE ? "" : new String(window, leftIndex,
// minLen);
// }
// }