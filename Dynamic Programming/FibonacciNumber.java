/*
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the
 * Fibonacci sequence, such that each number is the sum of the two preceding
 * ones, starting from 0 and 1. That is,
 * 
 * F(0) = 0, F(1) = 1
 * F(n) = F(n - 1) + F(n - 2), for n > 1.
 * Given n, calculate F(n).
 */

import java.util.HashMap;

class FibonacciNumber {

    // 2D Array -> Iterative //

    // Time -> O(n) //
    // Space -> O(n) //

    private static int fibIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // 2D Array -> Recursive //

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] dp;

    private static int fibRecursive(int n) {
        dp = new int[n + 1];

        return calculateFibonacci(n);
    }

    private static int calculateFibonacci(int n) {
        if (n <= 1) {
            dp[n] = n;

            return dp[n];
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        dp[n] = calculateFibonacci(n - 1) + calculateFibonacci(n - 2);

        return dp[n];
    }

    // Map -> Recursive //

    // Time -> O(n) //
    // Space -> O(n) //

    private static HashMap<Integer, Integer> memo = new HashMap<Integer, Integer>();

    private static int fib(int n) {
        if (n <= 1) {
            return n;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        int fibValue = fib(n - 1) + fib(n - 2);
        memo.put(n, fibValue);

        return fibValue;
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println(fibIterative(n));
        System.out.println(fibRecursive(n));
        System.out.println(fib(n));

    }
}