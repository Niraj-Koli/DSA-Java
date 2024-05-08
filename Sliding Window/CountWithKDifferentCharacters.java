/*
 * You are given a string 'str' of lowercase alphabets and an integer 'k' .
 * 
 * Your task is to return the count all the possible substrings that have
 * exactly 'k' distinct characters.
 */

class CountWithKDifferentCharacters {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int atMostK(String str, int k) {
        int n = str.length();

        int[] map = new int[26];

        int count = 0;
        int res = 0;

        for (int i = 0, j = 0; j < n; j++) {
            char charAtJ = str.charAt(j);
            map[charAtJ - 'a']++;

            if (map[charAtJ - 'a'] == 1) {
                count++;
            }

            while (count > k) {
                char charAtI = str.charAt(i);
                map[charAtI - 'a']--;

                if (map[charAtI - 'a'] == 0) {
                    count--;
                }
                i++;
            }

            res += (j - i + 1);
        }

        return res;
    }

    private static int countSubStrings(String str, int k) {
        return atMostK(str, k) - atMostK(str, k - 1);
    }

    public static void main(String[] args) {
        String str = "aacfssa";
        int k = 3;

        System.out.println(countSubStrings(str, k));
    }
}