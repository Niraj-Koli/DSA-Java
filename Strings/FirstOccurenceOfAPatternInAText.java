/*
 * You are given two strings ‘text’ and ’pat’, containing only lowercase
 * alphabets.
 * 
 * Find the first index of ‘text’ where ‘pat’ matches with a substring of
 * ‘text’, starting at that index.
 * 
 * Return -1 if such an index doesn’t exist.
 */

public class FirstOccurenceOfAPatternInAText {

    // Time -> O(n * m) //
    // Space -> O(1) //

    private static int firstOccurence(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        for (int i = 0; i < n - m; i++) {
            String subString = text.substring(i, i + m);

            if (pattern.equals(subString)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String text = "abcdecd";
        String pattern = "cd";

        System.out.println(firstOccurence(text, pattern));
    }
}