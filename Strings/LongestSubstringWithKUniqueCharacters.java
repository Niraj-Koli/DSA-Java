/*
 * Given a string you need to print the size of the longest possible substring
 * that has exactly K unique characters. If there is no possible substring then
 * print -1.
 */

import java.util.HashMap;

public class LongestSubstringWithKUniqueCharacters {
    public static int longestSubstring(String s, int k) {
        int len = s.length();

        int i = 0;
        int j = 0;

        int max = 0;

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        while (j < len) {
            char charAtJ = s.charAt(j);

            int value = map.getOrDefault(charAtJ, 0);

            map.put(charAtJ, value + 1);

            if (map.size() == k) {
                max = Math.max(max, j - i + 1);
            } else if (map.size() > k) {
                while (map.size() > k) {
                    char charAtI = s.charAt(i);
                    int count = map.get(charAtI);

                    map.put(charAtI, count - 1);

                    if (map.get(charAtI) == 0) {
                        map.remove(charAtI);
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        int answer = longestSubstring(s, k);

        System.out.println(answer);
    }
}
