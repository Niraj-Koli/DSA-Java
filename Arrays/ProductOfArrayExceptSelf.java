/*
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * 
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * 
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 */

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] result = new int[len];
        int[] prefixProducts = new int[len];
        int[] suffixProducts = new int[len];

        prefixProducts[0] = 1;

        for (int i = 1; i < len; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        suffixProducts[len - 1] = 1;

        for (int j = len - 2; j >= 0; j--) {
            suffixProducts[j] = suffixProducts[j + 1] * nums[j + 1];
        }

        for (int k = 0; k < len; k++) {
            result[k] = prefixProducts[k] * suffixProducts[k];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        int[] answer = productExceptSelf(nums);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

// class Solution {
// public int[] productExceptSelf(int[] nums) {
// int result[] = new int[nums.length];
// int prefix[] = new int[nums.length];
// int suffix[] = new int[nums.length];

// prefix[0] = nums[0];
// for (int i = 1; i < nums.length; i++) {
// prefix[i] = prefix[i - 1] * nums[i];
// }

// suffix[nums.length - 1] = nums[nums.length - 1];
// for (int i = nums.length - 2; i >= 0; i--) {
// suffix[i] = suffix[i + 1] * nums[i];
// }
// result[0] = suffix[1];
// result[nums.length - 1] = prefix[nums.length - 2];
// for (int i = 1; i < nums.length - 1; i++) {
// result[i] = prefix[i - 1] * suffix[i + 1];
// }

// return result;

// }
// }