/*
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 */

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();

        int i = 0;
        int j = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int max = 0;

        while (j < len) {
            char c = s.charAt(j);

            if (map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }

            map.put(c, j);
            
            max = Math.max(max, j - i + 1);

            j++;
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "pwwkew";

        int answer = lengthOfLongestSubstring(s);

        System.out.println(answer);
    }
}

// class Solution {
// public int lengthOfLongestSubstring(String s) {
// int maxLength = 0;

// for (int rightPointer = 0, leftPointer = 0; rightPointer < s.length();
// rightPointer++) {
// char currentChar = s.charAt(rightPointer);
// int indexOfFirstAppearanceInSubstring = s.indexOf((currentChar),
// leftPointer);
// if (indexOfFirstAppearanceInSubstring != rightPointer) {
// leftPointer = indexOfFirstAppearanceInSubstring + 1;
// }
// maxLength = Math.max(maxLength, rightPointer - leftPointer + 1);
// }
// return maxLength;
// }
// }