/*
 * Given a string you need to print the size of the longest possible substring
 * that has exactly K unique characters. If there is no possible substring then
 * print -1.
 */

class LongestSubstringWithKUniqueCharacters {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int longestSubstring(String s, int k) {
        int n = s.length();

        int res = 0;

        int[] map = new int[26];
        int count = 0;

        for (int i = 0, j = 0; j < n; j++) {
            char charAtJ = s.charAt(j);

            map[charAtJ - 'a']++;

            if (map[charAtJ - 'a'] == 1) {
                count++;
            }

            if (count == k) {
                res = Math.max(res, j - i + 1);
            }

            while (count > k) {
                char charAtI = s.charAt(i);

                map[charAtI - 'a']--;

                if (map[charAtI - 'a'] == 0) {
                    count--;
                }
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;

        System.out.println(longestSubstring(s, k));
    }
}
