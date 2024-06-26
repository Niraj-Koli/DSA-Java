/*
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum.
 */

class KadaneAlgorithm {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int maxSubArray(int[] nums) {
        int n = nums.length;

        int maxSum = nums[0];
        int currentMax = nums[0];

        int start = 0;
        int end = 0;
        int tempStart = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] > currentMax + nums[i]) {
                currentMax = nums[i];
                tempStart = i;
            } else {
                currentMax += nums[i];
            }

            if (currentMax > maxSum) {
                maxSum = currentMax;
                start = tempStart;
                end = i;
            }
        }

        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(maxSubArray(nums));
    }
}