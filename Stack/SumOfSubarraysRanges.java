/*
 * You are given an integer array nums. The range of a subarray of nums is the
 * difference between the largest and smallest element in the subarray.
 * 
 * Return the sum of all subarray ranges of nums.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an array.
 */

import java.util.ArrayDeque;

public class SumOfSubarraysRanges {

    // Time -> O(n) //
    // Space -> O(n) //

    private static long subArrayRanges(int[] nums) {
        int n = nums.length;
        int j = 0;
        int k = 0;

        long res = 0;

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] > (i == n ? Integer.MIN_VALUE : nums[i])) {
                j = stack.pollLast();
                k = stack.isEmpty() ? -1 : stack.peekLast();
                res -= (long) nums[j] * (i - j) * (j - k);

            }
            stack.offer(i);
        }

        stack.clear();

        for (int i = 0; i <= n; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < (i == n ? Integer.MAX_VALUE : nums[i])) {
                j = stack.pollLast();
                k = stack.isEmpty() ? -1 : stack.peekLast();
                res += (long) nums[j] * (i - j) * (j - k);

            }
            stack.offer(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 4, -2, -3, 4, 1 };

        System.out.println(subArrayRanges(nums));
    }
}