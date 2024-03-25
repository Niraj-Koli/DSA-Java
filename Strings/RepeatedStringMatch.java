/*
 * Given two strings a and b, return the minimum number of times you should
 * repeat string a so that string b is a substring of it. If it is impossible
 * for b​​​​​​ to be a substring of a after repeating it, return -1.
 * 
 * Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and
 * repeated 2 times is "abcabc".
 */

public class RepeatedStringMatch {

    // Time -> O(n * m) //
    // Space -> O(1) //

    private static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int res = 0;

        while (sb.length() <= a.length() + b.length()) {
            res++;
            sb.append(a);

            if (sb.indexOf(b) != -1) {
                return res;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String a = "abcd";
        String b = "cdabcdab";

        System.out.println(repeatedStringMatch(a, b));
    }
}