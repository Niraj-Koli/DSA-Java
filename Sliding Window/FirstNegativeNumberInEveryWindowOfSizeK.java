/*
 * Given an array A[] of size N and a positive integer K, find the first
 * negative integer for each and every window(contiguous subarray) of size K.
 */

import java.util.ArrayList;

class FirstNegativeNumberInEveryWindowOfSizeK {

    // Time -> O(n) //
    // Space -> O(n) //

    private static ArrayList<Integer> firstNegative(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> support = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0, j = 0; j < n; j++) {
            if (nums[j] < 0) {
                support.add(nums[j]);
            }

            if (j - i + 1 == k) {
                if (support.isEmpty()) {
                    result.add(0);
                } else {
                    result.add(support.get(0));
                }

                support.remove(Integer.valueOf(nums[i]));
                i++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 12, -1, -7, 8, -15, 30, 16, 28 };
        int k = 3;

        System.out.println(firstNegative(nums, k));
    }
}