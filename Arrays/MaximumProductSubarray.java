/*
 * Given an integer array nums, find a
 * subarray
 * that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */

class MaximumProductSubarray {

    // Time -> O(n) //
    // Space -> O(1) //

    private static int maxProduct(int[] nums) {
        int n = nums.length;

        int prefix = 1;
        int suffix = 1;

        int max = nums[0];

        for (int i = 0; i < n; i++) {
            prefix = prefix == 0 ? 1 : prefix;
            suffix = suffix == 0 ? 1 : suffix;

            prefix *= nums[i];
            suffix *= nums[n - 1 - i];

            max = Math.max(max, Math.max(prefix, suffix));
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };

        System.out.println(maxProduct(nums));
    }
}