/*
 * Given an array nums containing n distinct numbers in the range [0, n], return
 * the only number in the range that is missing from the array.
 */

import java.util.Arrays;

public class MissingNumber {
    public static int missingNumber(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i != nums[i]) {
                return i;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };

        int answer = missingNumber(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public int missingNumber(int[] nums) {
// int n = nums.length;
// int sumOfAll = n * (n + 1) / 2;
// for (int i : nums) {
// sumOfAll -= i;
// }
// return sumOfAll;
// }
// }