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

public class LongestStringChain {
    public static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int left = 0;
        int right = 0;

        while (left < s1.length()) {
            if (right < s2.length() && s1.charAt(left) == s2.charAt(right)) {
                left++;
                right++;
            } else {
                left++;
            }
        }

        return (left == s1.length() && right == s2.length());
    }

    public static int longestStrChain(String[] words) {
        int n = words.length;

        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());

        System.out.println(Arrays.toString(words));

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {

                if (compare(words[i], words[prev]) && 1 + dp[prev] > dp[i]) {
                    dp[i] = 1 + dp[prev];
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

        int answer = longestStrChain(words);

        System.out.println(answer);
    }
}

// class Solution {
//     Map<String, Integer> map;
//     Set<String> set;

//     public int longestStrChain(String[] words) {
//         map = new HashMap<>();
//         set = new HashSet<>();
//         for (String str : words) {
//             set.add(str);
//         }
//         int res = 0;
//         int n = words.length;
//         for (int i = 0; i < n; i++) {
//             res = Math.max(res, dfs(words[i]));
//         }
//         System.gc();
//         return res;
//     }

//     public int dfs(String word) {
//         if (!set.contains(word)) {
//             return 0;
//         }
//         if (map.containsKey(word))
//             return map.get(word);
//         int len = 1;
//         for (int i = 0; i < word.length(); i++) {
//             String w = word.substring(0, i) + word.substring(i + 1);
//             len = Math.max(len, 1 + dfs(w));
//         }
//         map.put(word, len);
//         return len;
//     }
// }