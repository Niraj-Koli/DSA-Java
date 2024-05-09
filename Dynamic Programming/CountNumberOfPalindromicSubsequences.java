/*
 * A subsequence of a string is achieved by removing some (possibly 0)
 * characters without changing the order of the remaining characters.
 * 
 * You have been given a string 's'.
 * 
 * Find the number of non-empty palindromic subsequences (not necessarily be
 * distinct) in string 's'
 */

class CountNumberOfPalindromicSubsequences {

    // Time -> O(n^2) //
    // Space -> O(n^2) //

    private static int countPalindromicSubseq(String s) {
        int n = s.length();

        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                int len = j - i + 1;

                if (len == 1) {
                    dp[i][j] = 1;
                } else if (len == 2) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 3;
                    } else {
                        dp[i][j] = 2;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = (1 + dp[i + 1][j] + dp[i][j - 1]);
                    } else {
                        dp[i][j] = ((dp[i + 1][j] + dp[i][j - 1]) - dp[i + 1][j - 1]);
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String s = "pqqr";

        System.out.println(countPalindromicSubseq(s));
    }
}