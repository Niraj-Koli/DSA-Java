/*
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 */

import java.util.ArrayDeque;

class DailyTemperatures {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;

        int[] res = new int[n];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                res[i] = 0;
            } else if (!stack.isEmpty() && temperatures[stack.peekLast()] > temperatures[i]) {
                res[i] = stack.peekLast() - i;
            } else if (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    res[i] = 0;
                } else {
                    res[i] = stack.peekLast() - i;
                }
            }
            stack.offer(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] ans = dailyTemperatures(temperatures);

        for (int an : ans) {
            System.err.print(an + " ");
        }
    }
}