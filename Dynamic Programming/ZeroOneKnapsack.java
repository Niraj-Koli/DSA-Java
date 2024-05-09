/*
 * You are given weights and values of N items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. Note that we have
 * only one quantity of each item.
 * In other words, given two integer arrays values[0..N-1] and weights[0..N-1] which
 * represent values and weights associated with N items respectively. Also given
 * an integer W which represents knapsack capacity, find out the maximum value
 * subset of values[] such that sum of the weights of this subset is smaller than
 * or equal to W. You cannot break an item, either pick the complete item or
 * dont pick it (0-1 property).
 */

class ZeroOneKnapsack {

    // Time -> O(n * capacity) //
    // Space -> O(n * capacity) //

    private static int solve(int[] weights, int[] values, int capacity, int n, int[][] dp) {
        if (n == 0 || capacity == 0) {
            return 0;
        }

        if (dp[n][capacity] != 0) {
            return dp[n][capacity];
        }

        if (weights[n - 1] <= capacity) {
            dp[n][capacity] = Math.max(
                    values[n - 1] + solve(weights, values, capacity - weights[n - 1], n - 1, dp),
                    solve(weights, values, capacity, n - 1, dp));
        } else { // (weights[n - 1] > capacity) //
            dp[n][capacity] = solve(weights, values, capacity, n - 1, dp);

        }

        return dp[n][capacity];
    }

    // Time -> O(n * capacity) //
    // Space -> O(n * capacity) //

    private static int zeroOneKnapsack(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int capacity = 7;
        int n = 4;

        System.out.println(zeroOneKnapsack(weights, values, capacity, n));

        int[][] dp = new int[n + 1][capacity + 1];

        System.out.println(solve(weights, values, capacity, n, dp));
    }
}