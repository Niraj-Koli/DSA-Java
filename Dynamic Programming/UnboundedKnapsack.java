/*
 * Given a set of N items, each with a weight and a value, represented by the
 * array capacity and values respectively. Also, a knapsack with weight limit W.
 * The task is to fill the knapsack in such a way that we can get the maximum
 * profit. Return the maximum profit.
 * Note: Each item can be taken any number of times.
 */

class UnboundedKnapsack {

    // Time -> O(n * capacity) //
    // Space -> O(n * capacity) //

    private static int knapsack(int[] weights, int[] values, int capacity, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] <= j) {
                    dp[i][j] = Math.max(values[i - 1] + dp[i][j - weights[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 6, 1, 7, 7 };
        int capacity = 8;
        int n = 4;

        System.out.println(knapsack(weights, values, capacity, n));
    }
}