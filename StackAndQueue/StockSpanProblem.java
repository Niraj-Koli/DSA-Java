/*
 * The stock span problem is a financial problem where we have a series of N
 * daily price quotes for a stock and we need to calculate the span of the
 * stock’s price for all N days. The span Si of the stock’s price on a given day
 * i is defined as the maximum number of consecutive days just before the given
 * day, for which the price of the stock on the current day is less than or
 * equal to its price on the given day.
 */

import java.util.ArrayDeque;

public class StockSpanProblem {
    public static int[] stockSpan(int[] price) {
        int n = price.length;

        int[] result = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            if (stack.isEmpty()) {
                result[i] = -1;
            } else if (!stack.isEmpty() && price[stack.peekLast()] > price[i]) {
                result[i] = stack.peekLast();
            } else if (!stack.isEmpty() && price[stack.peekLast()] <= price[i]) {
                while (!stack.isEmpty() && price[stack.peekLast()] <= price[i]) {
                    stack.poll();
                }

                if (stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peekLast();
                }
            }

            stack.offerLast(i);
        }

        for (int i = 0; i < n; i++) {
            result[i] = i - result[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] price = { 100, 80, 60, 70, 60, 75, 85 };

        int[] answer = stockSpan(price);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}