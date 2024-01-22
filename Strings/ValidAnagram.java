/*
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */

import java.util.HashMap;

public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        int len = t.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        if (s.length() != t.length()) {
            return false;
        }

        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);

            map.put(c, count + 1);
        }

        for (int i = 0; i < len; i++) {
            char charAtI = t.charAt(i);

            if (!map.containsKey(charAtI)) {
                return false;
            }

            int count = map.get(charAtI);

            map.put(charAtI, count - 1);

            if (map.get(charAtI) == 0) {
                map.remove(charAtI);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        boolean answer = isAnagram(s, t);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean isAnagram(String s, String t) {
// int len1 = s.length();
// int len2 = t.length();

// if (len1 != len2) {
// return false;
// }

// int[] arr1 = new int[123];
// int[] arr2 = new int[123];

// for (int i = 0; i < len1; i++) {
// int c1 = (int) s.charAt(i);
// int c2 = (int) t.charAt(i);

// arr1[c1]++;
// arr2[c2]++;
// }

// for (int i = 97; i <= 122; i++) {
// if (arr1[i] != arr2[i]) {
// return false;
// }
// }

// return true;
// }
// }