/*
 * Given an integer array nums, find a
 * subarray
 * that has the largest product, and return the product.
 * 
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 */

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        int product = 1;
        int max = Integer.MIN_VALUE;

        while (j < len) {
            if (nums[j] == 0) {
                max = Math.max(max, 0);

                while (i < j - 1) {
                    product /= nums[i];

                    max = Math.max(max, product);

                    i++;
                }

                product = 1;

                i = j + 1;
            } else {
                product *= nums[j];

                max = Math.max(max, product);
            }
            j++;
        }

        while (i < j - 1) {
            product /= nums[i];

            max = Math.max(max, product);

            i++;
        }

        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };

        int answer = maxProduct(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int maxProduct(int[] nums) {
// int max = Integer.MIN_VALUE;
// int curr = 1;
// for (int i = 0; i < nums.length; i++) {
// curr *= nums[i];
// max = Math.max(max, curr);
// if (curr == 0) {
// curr = 1;
// }
// }
// curr = 1;
// for (int i = nums.length - 1; i >= 0; i--) {
// curr *= nums[i];
// max = Math.max(curr, max);
// if (curr == 0) {
// curr = 1;
// }
// }
// System.gc();
// return max;
// }
// }