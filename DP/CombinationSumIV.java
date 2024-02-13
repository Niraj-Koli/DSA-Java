/*
 * Given an array of distinct integers nums and a target integer target, return
 * the number of possible combinations that add up to target.
 * 
 * The test cases are generated so that the answer can fit in a 32-bit integer.
 */

public class CombinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        int n = nums.length;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < n; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        int target = 4;

        int ans = combinationSum4(nums, target);

        System.out.println(ans);
    }
}

// class Solution {
// private int helper(int[] nums, int target, int[] dp) {
// if (dp[target] != -1) {
// return dp[target];
// }

// int count = 0;
// for (int num : nums) {
// if (target >= num) {
// count += helper(nums, target - num, dp);
// }
// }

// dp[target] = count;
// return count;
// }

// public int combinationSum4(int[] nums, int target) {
// int[] dp = new int[target + 1];
// Arrays.fill(dp, -1);
// dp[0] = 1;
// return helper(nums, target, dp);

// }
// }