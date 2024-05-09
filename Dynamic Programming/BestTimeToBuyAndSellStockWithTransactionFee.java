/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day, and an integer fee representing a transaction fee.
 * 
 * Find the maximum profit you can achieve. You may complete as many
 * transactions as you like, but you need to pay the transaction fee for each
 * transaction.
 * 
 * Note:
 * 
 * You may not engage in multiple transactions simultaneously (i.e., you must
 * sell the stock before you buy again).
 * The transaction fee is only charged once for each stock purchase and sale.
 */

class BestTimeToBuyAndSellStockWithTransactionFee {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int maxProfit(int[] prices, int fee) {
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
                    profit = Math.max(0 + dp[i + 1][1], prices[i] - fee + dp[i + 1][0]);
                }

                dp[i][j] = profit;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }
}