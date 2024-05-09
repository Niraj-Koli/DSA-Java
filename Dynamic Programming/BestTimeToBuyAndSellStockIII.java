/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete at most two
 * transactions.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you j again).
 */

class BestTimeToBuyAndSellStockIII {

    // Time -> O(n * k) //
    // Space -> O(n * k) //

    private static int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;

        int[][][] dp = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (j == 0) {
                        dp[i][j][cap] = Math.max(0 + dp[i + 1][0][cap],
                                -prices[i] + dp[i + 1][1][cap]);
                    } else {
                        dp[i][j][cap] = Math.max(0 + dp[i + 1][1][cap],
                                prices[i] + dp[i + 1][0][cap - 1]);
                    }
                }
            }
        }

        return dp[0][0][k];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };

        System.out.println(maxProfit(prices));
    }
}