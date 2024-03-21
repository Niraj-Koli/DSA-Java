/*
 * The count-and-say sequence is a sequence of digit strings defined by the
 * recursive formula:
 * 
 * countAndSay(1) = "1"
 * countAndSay(n) is the way you would "say" the digit string from
 * countAndSay(n-1), which is then converted into a different digit string.
 * To determine how you "say" a digit string, split it into the minimal number
 * of substrings such that each substring contains exactly one unique digit.
 * Then for each substring, say the number of digits, then say the digit.
 * Finally, concatenate every said digit.
 * 
 * For example, the saying and conversion for digit string "3322251":
 */

public class CountAndSay {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static String build(String s) {
        int n = s.length();

        StringBuilder res = new StringBuilder();

        int p = 0;

        while (p < n) {
            char val = s.charAt(p);
            int count = 0;

            while (p < n && s.charAt(p) == val) {
                p++;
                count++;
            }

            res.append(String.valueOf(count));
            res.append(val);
        }

        return res.toString();
    }

    private static String countAndSay(int n) {
        String s = "1";

        for (int i = 1; i < n; i++) {
            s = build(s);
        }

        return s;
    }

    public static void main(String[] args) {
        int n = 10;

        System.out.println(countAndSay(n));
    }
}