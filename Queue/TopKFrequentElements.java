/*
 * Given an integer array nums and an integer k, return the k most frequent
 * elements. You may return the answer in any order.
 */

import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    // Time -> O(n * log(k)) //
    // Space -> O(k) //

    private static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> map.get(a) - map.get(b));

        for (int key : map.keySet()) {
            minHeap.offer(key);

            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        int i = k - 1;

        while (!minHeap.isEmpty()) {
            result[i--] = minHeap.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;

        int[] ans = topKFrequent(nums, k);

        for (int an : ans) {
            System.out.print(an + " ");
        }
    }
}