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

class KthLargestElementInAnArray {

    // Time -> O(n) && θ(n^2) //
    // Space -> O(log(k)) && θ(n) //

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];

        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (nums[j] >= pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        swap(nums, i + 1, right);

        return i + 1;
    }

    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) {
            return nums[left];
        }

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k - 1) {
            return nums[pivotIndex];
        } else if (pivotIndex < k - 1) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static int findKthLargest(int[] nums, int k) {
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

        System.out.println(findKthLargest(nums, k));
        System.out.println(quickSelect(nums, 0, nums.length - 1, k));
    }
}