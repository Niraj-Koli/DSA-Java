/*
 * Given an integer array nums, return the number of longest increasing
 * subsequences.
 * 
 * Notice that the sequence has to be strictly increasing.
 */

import java.util.Arrays;

public class NumberOfLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] dp = new int[n];
        int[] count = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);

        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {

                if (nums[prev] < nums[i] && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;

                    count[i] = count[prev];
                } else if (nums[prev] < nums[i] && dp[prev] + 1 == dp[i]) {
                    count[i] = count[i] + count[prev];
                }
            }
            max = Math.max(max, dp[i]);
        }

        int noLIS = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == max) {
                noLIS += count[i];
            }
        }

        return noLIS;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };

        int answer = findNumberOfLIS(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int findNumberOfLIS(int[] nums) {
// int n = nums.length;
// int[] lis = new int[n];
// Arrays.fill(lis, 1);
// int[] ways = new int[n];
// Arrays.fill(ways, 1);
// int maxIdx = 0;
// int max = 1;
// for (int i = 0; i < n; i++) {
// for (int j = 0; j < i; j++) {
// if (nums[j] < nums[i] && lis[i] < lis[j] + 1) {
// lis[i] = lis[j] + 1;
// if (max < lis[i]) {
// max = lis[i];
// maxIdx = i;
// }
// ways[i] = ways[j];
// } else if (nums[j] < nums[i] && lis[i] == lis[j] + 1) {
// ways[i] = ways[i] + ways[j];
// }
// }
// }
// int cnt = 0;
// for (int i = 0; i < n; i++) {
// if (lis[i] == max) {
// cnt += ways[i];
// }
// }
// return cnt;
// }
// }