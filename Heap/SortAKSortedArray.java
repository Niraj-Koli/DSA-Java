/*
 * Given an array of n elements, where each element is at most k away from its
 * target position, you need to sort the array optimally.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortAKSortedArray {
    public static List<Integer> nearlySorted(int[] nums, int k) {
        int n = nums.length;

        List<Integer> result = new ArrayList<Integer>();

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        for (int i = 0; i < n; i++) {
            minHeap.offer(nums[i]);

            if (minHeap.size() > k) {
                result.add(minHeap.poll());
            }
        }

        while (minHeap.size() > 0) {
            result.add(minHeap.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;

        List<Integer> answer = nearlySorted(nums, k);

        System.out.println(answer);
    }
}