/*
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day, and an integer k.
 * 
 * Find the maximum profit you can achieve. You may complete at most k
 * transactions: i.e. you may buy at most k times and sell at most k times.
 * 
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 */

class BestTimeToBuyAndSellStockIV {

    // Time -> O(n * k) //
    // Space -> O(n * k) //

    private static int maxProfit(int[] prices, int k) {
        int n = prices.length;

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
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int k = 2;

        System.out.println(maxProfit(prices, k));
    }
}