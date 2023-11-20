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

public class BestTimeToBuyAndSellStockWithCooldown {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] t = new int[n + 2][2];

        int profit = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= 1; j++) {
                if (j == 0) {
                    profit = Math.max(0 + t[i + 1][0], -prices[i] + t[i + 1][1]);
                }

                if (j == 1) {
                    profit = Math.max(0 + t[i + 1][1], prices[i] + t[i + 2][0]);
                }

                t[i][j] = profit;
            }
        }

        return t[0][0];
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 3, 0, 2 };

        int answer = maxProfit(prices);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxProfit(int[] prices) {

// if (prices.length == 1)
// return 0;

// int bsp = -prices[0];
// int ssp = 0;
// int csp = 0;

// for (int i = 1; i < prices.length; i++) {
// bsp = Math.max(bsp, csp - prices[i]);
// csp = ssp;
// ssp = Math.max(ssp, bsp + prices[i]);

// }

// return ssp;
// }
// }