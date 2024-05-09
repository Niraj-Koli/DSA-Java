/*
 * You are given an integer array nums of 2 * n integers. You need to partition
 * nums into two arrays of length n to minimize the absolute difference of the
 * sums of the arrays. To partition nums, put each element of nums into one of
 * the two arrays.
 * 
 * Return the minimum possible absolute difference.
 */

class PartitionArrayIntoTwoArraysToMinimizeSumDifference {

    // Time -> O(n * sum) //
    // Space -> O(n * sum) //

    private static int minimumDifference(int[] nums) {
        int n = nums.length;

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        boolean[][] dp = new boolean[n][sum + 1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        if (nums[0] <= sum) {
            dp[0][sum] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= sum; i++) {
            if (dp[n - 1][i]) {
                int diff = Math.abs(i - (sum - i));
                min = Math.min(min, diff);
            }
        }

        return min;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 6, 5 };

        System.out.println(minimumDifference(nums));
    }
}