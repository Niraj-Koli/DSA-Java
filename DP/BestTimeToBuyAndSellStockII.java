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

public class BestTimeToBuyAndSellStockII {
    public static int[][] dp;

    public static int getProfitRecursive(int[] prices, int index, int buy, int n) {
        if (index == n) {
            return 0;
        }

        if (dp[index][buy] != 0) {
            return dp[index][buy];
        }

        int profit = 0;

        if (buy == 0) {
            profit = Math.max(0 + getProfitRecursive(prices, index + 1, 0, n),
                    -prices[index] + getProfitRecursive(prices, index + 1, 1, n));
        }

        if (buy == 1) {
            profit = Math.max(0 + getProfitRecursive(prices, index + 1, 1, n),
                    prices[index] + getProfitRecursive(prices, index + 1, 0, n));
        }

        dp[index][buy] = profit;

        return dp[index][buy];
    }

    public static int getProfitIterative(int[] prices) {
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

    static int maxProfit(int[] prices) {
        int n = prices.length;

        dp = new int[n][2];

        return getProfitIterative(prices);
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        int answer = maxProfit(prices);

        System.out.println(answer);
    }
}

// public class Solution {
// public static int maxProfit(int[] prices) {
// int n = prices.length;

// int maxProfit = 0;

// for (int i = 1; i < n; i++) {
// int profit = prices[i] - prices[i - 1];

// if (profit > 0) {
// maxProfit += profit;
// }
// }

// return maxProfit;
// }
// }