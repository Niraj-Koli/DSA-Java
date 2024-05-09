class LongestRepeatingSubsequence {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static String longestCommonSubsequence(String x, String y) {
        int n = x.length();
        int m = y.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (x.charAt(i - 1) == y.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        int i = n;
        int j = m;

        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                res.append(x.charAt(i - 1));

                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return res.reverse().toString();
    }

    public static String longestSubsequenceRepeated(String s) {
        return longestCommonSubsequence(s, s);
    }

    public static void main(String[] args) {
        String s = "axxzxy";

        System.out.println(longestSubsequenceRepeated(s));
    }
}
