/*
 * Given a set of N items, each with a weight and a value, represented by the
 * array w and val respectively. Also, a knapsack with weight limit W.
 * The task is to fill the knapsack in such a way that we can get the maximum
 * profit. Return the maximum profit.
 * Note: Each item can be taken any number of times.
 */

public class UnboundedKnapsack {
    public static int knapsack(int[] wt, int[] val, int w, int n) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if (wt[i - 1] <= j) {
                    dp[i][j] = Math.max(val[i - 1] + dp[i][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
        int[] wt = { 1, 3, 4, 5 };
        int[] val = { 6, 1, 7, 7 };
        int w = 8;
        int n = 4;

        int answer = knapsack(wt, val, w, n);

        System.out.println(answer);
    }
}