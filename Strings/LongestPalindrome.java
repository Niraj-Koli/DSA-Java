/*
 * Given a string s which consists of lowercase or uppercase letters, return the
 * length of the longest palindrome that can be built with those letters.
 * 
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome
 * here.
 */

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static int longestPalindrome(String s) {
        int n = s.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean isOneOddPresent = false;
        int longest = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();

            if (value % 2 == 0) {
                longest += value;
            } else {
                longest += value - 1;
                isOneOddPresent = true;
            }
        }

        if (isOneOddPresent) {
            longest++;
        }

        return longest;
    }

    public static void main(String[] args) {
        String s = "abccccdd";

        int ans = longestPalindrome(s);

        System.out.println(ans);
    }
}

// class Solution {
// public int longestPalindrome(String s) {
// int[] freq = new int[58];
// for (char c : s.toCharArray()) {
// freq[c - 'A']++;
// }
// int res = 0;
// boolean key = false;
// for (int i = 0; i < 58; i++) {
// int val = freq[i];
// if (val % 2 != 0) {
// key = true;
// }
// res += val / 2 * 2;
// }
// if (key) {
// res++;
// }
// return res;
// }
// }