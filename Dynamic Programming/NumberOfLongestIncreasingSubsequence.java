/*
 * Given an integer array nums, return the number of longest increasing
 * subsequences.
 * 
 * Notice that the sequence has to be strictly increasing.
 */

import java.util.Arrays;

class NumberOfLongestIncreasingSubsequence {

    // Time -> O(n^2) //
    // Space -> O(n) //

    private static int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;

                    count[i] = count[j];
                } else if (nums[j] < nums[i] && dp[j] + 1 == dp[i]) {
                    count[i] = count[i] + count[j];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int res = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                res += count[i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };

        System.out.println(findNumberOfLIS(nums));
    }
}