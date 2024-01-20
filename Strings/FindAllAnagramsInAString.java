/*
 * Given two strings s and p, return an array of all the start indices of p's
 * anagrams in s. You may return the answer in any order.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagramsInAString {

    public static List<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int index = 0; index < k; index++) {
            int count = map.getOrDefault(p.charAt(index), 0);

            map.put(p.charAt(index), count + 1);
        }

        int i = 0;
        int j = 0;

        int counter = map.size();

        List<Integer> result = new ArrayList<Integer>();

        while (j < n) {
            char charAtJ = s.charAt(j);

            if (map.containsKey(charAtJ)) {
                int count = map.get(charAtJ);

                map.put(charAtJ, count - 1);

                if (map.get(charAtJ) == 0) {
                    counter--;
                }
            }


            if (j - i + 1 == k) {
                if (counter == 0) {
                    result.add(i);
                }

                char charAtI = s.charAt(i);

                if (map.containsKey(charAtI)) {
                    int count = map.get(charAtI);

                    map.put(charAtI, count + 1);
                    
                    if (map.get(charAtI) == 1) {
                        counter++;
                    }
                }

                i++;
            }
            j++;
        }

        return result;

    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> answer = findAnagrams(s, p);

        System.out.println(answer);
    }
}

// class Solution {
// public List<Integer> findAnagrams(String s, String p) {
// List<Integer> result = new ArrayList<>();

// int[] pArr = new int[26];
// int[] sArr = new int[26];

// for (char c : p.toCharArray()) {
// pArr[c - 'a']++;
// }

// int left = 0;
// int right = 0;

// while (right < s.length()) {
// char c = s.charAt(right);
// sArr[c - 'a']++;

// while (sArr[c - 'a'] > pArr[c - 'a']) {
// char leftChar = s.charAt(left);
// sArr[leftChar - 'a']--;
// left++;
// }

// if (right - left + 1 == p.length()) {
// result.add(left);
// }

// right++;
// }

// return result;
// }
// }
