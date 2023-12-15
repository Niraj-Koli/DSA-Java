/*
 * You are given weights and values of N items, put these items in a knapsack of
 * capacity W to get the maximum total value in the knapsack. Note that we have
 * only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which
 * represent values and weights associated with N items respectively. Also given
 * an integer W which represents knapsack capacity, find out the maximum value
 * subset of val[] such that sum of the weights of this subset is smaller than
 * or equal to W. You cannot break an item, either pick the complete item or
 * dont pick it (0-1 property).
 */

public class ZeroOneKnapsack {
    public static int[][] dp;

    public static int knapsack(int[] wt, int[] val, int w, int n) {
        dp = new int[n + 1][w + 1];

        return calculateKnapsack(wt, val, w, n);
    }

    public static int calculateKnapsack(int[] wt, int[] val, int w, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }

        if (dp[n][w] != 0) {
            return dp[n][w];
        }

        if (wt[n - 1] <= w) {
            dp[n][w] = Math.max(val[n - 1] + calculateKnapsack(wt, val, w - wt[n - 1], n - 1),
                    calculateKnapsack(wt, val, w, n - 1));

            return dp[n][w];
        } else { // (wt[n - 1] > w) //
            dp[n][w] = calculateKnapsack(wt, val, w, n - 1);
            return dp[n][w];
        }
    }

    public static int zeroOneKnapsack(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = { 1, 3, 4, 5 };
        int[] val = { 1, 4, 5, 7 };
        int w = 7;
        int n = wt.length;

        int answer = knapsack(wt, val, w, n);

        System.out.println(answer);
    }
}