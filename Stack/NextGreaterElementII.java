/*
 * Given a circular integer array nums (i.e., the next element of
 * nums[nums.length - 1] is nums[0]), return the next greater number for every
 * element in nums.
 * 
 * The next greater number of a number x is the first greater number to its
 * traversing-order next in the array, which means you could search circularly
 * to find its next greater number. If it doesn't exist, return -1 for this
 * number.
 */

import java.util.ArrayDeque;
import java.util.Arrays;

public class NextGreaterElementII {

    // Time -> O(n) //
    // Space -> O(n) //

    private static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        int[] res = new int[n];
        Arrays.fill(res, -1);

        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        for (int i = 0; i < n * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()] < nums[i % n]) {
                res[stack.pollLast()] = nums[i % n];
            }
            stack.offer(i % n);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 3 };

        int[] ans = nextGreaterElements(nums);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}