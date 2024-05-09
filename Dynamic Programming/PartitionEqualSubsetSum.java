/*
 * Given an integer array nums, return true if you can partition the array into
 * two subsets such that the target of the elements in both subsets is equal or
 * false otherwise.
 */

class PartitionEqualSubsetSum {

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

    private static boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (sum % 2 != 0) {
            return false;
        } else {
            return isSubsetSum(nums, sum / 2);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 11, 5 };

        System.out.println(canPartition(nums));
    }
}