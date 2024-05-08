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

class FindAllAnagramsInAString {

    // Time -> O(2 * n) //
    // Space -> O(n) //

    private static ArrayList<Integer> findAnagrams(String s, String p) {
        int n = s.length();
        int k = p.length();

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < k; i++) {
            char ch = p.charAt(i);

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int size = map.size();

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0, j = 0; j < n; j++) {
            char charAtJ = s.charAt(j);

            if (map.containsKey(charAtJ)) {
                map.put(charAtJ, map.get(charAtJ) - 1);

                if (map.get(charAtJ) == 0) {
                    size--;
                }
            }

            if (j - i + 1 == k) {
                if (size == 0) {
                    res.add(i);
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

        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        System.out.println(findAnagrams(s, p));
    }
}