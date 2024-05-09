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

class TargetSum {

    // Time -> O(n * sum) //
    // Space -> O(n * sum) //

    private static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;

        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (Math.abs(target) > total || (total + target) % 2 != 0) {
            return 0;
        }

        int sum = (total + target) / 2;

        int[][] dp = new int[n + 1][sum + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
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

        System.out.println(findTargetSumWays(nums, target));
    }
}