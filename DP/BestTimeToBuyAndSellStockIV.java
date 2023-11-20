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

public class BestTimeToBuyAndSellStockIV {
    public static int maxProfit(int[] prices, int k) {
        int n = prices.length;

        int[][][] t = new int[n + 1][2][k + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                for (int cap = 1; cap <= k; cap++) {
                    if (j == 0) {
                        t[i][j][cap] = Math.max(0 + t[i + 1][0][cap],
                                -prices[i] + t[i + 1][1][cap]);
                    } else {
                        t[i][j][cap] = Math.max(0 + t[i + 1][1][cap],
                                prices[i] + t[i + 1][0][cap - 1]);
                    }
                }
            }
        }

        return t[0][0][k];
    }

    public static void main(String[] args) {
        int[] prices = { 3, 2, 6, 5, 0, 3 };
        int k = 2;

        int answer = maxProfit(prices, k);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxProfit(int k, int[] prices) {
// int len = prices.length;
// int[] t = new int[2 * k + 1];
// for (int i = 1; i <= 2 * k; i += 2) {
// t[i] = -prices[0];
// }

// for (int i = 1; i < len; i++) {
// for (int j = 1; j <= k * 2; j += 2) {
// t[j] = Math.max(t[j], t[j - 1] - prices[i]);
// t[j + 1] = Math.max(t[j + 1], t[j] + prices[i]);
// }
// }

// return t[2 * k];
// }
// }