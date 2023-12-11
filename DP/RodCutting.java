/*
 * Given a rod of length N inches and an array of prices, price[]. price[i]
 * denotes the value of a piece of length i. Determine the maximum value
 * obtainable by cutting up the rod and selling the pieces.
 * 
 * Note: Consider 1-based indexing.
 */

public class RodCutting {
    public static int cutRod(int price[], int n) {
        int[] length = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }

        int m = length.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];

                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] price = { 3, 5, 8, 9, 10, 17, 17, 20 };
        int n = 8;

        int answer = cutRod(price, n);

        System.out.println(answer);
    }
}