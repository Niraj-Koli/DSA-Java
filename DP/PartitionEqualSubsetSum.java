/*
 * Given an integer array nums, return true if you can partition the array into
 * two subsets such that the sum of the elements in both subsets is equal or
 * false otherwise.
 */

public class PartitionEqualSubsetSum {
    public static boolean isSubsetSum(int[] nums, int sum) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int j = 0; j < n + 1; j++) {
            dp[j][0] = true;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][sum];
    }

    public static boolean canPartition(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            return isSubsetSum(nums, sum / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };

        boolean answer = canPartition(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean canPartition(int[] nums) {
// int totalSum = 0;

// for (int num : nums) {
// totalSum += num;
// }

// if (totalSum % 2 != 0) {
// return false;
// }

// int targetSum = totalSum / 2;

// boolean[] dp = new boolean[targetSum + 1];
// dp[0] = true;

// for (int num : nums) {
// for (int j = targetSum; j >= num; j--) {
// dp[j] = dp[j] || dp[j - num];
// }
// }

// return dp[targetSum];
// }
// }