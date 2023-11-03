/*
 * Given an unsorted integer array nums, return the smallest missing positive
 * integer.
 * 
 * You must implement an algorithm that runs in O(n) time and uses O(1)
 * auxiliary space.
 */

import java.util.TreeSet;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length;

        TreeSet<Integer> set = new TreeSet<Integer>();

        int count = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                set.add(nums[i]);
            }
        }

        for (int i = 0; i < set.size(); i++) {
            if (!set.contains(i + 1)) {
                return (i + 1);
            }
            count++;
        }
        return (count + 1);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 4, -1, 1 };

        int answer = firstMissingPositive(nums);

        System.out.println(answer);
    }
}

// LeetCode //

// class Solution {
// public int firstMissingPositive(int[] nums) {
// int smallestPosValue = 0;
// boolean[] storedIdx = new boolean[nums.length];

// for (int i = 0; i < nums.length; i++) {
// if (nums[i] > 0 && (nums[i] <= nums.length)) {
// storedIdx[nums[i] - 1] = true;
// }
// }

// for (int i = 0; i < nums.length; i++) {
// if (storedIdx[i] == false) {
// return i + 1;
// }
// }
// return nums.length + 1;
// }
// }