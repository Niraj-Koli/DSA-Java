/*
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the integers.
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which
 * evaluates to target.
 */

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int totalSum = 0;

        for (int val : nums) {
            totalSum += val;
        }

        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }

        int sum = (totalSum + target) / 2;

        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = 0;
        }

        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        int target = 3;

        int answer = findTargetSumWays(nums, target);

        System.out.println(answer);
    }
}

// class Solution {
// public int findTargetSumWays(int[] nums, int target) {
// int sum = 0;
// for (int num : nums) {
// sum += num;
// }
// if (sum < Math.abs(target) || (sum + target) % 2 == 1) {
// return 0;
// }
// return dpPartitionNum(nums, (sum + target) / 2);
// }

// private int dpPartitionNum(int[] nums, int target) {
// int[] dp = new int[target + 1];
// dp[0] = 1;

// for (int num : nums) {
// for (int j = target; j >= num; j--) {
// dp[j] += dp[j - num];
// }
// }
// return dp[target];
// }
// }