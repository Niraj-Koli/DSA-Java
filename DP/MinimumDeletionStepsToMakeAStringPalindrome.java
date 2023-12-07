/*
 * Given a string 'str' of size ‘n’. The task is to remove or delete the minimum
 * number of characters from the string so that the resultant string is a
 * palindrome. Find the minimum numbers of characters we need to remove.
 */

public class MinimumDeletionStepsToMakeAStringPalindrome {
    public static int lcs(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        return dp[n][m];
    }

    public static int lps(String s) {
        StringBuilder p = new StringBuilder(s);

        return lcs(s, p.reverse().toString());
    }

    public static int minDeletions(String s) {
        int n = s.length();

        int lpsLength = lps(s);

        return n - lpsLength;
    }

    public static void main(String[] args) {
        String str = "aebcbda";

        int answer = minDeletions(str);

        System.out.println(answer);
    }
}