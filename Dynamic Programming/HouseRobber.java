/*
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 */

class HouseRobber {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int solve(int i, int[] nums, int[] dp) {
        if (i < 0) {
            return 0;
        }

        if (i == 0) {
            return nums[i];
        }

        if (dp[i] != 0) {
            return dp[i];
        }

        int pick = nums[i] + solve(i - 2, nums, dp);
        int nonPick = solve(i - 1, nums, dp);

        dp[i] = Math.max(pick, nonPick);

        return dp[i];
    }

    // Time -> O(n) //
    // Space -> O(n) //

    private static int rob(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];

        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int pick = nums[i];

            if (i > 1) {
                pick += dp[i - 2];
            }
            int nonPick = dp[i - 1];

            dp[i] = Math.max(pick, nonPick);
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };

        System.out.println(rob(nums));

        int n = nums.length;

        int[] dp = new int[n];

        System.out.println(solve(n - 1, nums, dp));
    }
}