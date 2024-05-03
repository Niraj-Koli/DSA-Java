/*
 * Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 */

import java.util.HashSet;

class ContainsDuplicate {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean containsDuplicate(int[] nums) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            if (set.contains(nums[i])) {
                return true;
            }

            set.add(nums[i]);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };

        System.out.println(containsDuplicate(nums));
    }
}