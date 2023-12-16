/*
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given
 * that all array elements are distinct.
 */

import java.util.Collections;
import java.util.PriorityQueue;

public class KthSmallestElementInAnArray {
    public static int findKthSmallest(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            maxHeap.offer(nums[i]);

            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 7, 10, 4, 3, 20, 15 };
        int k = 3;

        int answer = findKthSmallest(nums, k);

        System.out.println(answer);
    }
}