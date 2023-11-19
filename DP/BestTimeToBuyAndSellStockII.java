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
    public static int[][] t;

    public static int getProfitRecursive(int[] prices, int index, int buy, int n) {
        if (index == n) {
            return 0;
        }

        if (t[index][buy] != 0) {
            return t[index][buy];
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

        t[index][buy] = profit;

        return t[index][buy];
    }

    public static int getProfitIterative(int[] prices) {
        int n = prices.length;

        int[][] t = new int[n + 1][2];

        t[n][0] = t[n][1] = 0;

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(0 + t[i + 1][0], -prices[i] + t[i + 1][1]);
                }

                if (j == 1) {
                    profit = Math.max(0 + t[i + 1][1], prices[i] + t[i + 1][0]);
                }

                t[i][j] = profit;
            }
        }

        return t[0][0];
    }

    static int maxProfit(int[] prices) {
        int n = prices.length;

        t = new int[n][2];

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