/*
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] <
 * nums[k] < nums[j].
 * 
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 */

import java.util.ArrayDeque;

public class OneThreeTwoPattern {
    public static boolean find132pattern(int[] nums) {
        int currentMin = Integer.MAX_VALUE;

        ArrayDeque<int[]> stack = new ArrayDeque<int[]>();

        for (int currentNumber : nums) {
            while (!stack.isEmpty() && currentNumber >= stack.peekLast()[0]) {
                stack.pollLast();
            }

            if (!stack.isEmpty() && currentNumber > stack.peekLast()[1]) {
                return true;
            }

            stack.offerLast(new int[] { currentNumber, currentMin });

            currentMin = Math.min(currentMin, currentNumber);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 3, 2, 0 };

        boolean answer = find132pattern(nums);

        System.out.println(answer);
    }
}

// class Solution {
// public boolean find132pattern(int[] nums) {
// int p = -2;
// int min = Integer.MAX_VALUE;
// for (int i = 0; i < nums.length; i++) {
// int val = nums[i];
// if (val <= min) {
// min = val;
// } else {
// while (p >= 0 && nums[p] <= val)
// p -= 2;
// if (p >= 0 && nums[p + 1] < val)
// return true; // a3 > val, a1 < val
// p += 2;
// nums[p] = val;
// nums[p + 1] = min;
// }
// }
// return false;
// }
// }