/*
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 */

public class KadaneAlgorithm {
    public static int maxSubArray(int[] nums) {
        int len = nums.length;

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < len; i++) {
            maxEndingHere += nums[i];

            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 4, -1, 7, 8 };

        int answer = maxSubArray(nums);

        System.out.println(answer);
    }
}

// LeetCode //

// class Solution {
// public int maxSubArray(int[] nums) {
// int max = Integer.MIN_VALUE, sum = 0;

// for (int num : nums) {
// sum += num;

// max = Math.max(sum, max);

// if (sum < 0) {
// sum = 0;
// }
// }

// return max;
// }
// }