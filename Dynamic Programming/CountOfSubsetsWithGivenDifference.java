/*
 * Given an array arr[] of size N and a given difference diff, the task is to
 * count the number of partitions that we can perform such that the difference
 * between the target of the two subsets is equal to the given difference.
 */

class CountOfSubsetsWithGivenDifference {

    // Time -> O(n * target) //
    // Space -> O(n * target) //

    private static int countOfSubsetsDifference(int[] nums, int diff) {
        int n = nums.length;

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (Math.abs(diff) > sum || (sum + diff) % 2 != 0) {
            return 0;
        }

        int target = (sum + diff) / 2;

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
        int[] nums = { 1, 1, 2, 3 };
        int target = 1;

        System.out.println(countOfSubsetsDifference(nums, target));
    }
}