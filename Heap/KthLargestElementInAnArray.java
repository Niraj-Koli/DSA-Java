/*
 * Given an integer array nums and an integer k, return the kth largest element
 * in the array.
 * 
 * Note that it is the kth largest element in the sorted order, not the kth
 * distinct element.
 * 
 * Can you solve it without sorting?
 */

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            minHeap.offer(nums[i]);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        int k = 4;

        int answer = findKthLargest(nums, k);

        System.out.println(answer);
    }
}

// class Solution {
// public int findKthLargest(int[] nums, int k) {
// Arrays.sort(nums);
// return nums[nums.length - k];
// }
// }