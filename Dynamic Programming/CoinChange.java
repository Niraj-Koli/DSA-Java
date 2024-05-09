/*
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the fewest number of coins that you need to make up that amount. If
 * that amount of money cannot be made up by any combination of the coins,
 * return -1.
 * 
 * You may assume that you have an infinite number of each kind of coin.
 */

class CoinChange {

    // Time -> O(n * amount) //
    // Space -> O(n * amount) //

    private static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n + 1][amount + 1];

        for (int j = 0; j <= n; j++) {
            dp[j][0] = 0;
        }

        for (int i = 0; i <= amount; i++) {
            dp[0][i] = Integer.MAX_VALUE - 1;
        }

        for (int k = 1; k <= amount; k++) {
            if (k % coins[0] == 0) {
                dp[1][k] = k / coins[0];
            } else {
                dp[1][k] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][amount] == Integer.MAX_VALUE - 1 ? -1 : dp[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 5, 10, 1 };
        int amount = 27;

        System.out.println(coinChange(coins, amount));
    }
}