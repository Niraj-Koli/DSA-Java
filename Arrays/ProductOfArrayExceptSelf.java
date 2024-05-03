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

class ProductOfArrayExceptSelf {

    // Time -> O(3 * n) //
    // Space -> O(n) //

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        int[] prefixProducts = new int[n];
        int[] suffixProducts = new int[n];

        prefixProducts[0] = 1;

        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }

        suffixProducts[n - 1] = 1;

        for (int j = n - 2; j >= 0; j--) {
            suffixProducts[j] = suffixProducts[j + 1] * nums[j + 1];
        }

        for (int k = 0; k < n; k++) {
            res[k] = prefixProducts[k] * suffixProducts[k];
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };

        int[] ans = productExceptSelf(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}