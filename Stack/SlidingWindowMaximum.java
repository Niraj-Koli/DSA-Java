/*
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 */

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    // Time -> O(n) //
    // Space -> O(k) //

    private static int[] maxSlidingWindowDQ(int[] nums, int k) {
        int n = nums.length;

        int[] res = new int[n - k + 1];
        int index = 0;

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }

            deque.offer(i);

            if (i >= k - 1) {
                res[index++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static int[] maxSlidingWindowPQ(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);

        int[] res = new int[n + 1 - k];

        for (int i = 0, j = 0; j < n; j++) {
            maxHeap.offer(nums[j]);

            if (j - i + 1 == k) {
                res[i] = maxHeap.peek();

                maxHeap.remove(nums[i]);
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;

        int[] ans = maxSlidingWindowPQ(nums, k);

        for (int an : ans) {
            System.out.print(an + " ");
        }

        System.out.println();

        int[] outcome = maxSlidingWindowDQ(nums, k);

        for (int out : outcome) {
            System.out.print(out + " ");
        }
    }
}