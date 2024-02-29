/*
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days you have to
 * wait after the ith day to get a warmer temperature. If there is no future day
 * for which this is possible, keep answer[i] == 0 instead.
 */

import java.util.ArrayDeque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = len - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                result[i] = 0;
            } else if (!stack.isEmpty() && temperatures[stack.peekLast()] > temperatures[i]) {
                result[i] = stack.peekLast() - i;
            } else if (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                while (!stack.isEmpty() && temperatures[stack.peekLast()] <= temperatures[i]) {
                    stack.pollLast();
                }

                if (stack.isEmpty()) {
                    result[i] = 0;
                } else {
                    result[i] = stack.peekLast() - i;
                }
            }
            stack.offerLast(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = { 30, 60, 90 };

        int[] result = dailyTemperatures(temperatures);

        for (int num : result) {
            System.err.print(num + " ");
        }
    }
}

// class Solution {
// public int[] dailyTemperatures(int[] temperatures) {
// int len = temperatures.length;
// int[] answer = new int[len];

// for (int i = 0; i < len - 1; i++) {
// int j = i + 1;

// while (j < len && temperatures[i] >= temperatures[j]) {
// j++;
// }

// if (j < len) {
// answer[i] = j - i;
// } else {
// answer[i] = 0;
// }
// }

// return answer;
// }
// }

// class Solution {
// public int[] dailyTemperatures(int[] temperatures) {
// int n = temperatures.length;
// int[] res = new int[n];
// int hottest = res[n - 1];

// for (int i = n - 1; i >= 0; i--) {
// int curr = temperatures[i];
// if (curr >= hottest) {
// hottest = curr;
// continue; //no hotter day after day i
// }

// int d = 1; //d days to wait to get a warmer temperature
// while (curr >= temperatures[i + d]) {
// d = d + res[i + d];
// }
// res[i] = d;
// }
// return res;
// }
// }
