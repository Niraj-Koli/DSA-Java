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

public class BestTimeToBuyAndSellStockIII {
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;

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
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };

        int answer = maxProfit(prices);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxProfit(int[] prices) {
// int oneCost = Integer.MAX_VALUE, twoCost = Integer.MAX_VALUE;
// int oneProfit = 0, twoProfit = 0;
// for (int price : prices) {
// oneCost = Math.min(oneCost, price);
// oneProfit = Math.max(oneProfit, price - oneCost);
// twoCost = Math.min(twoCost, price - oneProfit);
// twoProfit = Math.max(twoProfit, price - twoCost);
// }

// return twoProfit;
// }
// }