/*
 * Given an input string s, reverse the order of the words.
 * 
 * A word is defined as a sequence of non-space characters. The words in s will
 * be separated by at least one space.
 * 
 * Return a string of the words in reverse order concatenated by a single space.
 * 
 * Note that s may contain leading or trailing spaces or multiple spaces between
 * two words. The returned string should only have a single space separating the
 * words. Do not include any extra spaces.
 */

public class ReverseWordsInAString {

    // Time -> O(n) //
    // Space -> O(n) //

    private static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");

        int n = words.length;

        int i = 0;
        int j = n - 1;

        while (i < j) {
            String t = words[i];
            words[i] = words[j];
            words[j] = t;

            i++;
            j--;
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "the sky is blue";

        System.out.println(reverseWords(s));
    }
}