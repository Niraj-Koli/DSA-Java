/*
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * 
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 */

class ValidAnagram {

    // Time -> O(n) //
    // Space -> O(1) //

    private static boolean isAnagram(String s, String t) {
        int[] map = new int[26];

        for (char x : s.toCharArray()) {
            map[x - 'a']++;
        }

        for (char y : t.toCharArray()) {
            map[y - 'a']--;
        }

        for (int value : map) {
            if (value != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(isAnagram(s, t));
    }
}