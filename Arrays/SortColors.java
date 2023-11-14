/*
 * Given an array nums with n objects colored red, white, or blue, sort them
 * in-place so that objects of the same color are adjacent, with the colors in
 * the order red, white, and blue.
 * 
 * We will use the integers 0, 1, and 2 to represent the color red, white, and
 * blue, respectively.
 * 
 * You must solve this problem without using the library's sort function.
 */

public class SortColors {
    public static void sortColors(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };

        sortColors(nums);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}

// class Solution {
// public void sortColors(int[] nums) {
// int c0 = 0, c1 = 0, c2 = 0;

// for (int i = 0; i < nums.length; i++) {
// if (nums[i] == 0) {
// c0++;
// } else if (nums[i] == 1) {
// c1++;
// } else {
// c2++;
// }
// }
// for (int i = 0; i < c0; i++) {
// nums[i] = 0;
// }
// for (int i = c0; i < c0 + c1; i++) {
// nums[i] = 1;
// }
// for (int i = c0 + c1; i < c0 + c1 + c2; i++) {
// nums[i] = 2;
// }
// }
// }