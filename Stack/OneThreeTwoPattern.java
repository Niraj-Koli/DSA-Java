/*
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] <
 * nums[k] < nums[j].
 * 
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 */

import java.util.ArrayDeque;

class OneThreeTwoPattern {

    // Time -> O(n) //
    // Space -> O(n) //

    private static boolean find132pattern(int[] nums) {
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

        System.out.println(find132pattern(nums));
    }
}