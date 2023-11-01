/*
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to
 * target. If there is no such subarray, return 0 instead.
 */

public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        int minLen = Integer.MAX_VALUE;
        int sum = 0;

        while (j < len) {
            sum += nums[j];

            while (sum >= target) {
                minLen = Math.min(minLen, j - i + 1);

                sum -= nums[i];
                i++;
            }
            j++;
        }

        int ans = minLen != Integer.MAX_VALUE ? minLen : 0;

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        int result = minSubArrayLen(target, nums);

        System.out.println(result);
    }
}

// LeetCode //

// class Solution {
// public int minSubArrayLen(int target, int[] nums) {
// int left = 0;
// int right = 0;
// int sum = 0;
// int path = Integer.MAX_VALUE;
// while (right < nums.length) {
// sum = sum + nums[right];
// if (sum >= target) {
// while (sum >= target) {
// sum = sum - nums[left];
// left++;
// }
// if ((right - left + 2) < path) {
// path = (right - left + 2);
// }
// }

// right++;
// }

// System.gc();
// if (path == Integer.MAX_VALUE) {
// return 0;
// }
// return path;
// }
// }