/*
 * Given an integer array nums and an integer k, split nums into k non-empty
 * subarrays such that the largest sum of any subarray is minimized.
 * 
 * Return the minimized largest sum of the split.
 * 
 * A subarray is a contiguous part of the array.
 */

public class SplitArrayLargestSum {

    // Time -> O(n * log(sum - max + 1))
    // Space -> O(1)

    private static int countSubarrays(int[] nums, int maxSum) {
        int n = nums.length;

        int partitions = 1;
        int subarraySum = 0;

        for (int i = 0; i < n; i++) {
            if (subarraySum + nums[i] > maxSum) {
                partitions++;
                subarraySum = 0;
            }

            subarraySum += nums[i];
        }

        return partitions;
    }

    private static int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;

        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        while (left <= right) {
            int mid = left + ((right - left) / 2);

            int partitions = countSubarrays(nums, mid);

            if (partitions <= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;

        System.out.println(splitArray(nums, k));
    }
}