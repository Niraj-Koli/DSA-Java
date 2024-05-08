/*
 * Given an array of integers Arr of size N and a number K. Return the maximum
 * sum of a subarray of size K.
 */

class MaximumSumOfSubarrayOfSizeK {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int maxSum(int[] nums, int k) {
        int n = nums.length;

        int sum = 0;
        int max = 0;

        for (int i = 0, j = 0; j < n; j++) {
            sum += nums[j];

            if (j - i + 1 == k) {
                max = Math.max(max, sum);

                sum -= nums[i];
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 8, 2, 9, 1 };
        int k = 3;

        System.out.println(maxSum(nums, k));
    }
}
