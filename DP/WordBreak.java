/*
 * Given a string s and a dictionary of strings wordDict, return true if s can
 * be segmented into a space-separated sequence of one or more dictionary words.
 * 
 * Note that the same word in the dictionary may be reused multiple times in the
 * segmentation.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
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
        List<String> wordDict = new ArrayList<String>(Arrays.asList("apple", "pen"));

        boolean ans = wordBreak(s, wordDict);

        System.out.println(ans);
    }
}

// class Solution {
// public boolean wordBreak(String s, List<String> wordDict) {
// int n = s.length();
// boolean[] dp = new boolean[n];
// for (int i = 0; i < n; i++) {
// for (String word : wordDict) {
// if (i + word.length() - 1 < n
// && (i == 0 || dp[i - 1])
// && stringEquality(s, i, word)) {
// dp[i + word.length() - 1] = true;
// }
// }
// }
// return dp[n - 1];
// }

// public boolean stringEquality(String s1, int start_idx, String s2) {
// for (int i = 0; i < s2.length(); i++) {
// if (s1.charAt(i + start_idx) != s2.charAt(i))
// return false;
// }
// return true;
// }
// }