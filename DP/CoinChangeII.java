/*
 * You are given an integer array coins representing coins of different
 * denominations and an integer amount representing a total amount of money.
 * 
 * Return the number of combinations that make up that amount. If that amount of
 * money cannot be made up by any combination of the coins, return 0.
 * 
 * You may asamounte that you have an infinite number of each kind of coin.
 * 
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */

public class CoinChangeII {
    public static int change(int amount, int[] coins) {
        int n = coins.length;

        int[][] t = new int[n + 1][amount + 1];

        for (int i = 0; i < amount + 1; i++) {
            t[0][i] = 0;
        }

        for (int j = 0; j < n + 1; j++) {
            t[j][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = t[i][j - coins[i - 1]] + t[i - 1][j];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 2, 5 };
        int amount = 5;

        int answer = change(amount, coins);

        System.out.println(answer);
    }
}

// class Solution {
// public int change(int amount, int[] coins) {
// int[] dp = new int[amount + 1];
// dp[0] = 1;
// for (int i = coins.length - 1; i >= 0; i--) {
// for (int j = coins[i]; j <= amount; j++) {
// dp[j] += dp[j - coins[i]];
// }
// }
// return dp[amount];
// }
// }