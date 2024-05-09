/*
 * You are given an integer array prices where prices[i] is the price of a given
 * stock on the ith day.
 * 
 * On each day, you may decide to buy and/or sell the stock. You can only hold
 * at most one share of the stock at any time. However, you can buy it then
 * immediately sell it on the same day.
 * 
 * Find and return the maximum profit you can achieve.
 */

class BestTimeToBuyAndSellStockII {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int solve(int[] prices, int index, int buy, int[][] dp) {
        if (index == prices.length) {
            return 0;
        }

        if (dp[index][buy] != 0) {
            return dp[index][buy];
        }

        int profit = 0;

        if (buy == 0) {
            profit = Math.max(0 + solve(prices, index + 1, 0, dp),
                    -prices[index] + solve(prices, index + 1, 1, dp));
        }

        if (buy == 1) {
            profit = Math.max(0 + solve(prices, index + 1, 1, dp),
                    prices[index] + solve(prices, index + 1, 0, dp));
        }

        dp[index][buy] = profit;

        return dp[index][buy];
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        dp[n][0] = dp[n][1] = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(0 + dp[i + 1][0], -prices[i] + dp[i + 1][1]);
                }

                if (j == 1) {
                    profit = Math.max(0 + dp[i + 1][1], prices[i] + dp[i + 1][0]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println(maxProfit(prices));

        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        System.out.println(solve(prices, 0, 0, dp));
    }
}