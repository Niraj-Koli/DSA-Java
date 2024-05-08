/*
 * Given an array arr[] and an integer K where K is smaller than size of array,
 * the task is to find the Kth smallest element in the given array. It is given
 * that all array elements are distinct.
 */

import java.util.PriorityQueue;

class KthSmallestElementInAnArray {

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
            if (nums[j] <= pivot) {
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

    private static int findKthSmallest(int[] nums, int k) {
        int n = nums.length;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> Integer.compare(b, a));

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

        System.out.println(findKthSmallest(nums, k));
        System.out.println(quickSelect(nums, 0, nums.length - 1, k));
    }
}