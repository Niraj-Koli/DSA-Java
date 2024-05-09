/*
 * You are given an array of words where each word consists of lowercase English
 * letters.
 * 
 * wordA is a predecessor of wordB if and only if we can insert exactly one
 * letter anywhere in wordA without changing the order of the other characters
 * to make it equal to wordB.
 * 
 * For example, "abc" is a predecessor of "abac", while "cba" is not a
 * predecessor of "bcad".
 * A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1,
 * where word1 is a predecessor of word2, word2 is a predecessor of word3, and
 * so on. A single word is trivially a word chain with k == 1.
 * 
 * Return the length of the longest possible word chain with words chosen from
 * the given list of words.
 */

import java.util.Arrays;

class LongestStringChain {

    // Time -> O(n^2 * m) //
    // Space -> O(n) //

    private static boolean isPredecessor(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n != m + 1) {
            return false;
        }

        int left = 0;
        int right = 0;

        while (left < n) {
            if (right < m && s1.charAt(left) == s2.charAt(right)) {
                left++;
                right++;
            } else {
                left++;
            }
        }

        return (left == n && right == m);
    }

    private static int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPredecessor(words[i], words[j]) && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                }
            }

            if (dp[i] > max) {
                max = dp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String[] words = { "xbc", "pcxbcf", "xb", "cxbc", "pcxbc" };

        System.out.println(longestStrChain(words));
    }
}