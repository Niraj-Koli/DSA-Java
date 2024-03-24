/*
 * Given a string s consisting only of characters a, b and c.
 * 
 * Return the number of substrings containing at least one occurrence of all
 * these characters a, b and c.
 */

public class NumberOfSubstringsContainingAllThreeCharacters {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int numberOfSubstrings(String s) {
        int n = s.length();

        int res = 0;

        int[] count = { 0, 0, 0 };

        for (int i = 0, j = 0; j < n; j++) {
            char charAtJ = s.charAt(j);

            count[charAtJ - 'a']++;

            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                char charAtI = s.charAt(i);
                count[charAtI - 'a']--;
                i++;
            }
            res += i;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabc";

        System.out.println(numberOfSubstrings(s));
    }
}