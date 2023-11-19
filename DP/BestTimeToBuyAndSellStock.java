/*
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 */

public class BestTimeToBuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int n = prices.length;

        int profit = 0;
        int min = prices[0];
        int cost = 0;

        for (int i = 1; i < n; i++) {
            cost = prices[i] - min;
            profit = Math.max(profit, cost);
            min = Math.min(min, prices[i]);
        }

        return profit;
    }

    public static void main(String[] args) {
        int[] prices = { 2, 4, 1 };

        int answer = maxProfit(prices);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxProfit(int[] prices) {
// int min = prices[0];
// int maxS = Integer.MIN_VALUE;

// for (int i = 0; i < prices.length; i++) {
// maxS = Math.max(maxS, prices[i] - min);
// min = Math.min(min, prices[i]);
// }

// System.gc();
// return maxS;
// }
// }