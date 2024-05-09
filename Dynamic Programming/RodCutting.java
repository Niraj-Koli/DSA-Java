/*
 * Given a rod of length N inches and an array of prices, prices[]. prices[i]
 * denotes the value of a piece of length i. Determine the maximum value
 * obtainable by cutting up the rod and selling the pieces.
 * 
 * Note: Consider 1-based indexing.
 */

class RodCutting {

    // Time -> O(n * m) //
    // Space -> O(n * m) //

    private static int cutRod(int prices[], int n) {
        int[] length = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        int m = length.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(prices[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 5, 8, 9, 10, 17, 17, 20 };
        int n = 8;

        System.out.println(cutRod(prices, n));
    }
}