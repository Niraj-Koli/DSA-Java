/*
 * Given an array of non-negative integers, and a value target, determine if there
 * is a subset of the given set with target equal to given target.
 */

class SubsetSum {

    // Time -> O(n * target) //
    // Space -> O(n * target) //

    private static boolean isSubsetSum(int[] nums, int target) {
        int n = nums.length;

        boolean[][] dp = new boolean[n + 1][target + 1];

        for (int i = 0; i <= target; i++) {
            dp[0][i] = false;
        }

        for (int j = 0; j <= n; j++) {
            dp[j][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 7, 8, 10 };
        int target = 11;

        System.out.println(isSubsetSum(nums, target));
    }
}