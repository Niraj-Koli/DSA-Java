/*
 * You are given two strings ‘S’ and ‘T’. Your task is to find the minimum
 * (Contiguous) substring ‘W’ of ‘S’, such that ‘T’ is a subsequence of ‘W’
 * 
 * A subsequence is a sequence that can be derived from another sequence by
 * removing zero or more elements, without changing the order.
 * 
 * A substring is a contiguous part of a string.
 */

class MinimumWindowSubsequence {

    // Time -> O(n) //
    // Space -> O(1) //

    private static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int windowSize = Integer.MAX_VALUE;

        String res = "";

        for (int i = 0, j = 0; i < n; i++) {
            if (s.charAt(i) == t.charAt(j)) {
                j++;

                if (j == m) {
                    int end = i + 1;
                    j--;

                    while (j >= 0) {
                        if (s.charAt(i) == t.charAt(j)) {
                            j--;
                        }
                        i--;
                    }

                    j++;
                    i++;

                    if (end - i < windowSize) {
                        windowSize = end - i;
                        res = s.substring(i, end);
                    }
                }
            }
        }
        
        return res;
    }

    public static void main(String[] args) {
        String s = "abcdebdde";
        String t = "bde";

        System.out.println(minWindow(s, t));
    }
}