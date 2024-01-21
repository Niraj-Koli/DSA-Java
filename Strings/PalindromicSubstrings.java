/*
 * Given a string s, return the number of palindromic substrings in it.
 * 
 * A string is a palindrome when it reads the same backward as forward.
 * 
 * A substring is a contiguous sequence of characters within the string.
 */

import java.util.HashMap;

public class PalindromicSubstrings {
    public static boolean isPalindromic(String substr) {
        int i = 0;
        int j = substr.length() - 1;

        while (i < j) {
            if (substr.charAt(i) != substr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static int countSubstrings(String s) {
        int len = s.length();

        HashMap<String, Boolean> map = new HashMap<String, Boolean>();

        int count = 0;

        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                String subStr = s.substring(i, j + 1);

                if (map.containsKey(subStr)) {
                    if (map.get(subStr)) {
                        count++;
                    }
                } else {
                    if (isPalindromic(subStr)) {
                        map.put(subStr, true);
                        count++;
                    } else {
                        map.put(subStr, false);
                    }
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        String s = "abc";

        int answer = countSubstrings(s);

        System.out.println(answer);
    }
}

// class Solution {
// public int countSubstrings(String s) {
// int substrings = 0;

// for (int i = 0; i < s.length(); i++) {
// int left = i;
// int right = i;

// while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
// {
// substrings++;
// left--;
// right++;
// }
// }

// for (int i = 0; i < s.length(); i++) {
// int left = i;
// int right = i + 1;

// while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
// {
// substrings++;
// left--;
// right++;
// }
// }

// return substrings;
// }
// }