/*
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed. All houses at this place are
 * arranged in a circle. That means the first house is the neighbor of the last
 * one. Meanwhile, adjacent houses have a security system connected, and it will
 * automatically contact the police if two adjacent houses were broken into on
 * the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 */

public class HouseRobberII {
    public static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0 || n == 1) {
            return n == 0 ? 0 : nums[0];
        }

        int robWithStart = robStreet(nums, 0, n - 1);
        int robWithEnd = robStreet(nums, 1, n);

        int result = Math.max(robWithStart, robWithEnd);

        return result;
    }

    public static int robStreet(int[] nums, int start, int end) {
        int prev1 = nums[start], prev2 = 0, n = end;

        for (int i = start + 1; i < n; i++) {
            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 2 };

        int answer = rob(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int rob(int[] nums) {
// if (nums.length == 1)
// return nums[0];
// int[] num1 = new int[nums.length - 1];
// int[] num2 = new int[nums.length - 1];
// for (int i = 0; i < nums.length - 1; i++) {
// num1[i] = nums[i];
// }
// for (int i = 1; i < nums.length; i++) {
// num2[i - 1] = nums[i];
// }
// return Math.max(robCheck(num1), robCheck(num2));

// }

// public int robCheck(int[] nums) {
// int[] dp = new int[nums.length];
// Arrays.fill(dp, -1);
// dp[0] = nums[0];
// for (int i = 1; i < nums.length; i++) {
// int pick = nums[i];
// if (i > 1)
// pick += dp[i - 2];
// int nonPick = dp[i - 1];
// dp[i] = Math.max(pick, nonPick);
// }
// return dp[nums.length - 1];
// }
// }