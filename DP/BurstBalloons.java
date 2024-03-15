/*
 * You are given n balloons, indexed from 0 to n - 1. Each balloon is painted
 * with a number on it represented by an array nums. You are asked to burst all
 * the balloons.
 * 
 * If you burst the ith balloon, you will get nums[i - 1] * nums[i] * nums[i +
 * 1] coins. If i - 1 or i + 1 goes out of bounds of the array, then treat it as
 * if there is a balloon with a 1 painted on it.
 * 
 * Return the maximum coins you can collect by bursting the balloons wisely.
 */

public class BurstBalloons {

    // Time -> O(n^3) //
    // Space -> O(n^2) //

    private static int maxCoins(int[] nums) {
        int n = nums.length;

        int[] balloons = new int[n + 2];

        balloons[0] = 1;
        balloons[n + 1] = 1;

        for (int i = 0; i < n; i++) {
            balloons[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= n; j++) {
                if (i > j) {
                    continue;
                }

                int max = Integer.MIN_VALUE;

                for (int k = i; k <= j; k++) {
                    int cost = balloons[i - 1] * balloons[k] * balloons[j + 1] + dp[i][k - 1] + dp[k + 1][j];

                    max = Math.max(max, cost);
                }

                dp[i][j] = max;
            }
        }

        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };

        System.out.println(maxCoins(nums));
    }
}