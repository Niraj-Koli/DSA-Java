/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like (i.e., buy one and sell one share of the stock
 * multiple times) with the following restrictions:
 * 
 * After you sell your stock, you cannot buy stock on the next day (i.e.,
 * cooldown one day).
 * Note: You may not engage in multiple transactions simultaneously (i.e., you
 * must sell the stock before you buy again).
 */

class BestTimeToBuyAndSellStockWithCooldown {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(0 + dp[i + 1][0], -prices[i] + dp[i + 1][1]);
                }

                if (j == 1) {
                    profit = Math.max(0 + dp[i + 1][1], prices[i] + dp[i + 2][0]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };

        System.out.println(maxProfit(prices));
    }
}