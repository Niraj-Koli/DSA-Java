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

    // Time -> O(n)
    // Space -> O(1)

    private static int maxProfit(int[] prices) {
        int n = prices.length;

        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, prices[i]);

            int cost = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, cost);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices = { 7, 1, 5, 3, 6, 4 };

        System.out.println(maxProfit(prices));
    }
}