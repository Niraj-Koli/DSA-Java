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

class HouseRobberII {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int robStreet(int[] nums, int start, int end) {
        int n = end;

        int prev1 = nums[start];
        int prev2 = 0;

        for (int i = start + 1; i < n; i++) {
            int take = nums[i] + prev2;
            int notTake = prev1;

            int curr = Math.max(take, notTake);

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    private static int rob(int[] nums) {
        int n = nums.length;

        if (n == 0 || n == 1) {
            return n == 0 ? 0 : nums[0];
        }

        int robWithStart = robStreet(nums, 0, n - 1);
        int robWithEnd = robStreet(nums, 1, n);

        int res = Math.max(robWithStart, robWithEnd);

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 2 };

        System.out.println(rob(nums));
    }
}