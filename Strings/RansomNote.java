/*
 * Given two strings ransomNote and magazine, return true if ransomNote can be
 * constructed by using the letters from magazine and false otherwise.
 * 
 * Each letter in magazine can only be used once in ransomNote.
 */

class RansomNote {

    // Time -> O(n + m) //
    // Space -> O(1) //

    private static boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];

        for (char c : magazine.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            if (map[c - 'a'] == 0) {
                return false;
            }

            map[c - 'a']--;
        }

        return true;
    }

    public static void main(String[] args) {
        String ransomNote = "aa";
        String magazine = "aab";

        System.out.println(canConstruct(ransomNote, magazine));
    }
}