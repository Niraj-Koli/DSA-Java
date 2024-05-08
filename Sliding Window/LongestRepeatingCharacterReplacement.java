/*
 * You are given a string s and an integer k. You can choose any character of
 * the string and change it to any other uppercase English character. You can
 * perform this operation at most k times.
 * 
 * Return the length of the longest substring containing the same letter you can
 * get after performing the above operations.
 */

class LongestRepeatingCharacterReplacement {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int characterReplacement(String s, int k) {
        int n = s.length();

        int[] map = new int[26];

        int max = 0;
        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            map[s.charAt(j) - 'A']++;

            max = Math.max(max, map[s.charAt(j) - 'A']);

            if (j - i + 1 - max > k) {
                map[s.charAt(i) - 'A']--;
                i++;
            }

            res = Math.max(max, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;

        System.out.println(characterReplacement(s, k));
    }
}