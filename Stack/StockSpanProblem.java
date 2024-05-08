/*
 * The stock span problem is a financial problem where we have a series of N
 * daily price quotes for a stock and we need to calculate the span of the
 * stock’s price for all N days. The span Si of the stock’s price on a given day
 * i is defined as the maximum number of consecutive days just before the given
 * day, for which the price of the stock on the current day is less than or
 * equal to its price on the given day.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

class StockSpanProblem {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] stockSpan(int[] price) {
        int n = price.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && price[stack.peekLast()] < price[i]) {
                res[stack.pollLast()] = i;
            }
            stack.offer(i);
        }

        for (int i = 0; i < n; i++) {
            res[i] = i - res[i];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] price = { 100, 80, 60, 70, 60, 75, 85 };

        int[] ans = stockSpan(price);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}