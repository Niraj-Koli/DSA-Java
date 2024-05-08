/*
 * Given an array of integers A. There is a sliding window of size B which is
 * moving from the very left of the array to the very right. You can only see
 * the w numbers in the window. Each time the sliding window moves rightwards by
 * one position. You have to find the maximum for each window.
 */

import java.util.ArrayList;
import java.util.ArrayDeque;

class MaximumOfAllSubarraysOfSizeK {

    // Time -> O(n) //
    // Space -> O(n) //

    private static ArrayList<Integer> maxSubarrays(int[] nums, int k) {
        int n = nums.length;

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                res.add(nums[deque.peekFirst()]);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        System.out.println(maxSubarrays(nums, k));
    }
}
