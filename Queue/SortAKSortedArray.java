/*
 * Given an array of n elements, where each element is at most k away from its
 * target position, you need to sort the array optimally.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

class SortAKSortedArray {

    // Time -> O(n * log(k)) //
    // Space -> O(n) //

    private static ArrayList<Integer> nearlySorted(int[] nums, int k) {
        int n = nums.length;

        ArrayList<Integer> res = new ArrayList<Integer>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            minHeap.offer(nums[i]);

            if (minHeap.size() > k) {
                res.add(minHeap.poll());
            }
        }

        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;

        System.out.println(nearlySorted(nums, k));
    }
}