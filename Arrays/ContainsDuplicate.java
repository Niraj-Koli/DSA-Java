/*
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 */

import java.util.HashSet;

public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        int len = nums.length;

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < len; i++) {
            if (set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        boolean result = containsDuplicate(nums);

        System.out.println(result);
    }
}

// LeetCode //

// class Solution {
// public boolean containsDuplicate(int[] nums) {
// for (int i = 1; i < nums.length; i++) {
// int current = nums[i];
// int j = i - 1;
// while (j >= 0 && nums[j] > current) {
// nums[j + 1] = nums[j];
// j--;
// }

// if (j >= 0 && nums[j] == current)
// return true;
// nums[j + 1] = current;
// }

// return false;
// }
// }