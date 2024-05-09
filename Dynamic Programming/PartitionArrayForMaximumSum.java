/*
 * Given an integer array arr, partition the array into (contiguous) subarrays
 * of length at most k. After partitioning, each subarray has their values
 * changed to become the maximum value of that subarray.
 * 
 * Return the largest sum of the given array after partitioning. Test cases are
 * generated so that the answer fits in a 32-bit integer.
 */

class PartitionArrayForMaximumSum {

    // Time -> O(n * k) //
    // Space -> O(n) //

    private static int maxSumAfterPartitioning(int[] nums, int k) {
        int n = nums.length;

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int curMax = 0;
            int max = 0;

            for (int j = 1; j <= k && i - j >= 0; j++) {
                curMax = Math.max(curMax, nums[i - j]);

                int sum = dp[i - j] + (curMax * j);

                max = Math.max(max, sum);
            }

            dp[i] = max;
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;

        System.out.println(maxSumAfterPartitioning(nums, k));
    }
}