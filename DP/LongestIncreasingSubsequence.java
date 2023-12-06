/*
 * Given an integer array nums, return the length of the longest strictly
 * increasing subsequence.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static int[][] dp = new int[1000][1000];

    public static int lis(int nums[], int n, int curr, int prev) {
        if (curr == n) {
            return 0;
        }

        if (dp[curr][prev + 1] != 0) {
            return dp[curr][prev + 1];
        }

        int pick = ((prev == -1) || nums[curr] > nums[prev]) ? 1 + lis(nums, n, curr + 1, curr) : 0;
        int notPick = 0 + lis(nums, n, curr + 1, prev);

        dp[curr][prev + 1] = Math.max(pick, notPick);

        return dp[curr][prev + 1];
    }

    public static int lisBinarySearch(int[] nums) {
        int n = nums.length;

        ArrayList<Integer> list = new ArrayList<>();

        list.add(nums[0]);

        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);

                len++;
            } else {
                int index = Collections.binarySearch(list, nums[i]);

                if (index < 0) {
                    index = -index - 1;
                }

                list.set(index, nums[i]);
            }
        }
        return len;
    }

    public static int lisSpace(int[] nums) {
        int n = nums.length;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {

                if (nums[prev] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[prev]);
                }
            }
        }

        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    public static int longestIncreasingSubsequence(int[] nums) {
        int n = nums.length;

        int dp[][] = new int[n + 1][n + 1];

        for (int curr = n - 1; curr >= 0; curr--) {
            for (int prev = curr - 1; prev >= -1; prev--) {

                int pick = ((prev == -1) || nums[curr] > nums[prev]) ? 1 + dp[curr + 1][curr + 1] : 0;
                int notPick = 0 + dp[curr + 1][prev + 1];

                dp[curr][prev + 1] = Math.max(pick, notPick);
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };

        int answer = longestIncreasingSubsequence(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int lengthOfLIS(int[] nums) {
// int n = nums.length;
// List<Integer> list = new ArrayList<>();
// list.add(nums[0]);
// for (int i = 1; i < n; i++) {
// if (nums[i] > list.get(list.size() - 1)) {
// list.add(nums[i]);
// } else {
// list.set(f(list, nums[i]), nums[i]);
// }
// }
// return list.size();
// }

// public int f(List<Integer> list, int element) {
// int left = 0;
// int right = list.size() - 1;
// int index = -1;
// while (left <= right) {
// int mid = left + (right - left) / 2;
// if (list.get(mid) < element) {
// left = mid + 1;
// } else {
// right = mid - 1;
// index = mid;
// }
// }
// return index;
// }
// }