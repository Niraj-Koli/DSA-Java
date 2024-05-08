/*
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a subarray whose sum is greater than or equal to
 * target. If there is no such subarray, return 0 instead.
 */

class MinimumSizeSubarraySum {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0, j = 0; j < n; j++) {
            sum += nums[j];

            while (sum >= target) {
                min = Math.min(min, j - i + 1);

                sum -= nums[i];
                i++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;

        System.out.println(minSubArrayLen(target, nums));
    }
}