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

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] t = new int[n + 1][amount + 1];

        for (int j = 0; j < n + 1; j++) {
            t[j][0] = 0;
        }

        for (int i = 0; i < amount + 1; i++) {
            t[0][i] = Integer.MAX_VALUE - 1;
        }

        for (int k = 1; k < amount + 1; k++) {
            if (k % coins[0] == 0) {
                t[1][k] = k / coins[0];
            } else {
                t[1][k] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < amount + 1; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
    }

    public static void main(String[] args) {
        int[] coins = { 2, 5, 10, 1 };
        int amount = 27;

        int answer = coinChange(coins, amount);

        System.out.println(answer);
    }
}

// class Solution {
// public int coinChange(int[] coins, int amount) {
// Arrays.sort(coins);
// boolean allMultiply = true;

// for (int i = 1; i < coins.length; ++i) {

// if (coins[i] % coins[0] != 0) {
// allMultiply = false;
// break;
// }
// }

// if (allMultiply && (amount % coins[0]) != 0) {
// return -1;
// }

// int minCount = Integer.MAX_VALUE;
// int[] counts = new int[coins.length];
// int i = coins.length - 1;
// int count = amount / coins[i];
// int amount1 = amount - count * coins[i];

// if (amount1 == 0) {
// return count;
// }

// if (coins[0] * (count + 1) == amount) {
// return count + 1;
// }

// if (count == amount / coins[0]) {
// return -1;
// }

// counts[i] = count;
// amount = amount1;

// while (true) {
// if (count >= minCount || i <= 0) {
// count -= counts[i];
// amount += counts[i] * coins[i];

// do {
// ++i;

// if (i >= coins.length) {
// return minCount < Integer.MAX_VALUE ? minCount : -1;
// }

// } while (counts[i] == 0);
// --counts[i];
// --count;
// amount += coins[i];
// }

// --i;
// counts[i] = 0;

// while (amount >= coins[i]) {
// amount -= coins[i];
// ++counts[i];
// }

// count += counts[i];

// if (amount == 0 && count < minCount) {
// minCount = count;
// }
// }
// }
// }