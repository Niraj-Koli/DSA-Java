/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 */

import java.util.HashMap;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        int magazineLen = magazine.length();
        int ransomNoteLen = ransomNote.length();

        for (int index = 0; index < magazineLen; index++) {
            char c = magazine.charAt(index);

            int count = map.getOrDefault(c, 0) + 1;

            map.put(c, count);
        }

        for (int i = 0; i < ransomNoteLen; i++) {
            char c = ransomNote.charAt(i);

            if (!map.containsKey(c)) {
                System.out.println(false);
            } else {
                int count = map.get(c) - 1;

                if (count == 0) {
                    map.remove(c);
                } else {
                    map.put(c, count);
                }
            }
        }

        System.out.println(true);
    }
}

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] indexMap = new int[26];

        for (char c : ransomNote.toCharArray()) {
            int sourceIndex = magazine.indexOf(c, indexMap[c - 'a']);

            if (sourceIndex == -1) {
                return false;
            }
            indexMap[c - 'a'] = sourceIndex + 1;
        }
        return true;
    }
}