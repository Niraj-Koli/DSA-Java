/*
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;

        int i = 0;
        int j = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(Collections.reverseOrder());

        int[] result = new int[len + 1 - k];

        while (j < len) {
            heap.add(nums[j]);

            if (j - i + 1 == k) {
                result[i] = heap.peek();

                heap.remove(nums[i]);
                i++;
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int[] answer = maxSlidingWindow(nums, k);

        for (int ans : answer) {
            System.out.print(ans + " ");
        }
    }
}

// LeetCode //

// public class Solution {
// public static int[] maxSlidingWindow(int[] nums, int k) {
// int len = nums.length;

// int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };

// int[] answer = new int[len - k + 1];
// int answerIndex = 0;

// Deque<Integer> deque = new ArrayDeque<>();

// for (int i = 0; i < len; i++) {
// while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
// deque.pollFirst();
// }

// while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
// deque.pollLast();
// }

// deque.addLast(i);

// if (i >= k - 1) {
// answer[answerIndex++] = nums[deque.peekFirst()];
// }
// }

// return answer;
// }
// }
