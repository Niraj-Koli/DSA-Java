/*
 * Given an array arr[] of length N and an integer X, the task is to find the
 * number of subsets with target equal to X.
 */

class CountOfSubsetsSumWithGivenSum {

    // Time -> O(n * target) //
    // Space -> O(n * target) //

    private static int countOfSubsetsSum(int[] nums, int target) {
        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];

        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][target];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, 6, 8, 10 };
        int target = 10;

        System.out.println(countOfSubsetsSum(nums, target));
    }
}