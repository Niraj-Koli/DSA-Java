/*
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 */

import java.util.ArrayList;
import java.util.Arrays;

class WordBreak {

    // Time -> O(n^2 * m) //
    // Space -> O(n) //

    private static boolean wordBreak(String s, ArrayList<String> wordDict) {
        int n = s.length();

        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        ArrayList<String> wordDict = new ArrayList<String>(Arrays.asList("apple", "pen"));

        System.out.println(wordBreak(s, wordDict));
    }
}