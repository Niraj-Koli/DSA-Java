/*
 * Given an integer array nums, rotate the array to the right by k steps, where
 * k is non-negative.
 */

public class RotateArray {

    // Time -> O(n)
    // Space -> O(1)

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    private static void rotate(int[] nums, int k) {
        int n = nums.length;

        k %= n;

        if (k < 0) {
            k += n;
        }

        reverse(nums, 0, n - 1 - k);
        reverse(nums, n - k, n - 1);
        reverse(nums, 0, n - 1);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        int k = 3;

        rotate(nums, k);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}